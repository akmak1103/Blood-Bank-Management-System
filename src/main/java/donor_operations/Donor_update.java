package donor_operations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Donor_update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Donor_update() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DonorDAOImpl dd = new DonorDAOImpl();
		String submitType = request.getParameter("submit");
		if (submitType.equals("update_donor")) {
			Donor new_donor = new Donor();
			String uname = request.getParameter("username");
			System.out.println(request.getParameter("username"));
			String pwd = request.getParameter("password");
			String status = request.getParameter("status");
			String bg = request.getParameter("blood_group");
			String name = request.getParameter("donorname");
			String contact = request.getParameter("contact");
			String add = request.getParameter("address");
			new_donor.setUsername(uname);
			new_donor.setPassword(pwd);
			new_donor.setName(name);
			new_donor.setContact(contact);
			new_donor.setBlood_group(bg);
			new_donor.setAddress(add);
			new_donor.setStatus(status);
			int updated_Donor = dd.updateDonor(new_donor);
			request.setAttribute("Old_Donor", new_donor);
			if (updated_Donor == 1)
				request.setAttribute("successMessage", "1 Donor Updated Successfully!");
			else
				request.setAttribute("successMessage", "Error in Updating");
			request.getRequestDispatcher("donor_update.jsp").forward(request, response);
		}

		else {
			String username = request.getParameter("username");
			Donor old_donor = dd.searchByUsername(username);
			if (old_donor.getUsername()!=null)
			{
				request.setAttribute("Old_Donor", old_donor);
				request.getRequestDispatcher("donor_update.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("message","Donor not found. Please check your input.");
				request.getRequestDispatcher("search_username.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
