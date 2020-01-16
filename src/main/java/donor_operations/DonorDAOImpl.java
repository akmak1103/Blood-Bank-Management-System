package donor_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DonorDAOImpl implements DonorDAO {
	static Connection con;
	static PreparedStatement ps;

	public int insertDonor(Donor d) {
		int status = 0;
		try {
			con = ConnectionProvider.getCon();
			ps = con.prepareStatement("insert into donor values (?,?,?,?,?,?,?)");
			ps.setString(1, d.getUsername());
			ps.setString(2, d.getPassword());
			ps.setString(3, d.getName());
			ps.setString(4, d.getContact());
			ps.setString(5, d.getAddress());
			ps.setString(6, d.getBlood_group());
			ps.setString(7, d.getStatus());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public Donor getDonor(String username, String password) {
		Donor d = new Donor();
		try {
			con = ConnectionProvider.getCon();
			ps = con.prepareStatement("select * from donor where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d.setUsername(rs.getString(1));
				d.setPassword(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public ArrayList<Donor> selectDonorByCriteria(String inCriteria) {
		ArrayList<Donor> donorList = new ArrayList();
		try {
			con = ConnectionProvider.getCon();
			String lSqlString = "select * from donor";
			if (inCriteria != null && inCriteria.length() > 0) {
				lSqlString = lSqlString + " " + inCriteria;
			}
			lSqlString = lSqlString + " ORDER BY name";
			ps = con.prepareStatement(lSqlString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donor d = new Donor();
				d.setAddress(rs.getString("address"));
				d.setBlood_group(rs.getString("blood_group"));
				d.setContact(rs.getString("contact"));
				d.setName(rs.getString("name"));
				d.setPassword(rs.getString("password"));
				d.setStatus(rs.getString("status"));
				d.setUsername(rs.getString("username"));
				donorList.add(d);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return donorList;
	}
	
	
	public int deleteDonor(String contactNo){
		int deleted=0;
		try{
			con = ConnectionProvider.getCon();
			String lQuery ="delete from donor where contact='"+contactNo+"'"; 
			System.out.println("lSqlString===:"+lQuery);
			ps = con.prepareStatement(lQuery);
			deleted = ps.executeUpdate();
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		return deleted;
	}
	
	public Donor searchByUsername (String u_name)
	{
		Donor dummy_donor = new Donor();
		try
		{
		con = ConnectionProvider.getCon();
		ps = con.prepareStatement("select * from donor where username='"+u_name+"'");
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			dummy_donor.setUsername(rs.getString(1));
			dummy_donor.setPassword(rs.getString(2));
			dummy_donor.setName(rs.getString(3));
			dummy_donor.setContact(rs.getString(4));
			dummy_donor.setAddress(rs.getString(5));
			dummy_donor.setBlood_group(rs.getString(6));
			dummy_donor.setStatus(rs.getString(7));
		}
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		return dummy_donor;
	}
	
	public int updateDonor(Donor new_donor)
	{
		int status=0;
		try {
			con = ConnectionProvider.getCon();
			System.out.println(new_donor.getUsername());
			ps = con.prepareStatement("update donor set password=?,name=?,contact=?,address=?,blood_group=?,status=? where username=?");
			ps.setString(1, new_donor.getPassword());
			ps.setString(2, new_donor.getName());
			ps.setString(3, new_donor.getContact());
			ps.setString(4, new_donor.getAddress());
			ps.setString(5, new_donor.getBlood_group());
			ps.setString(6, new_donor.getStatus());
			ps.setString(7, new_donor.getUsername());
			status = ps.executeUpdate();
			System.out.println(status);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
