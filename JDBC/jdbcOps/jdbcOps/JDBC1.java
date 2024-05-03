package jdbcOps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC1 {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver"); // Driver Registration

			String url = "jdbc:postgresql://192.168.110.48/training?user=plf_training_admin&password=pff123";

			Connection con = DriverManager.getConnection(url); // getting connection

			Statement stmt = con.createStatement(); // creating a statement

			// stmt.executeUpdate("INSERT INTO officeemployee values(43,'vivek','ase trainee',12000,'Engineering
			// Team')"); // executing
			// sql
			// statement
			ResultSet rs = stmt.executeQuery("SELECT * FROM OFFICEEMPLOYEE");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4)
						+ " " + rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
