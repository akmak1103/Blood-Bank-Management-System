package admin_access;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donor_operations.Donor;
import donor_operations.DonorDAO;
import donor_operations.DonorDAOImpl;

/**
 * Servlet implementation class Admin_login
 */
public class Admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_login() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("loggedIn")=="true")
			request.getRequestDispatcher("admin_welcome.jsp").forward(request, response);
		AdminDAO aDAO = new AdminDAOImpl();
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Admin a = aDAO.getAdmin(uname, pwd);
		if (submitType.equals("admin_sign_in") && a.getPassword()!=null)
		{
			Cookie loginCookie = new Cookie("user",uname);
			loginCookie.setMaxAge(60);
			response.addCookie(loginCookie);
			request.getRequestDispatcher("admin_welcome.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message","Username/Password combination does not match!");
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
	}

}
