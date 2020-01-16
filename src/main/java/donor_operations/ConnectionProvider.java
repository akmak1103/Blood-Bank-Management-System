package donor_operations;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements ConnectionProvider_Interface {
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
