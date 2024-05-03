package jdbcOps;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://192.168.110.48/training?user=plf_training_admin&password=pff123";
			Connection con = DriverManager.getConnection(url);

			CallableStatement cs = con.prepareCall("call register(?,?,?,?,?)");
			cs.setInt(1, 46);
			cs.setString(2, "Indumathi");
			cs.setString(3, "ase trainee");
			cs.setInt(4, 12000);
			cs.setString(5, "Engg team");
			int i = cs.executeUpdate();
			System.out.println(i);
			con.close();
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
