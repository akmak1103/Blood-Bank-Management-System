package admin_access;

import java.sql.Connection;
import java.sql.DriverManager;

import donor_operations.ConnectionProvider_Interface;

public class Admin_Connection_Provider implements ConnectionProvider_Interface {
	static Connection con = null;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, DB_user, DB_Pass);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
