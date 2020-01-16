package admin_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAOImpl implements AdminDAO {
	static Connection con;
	static PreparedStatement ps;
	@Override
	public Admin getAdmin(String username, String password) {
		Admin a = new Admin();
		try
		{
			con = Admin_Connection_Provider.getCon();
			ps=con.prepareStatement("select * from admin_info where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				a.setUsername(rs.getString(1));
				a.setPassword(rs.getString(2));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}

}
