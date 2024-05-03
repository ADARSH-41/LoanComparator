package jdbcOps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://192.168.110.48/training?user=plf_training_admin&password=pff123";
			Connection con = DriverManager.getConnection(url);

			// PreparedStatement ps = con.prepareStatement("INSERT INTO OFFICEEMPLOYEE VALUES(?,?,?,?,?);");

			// int index = 1;
			// while (index <= 10) {
			// ps.setInt(1, 45 + index);
			// ps.setString(2, "Soumya");
			// ps.setString(3, "ase trainee");
			// ps.setInt(4, 12000);
			// ps.setString(5, "Engineering team");
			// index++;
			//
			// ps.executeUpdate();
			// }
			//
			// System.out.println(index + " rows afected");

			// PreparedStatement ps1 = con.prepareStatement("UPDATE OFFICEEMPLOYEE SET NAME=? WHERE EID=?");
			// ps1.setString(1, "mohan");
			// ps1.setInt(2, 45);
			// int j = ps1.executeUpdate();
			//
			// System.out.println(j + " rows afected");

			// int ind = 1;
			// PreparedStatement ps2 = con.prepareStatement("delete from officeemployee where eid=?");
			// while (ind <= 10) {
			// ps2.setInt(1, 45 + ind);
			// ps2.execute();
			//
			// ind++;
			// }
			// System.out.println(ind + " rows are affected");

			PreparedStatement ps3 = con.prepareStatement("SELECT NAME,salary FROM OFFICEEMPLOYEE WHERE DEPARTMENT=?");
			ps3.setString(1, "Engineering Team");
			ResultSet rs = ps3.executeQuery();
			while (rs.next()) {
				System.out.println("Name : " + rs.getString(1) + " Salary : " + rs.getInt(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
