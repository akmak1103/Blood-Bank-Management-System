package donor_operations;

import java.util.ArrayList;

public interface DonorDAO {

	public int insertDonor(Donor d);
	public Donor getDonor(String username, String password);
	public ArrayList<Donor> selectDonorByCriteria(String inCriteria);
	public int deleteDonor(String contactNo);
	public Donor searchByUsername (String u_name);
	public int updateDonor(Donor new_donor);
}
