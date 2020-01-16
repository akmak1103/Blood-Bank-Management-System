package hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hospital_update
 */
public class Hospital_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hospital_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HospitalDAOImpl hDAO = new HospitalDAOImpl();
		String submitType = request.getParameter("submit");
		if (submitType.equals("update_hospital")) {
			Hospital new_hospital = new Hospital();
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String add = request.getParameter("address");
			String bb = request.getParameter("blood_bank");
			new_hospital.setId(id);
			new_hospital.setName(name);
			new_hospital.setAddress(add);
			new_hospital.setBlood_bank_id(bb);
			int updated_Hospital = hDAO.updateHospital(new_hospital);
			request.setAttribute("Old_Hospital", new_hospital);
			if (updated_Hospital == 1)
				request.setAttribute("successMessage", "1 Hospital Updated Successfully!");
			else
				request.setAttribute("successMessage", "Error in Updating");
			request.getRequestDispatcher("hospital_update.jsp").forward(request, response);
		}

		else {
			String id = request.getParameter("id");
			Hospital old_hospital = hDAO.searchByID(id);
			if (old_hospital.getId()!=null)
			{
				request.setAttribute("Old_Hospital", old_hospital);
				request.getRequestDispatcher("hospital_update.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("message","Hospital not found. Please check your input.");
				request.getRequestDispatcher("search_hospital_by_id.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
