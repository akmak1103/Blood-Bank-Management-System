package donor_operations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Donor_login
 */
public class Donor_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Donor_login() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonorDAO dd = new DonorDAOImpl();
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String status = request.getParameter("status");
		String bg = request.getParameter("blood_group");
		String name = request.getParameter("donorname");
		String contact= request.getParameter("contact");
		String add = request.getParameter("address");
		String submitType = request.getParameter("submit");
		Donor d = dd.getDonor(uname, pwd);
		if (submitType.equals("sign_in") && d.getPassword()!=null)
		{
			request.setAttribute("message",uname);
			request.getRequestDispatcher("donor_welcome.jsp").forward(request, response);
		}
		else if (submitType.equals("register"))
		{
			d.setUsername(uname);
			System.out.println(d.getUsername());
			d.setPassword(pwd);
			System.out.println(d.getPassword());
			d.setName(name);
			System.out.println(d.getName());
			d.setContact(contact);
			System.out.println(d.getContact());
			d.setBlood_group(bg);
			System.out.println(d.getBlood_group());
			d.setAddress(add);
			System.out.println(d.getAddress());
			d.setStatus(status);
			System.out.println(d.getStatus());
			dd.insertDonor(d);
			request.setAttribute("successMessage","Registration Successfull, please login.");
			request.getRequestDispatcher("donor_login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message","Username/Password combination does not match!");
			request.getRequestDispatcher("donor_login.jsp").forward(request, response);
		}
	}

}
