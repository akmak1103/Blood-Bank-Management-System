package hospital;

import java.util.ArrayList;

public interface HospitalDAO {
	public int insertHospital(Hospital h);
	public ArrayList<Hospital> selectHospitalByCriteria(String inCriteria);
	public Hospital searchByID (String id);
	public int updateHospital(Hospital new_hospital);
}
