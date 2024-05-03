package data_dict_1;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UI extends Frame {

	Panel p1;
	Label l1, l2, l3;
	Choice c1, c2;
	TextField tf1, tf2, tf3;
	List li1;
	Server s1;

	public UI() {
		p1 = new Panel();
		l1 = new Label("Table");
		c1 = new Choice();
		Button b1 = new Button("Get Columns");

		/*
		 * on clicking the button named "Get Columns", you will get the columns in the respective table. In the choice
		 * list under the label Column. Each time you give a new table in the choice list c1, you will get the
		 * corresponding columns of the table, by deleting the previous selected table columns.
		 */
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String table = c1.getSelectedItem();
				Server s1 = new Server();

				ResultSet rs1 = s1.getColumns(table);
				c2.removeAll();
				try {
					while (rs1.next()) {
						System.out.println(rs1.getString("COLUMN_NAME"));
						c2.add(rs1.getString("COLUMN_NAME"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		l2 = new Label("Column");
		c2 = new Choice();
		Button b2 = new Button("Get Data");

		/*
		 * this button will return all the primary keys and foreign keys with their constraints. every time, you select
		 * a new table and click the "Get Data" button the previous data about other tables constraints will be deleted
		 * and the constraints data about current table will be displayed.
		 */
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table = c1.getSelectedItem();
				Server s1 = new Server();

				p1.removeAll();
				tf3 = new TextField();
				tf3.setText("Constraints");
				tf3.setBounds(150, 500, 200, 50);
				add(tf3);

				ResultSet rs2 = s1.getPrimaryKeys(table);

				int row = 1;
				tf1 = new TextField();
				tf1.setText("COLUMN_NAME");
				tf2 = new TextField();
				tf2.setText("PK_NAME");
				p1.add(tf1);
				p1.add(tf2);
				p1.setLayout(new GridLayout(row++, 2));

				try {
					while (rs2.next()) {
						System.out.println(rs2.getString("COLUMN_NAME") + " === " + rs2.getString("PK_NAME"));
						tf1 = new TextField();
						tf1.setText(rs2.getString("COLUMN_NAME"));
						tf2 = new TextField();
						tf2.setText(rs2.getString("PK_NAME"));
						p1.add(tf1);
						p1.add(tf2);
						p1.setLayout(new GridLayout(row, 2));
						row++;
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ResultSet rs3 = s1.getForeignKeys(table);
				try {
					while (rs3.next()) {
						System.out.println(rs3.getString("PKCOLUMN_NAME") + " === " + rs3.getString("FKCOLUMN_NAME"));
						tf1 = new TextField();
						tf1.setText(rs3.getString("PKCOLUMN_NAME"));
						tf2 = new TextField();
						tf2.setText(rs3.getString("FKCOLUMN_NAME"));
						p1.add(tf1);
						p1.add(tf2);
						p1.setLayout(new GridLayout(row, 2));
						row++;
					}
				} catch (HeadlessException | SQLException e1) {
					e1.printStackTrace();
				}

				p1.setBounds(100, 300, 500, 200);
				add(p1);

			}
		});

		l3 = new Label("Constraints");

		l1.setBounds(50, 50, 150, 30);
		c1.setBounds(50, 90, 150, 30);
		b1.setBounds(50, 150, 150, 20);

		l2.setBounds(300, 50, 150, 30);
		c2.setBounds(300, 90, 150, 30);
		b2.setBounds(300, 150, 150, 20);

		l3.setBounds(150, 250, 100, 30);

		add(l1);
		add(c1);
		add(l2);
		add(c2);
		add(b1);
		add(b2);

		setTitle("Data Dictionary");
		setSize(1000, 500);
		setLayout(null);
		setVisible(true);
	}

}
