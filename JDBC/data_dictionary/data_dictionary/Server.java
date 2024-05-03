package data_dictionary;

import java.awt.GridLayout;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Server {

	String url = "jdbc:postgresql://192.168.110.48/training?user=plf_training_admin&password=pff123";
	Connection con;

	// method to list all the columns of a given table from the choice list in UI.
	public void getColumns(String table) {
		ResultSet rs1 = null;

		try {
			con = DriverManager.getConnection(url);
			DatabaseMetaData dms = con.getMetaData();
			rs1 = dms.getColumns(null, null, table, null);

			UI ui = new UI();
			while (rs1.next()) {
				System.out.println(rs1.getString("COLUMN_NAME"));
				ui.c2.add(rs1.getString("COLUMN_NAME"));
			}

			ResultSet rs2 = dms.getPrimaryKeys(null, null, table);

			int row = 1;
			ui.tf1 = new TextField();
			ui.tf1.setText("COLUMN_NAME");
			ui.tf2 = new TextField();
			ui.tf2.setText("PK_NAME");
			ui.p1.add(ui.tf1);
			ui.p1.add(ui.tf2);
			ui.p1.setLayout(new GridLayout(row++, 2));

			while (rs2.next()) {
				System.out.println(rs2.getString("COLUMN_NAME") + " === " + rs2.getString("PK_NAME"));
				ui.tf1 = new TextField();
				ui.tf1.setText(rs2.getString("COLUMN_NAME"));
				ui.tf2 = new TextField();
				ui.tf2.setText(rs2.getString("PK_NAME"));
				ui.p1.add(ui.tf1);
				ui.p1.add(ui.tf2);
				ui.p1.setLayout(new GridLayout(row, 2));
				row++;
			}

			ResultSet rs3 = dms.getImportedKeys(null, null, table);

			while (rs3.next()) {
				System.out.println(rs3.getString("PKCOLUMN_NAME") + " === " + rs3.getString("FKCOLUMN_NAME"));
				ui.tf1 = new TextField();
				ui.tf1.setText(rs3.getString("PKCOLUMN_NAME"));
				ui.tf2 = new TextField();
				ui.tf2.setText(rs3.getString("FKCOLUMN_NAME"));
				ui.p1.add(ui.tf1);
				ui.p1.add(ui.tf2);
				ui.p1.setLayout(new GridLayout(row, 2));
				row++;
			}

			ui.p1.setBounds(100, 300, 500, 200);
			ui.add(ui.p1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return rs1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
