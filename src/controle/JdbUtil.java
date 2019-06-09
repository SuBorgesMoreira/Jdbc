package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbUtil {

	private static String connectionDriverClass="com.mysql.jdbc.Driver";
	private static String connectionURL = "Jdbc:mysql://localhost/java";
	private static String connectionUsername = "root";
	private static String connectionPassword = "";
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		if(JdbUtil.conn != null) {
			return JdbUtil.conn;
		}else {
			Class.forName(connectionDriverClass);
			return DriverManager.getConnection(
				JdbUtil.connectionURL,
				JdbUtil.connectionUsername,
				JdbUtil.connectionPassword);
		}
	}
}
