package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import donor_operations.ConnectionProvider;

public class HospitalDAOImpl implements HospitalDAO {
	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertHospital(Hospital h) {
		int status = 0;
		try {
			con = ConnectionProvider.getCon();
			ps = con.prepareStatement("insert into hospital values (?,?,?,?)");
			ps.setString(1, h.getId());
			ps.setString(2, h.getName());
			ps.setString(3, h.getAddress());
			ps.setString(4, h.getBlood_bank_id());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<Hospital> selectHospitalByCriteria(String inCriteria) {
		ArrayList<Hospital> hospitalList = new ArrayList();
		try {
			con = ConnectionProvider.getCon();
			String lSqlString = "select * from hospital";
			if (inCriteria != null && inCriteria.length() > 0) {
				lSqlString = lSqlString + " " + inCriteria;
			}
			lSqlString = lSqlString + " ORDER BY id";
			ps = con.prepareStatement(lSqlString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hospital h = new Hospital();
				h.setAddress(rs.getString("address"));
				h.setBlood_bank_id(rs.getString("blood_Bank_id"));
				h.setName(rs.getString("name"));
				h.setId(rs.getString("ID"));
				hospitalList.add(h);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return hospitalList;
	}

	@Override
	public Hospital searchByID(String id) {
		Hospital dummy_Hospital = new Hospital();
		try
		{
		con = ConnectionProvider.getCon();
		ps = con.prepareStatement("select * from hospital where id='"+id+"'");
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			dummy_Hospital.setId(rs.getString(1));
			dummy_Hospital.setName(rs.getString(2));
			dummy_Hospital.setAddress(rs.getString(3));
			dummy_Hospital.setBlood_bank_id(rs.getString(4));
		}
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		return dummy_Hospital;
	}

	@Override
	public int updateHospital(Hospital new_hospital) {
		int status=0;
		try {
			con = ConnectionProvider.getCon();
			System.out.println(new_hospital.getId());
			ps = con.prepareStatement("update hospital set name=?,address=?,blood_Bank_id=? where id=?");
			ps.setString(1, new_hospital.getName());
			ps.setString(2, new_hospital.getAddress());
			ps.setString(3, new_hospital.getBlood_bank_id());
			ps.setString(4, new_hospital.getId());
			status = ps.executeUpdate();
			System.out.println(status);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
