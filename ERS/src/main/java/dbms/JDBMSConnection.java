package dbms;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBMSConnection {

	public static void main(String[] args) {
		Connection connection = JDBMSConnection.getConnection();
		System.out.println(connection);
	}

	private JDBMSConnection() {

	}

	public static Connection getConnection() {

		InputStream in = null;

		try {

			Properties props = new Properties();
			in = new FileInputStream("C:\\Users\\Hen\\Documents\\Revature-Workspace\\ERS\\src\\main\\resources\\dbms-ers.properties");
			props.load(in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = null;
			String endpoint = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			connection = DriverManager.getConnection(endpoint, username, password);
			//System.out.println(connection.toString());
			return connection;

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
				catch (NullPointerException e) { 
					System.out.println("Cannot connect to the database server...");
				}
		}

		return null;
	}
}
