package donor_operations;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Donor_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    
    public Donor_delete() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contact = request.getParameter("contactNo");
		DonorDAOImpl dd = new DonorDAOImpl();
		int status = dd.deleteDonor(contact);
		if (status==0)
		{
			request.setAttribute("message","Unsuccessful Operation!");
			request.getRequestDispatcher("donor_delete.jsp").forward(request, response);
		}
		else if (status!=0)
		{
			request.setAttribute("message","1 Donor Deleted Successfully");
			request.getRequestDispatcher("donor_delete.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
