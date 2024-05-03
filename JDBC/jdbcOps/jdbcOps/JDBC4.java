package jdbcOps;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JDBC4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			String url = "jdbc:postgresql://192.168.110.48/training?user=plf_training_admin&password=pff123";
			Connection con = DriverManager.getConnection(url);

			CallableStatement cs = con.prepareCall("call getjobdesc(?,?)");

			cs.setString(1, "Sal");
			cs.setInt(2, 12000);

			cs.registerOutParameter(1, Types.VARCHAR);

			// ResultSet rs = cs.executeQuery();
			cs.execute();
			String job;

			// while (rs.next()) {
			job = cs.getString(1);

			System.out.println(job);
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
