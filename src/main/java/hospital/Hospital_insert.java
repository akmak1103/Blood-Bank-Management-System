package hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donor_operations.Donor;
import donor_operations.DonorDAO;
import donor_operations.DonorDAOImpl;

/**
 * Servlet implementation class Hospital_insert
 */
public class Hospital_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hospital_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HospitalDAO hDAO = new HospitalDAOImpl();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String add = request.getParameter("Address");
		String bb = request.getParameter("blood_bank");
		Hospital h = new Hospital ();
		h.setId(id);
		System.out.println(h.getId());
		h.setName(name);
		System.out.println(h.getName());
		h.setAddress(add);
		System.out.println(h.getAddress());
		h.setBlood_bank_id(bb);
		System.out.println(h.getId());
		hDAO.insertHospital(h);
		request.setAttribute("successMessage","Hospital Added");
		request.getRequestDispatcher("hospital_add.jsp").forward(request, response);
	}

}
