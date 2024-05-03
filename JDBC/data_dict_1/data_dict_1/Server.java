package data_dict_1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Server {

	String url = "jdbc:postgresql://192.168.110.48/training?user=plf_training_admin&password=pff123";
	Connection con;

	// method to list all the columns of a given table from the choice list in UI.
	public ResultSet getColumns(String table) {
		ResultSet rs1 = null;

		try {
			con = DriverManager.getConnection(url);
			DatabaseMetaData dms = con.getMetaData();
			rs1 = dms.getColumns(null, null, table, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs1;
	}

	// method to list all the primary keys of a given table from the choice list in UI.
	public ResultSet getPrimaryKeys(String table) {
		ResultSet rs2 = null;
		try {
			con = DriverManager.getConnection(url);
			DatabaseMetaData dms = con.getMetaData();
			rs2 = dms.getPrimaryKeys(null, null, table);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs2;
	}

	// method to list all the foreign of a given table from the choice list in UI.
	public ResultSet getForeignKeys(String table) {
		ResultSet rs3 = null;
		try {
			con = DriverManager.getConnection(url);
			DatabaseMetaData dms = con.getMetaData();
			rs3 = dms.getImportedKeys(null, null, table);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs3;
	}

	// main method on execution will populate the choice list 1 with all the available tables in the
	// database and display them in the awt window's choice list 1.
	public static void main(String[] args) {
		try {
			String url = "jdbc:postgresql://192.168.110.48/training?user=plf_training_admin&password=pff123";
			Connection con = DriverManager.getConnection(url);

			DatabaseMetaData dms = con.getMetaData();
			ResultSet rs = dms.getTables(null, null, null, new String[] { "TABLE" });

			UI ui = new UI();

			while (rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
				ui.c1.add(rs.getString("TABLE_NAME"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// String query = "SELECT * FROM pg_catalog.pg_tables WHERE schemaname='public' order by pg_tables";
// PreparedStatement ps = con.prepareStatement(query);
