package empcrud;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UI {
	public TextField t1, t2, t3, t4, t5, t6;
	public Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

	public UI() {
		initUI();
	}

	public void initUI() {
		Panel dp = new Panel(new GridLayout(3, 4, 5, 5)); // details panel
		Panel bp = new Panel(new GridLayout(3, 4, 100, 100)); // buttons panel
		Panel tp = new Panel(new GridLayout(0, 5, 5, 5)); // table panel

		t1 = new TextField();
		// t1.setBounds(100, 50, 50, 100);
		// t1.setEditable(true);
		t2 = new TextField();
		t3 = new TextField();
		t4 = new TextField();
		t5 = new TextField();
		t6 = new TextField();

		dp.add(new Label("Emp No"));
		dp.add(t1);
		dp.add(new Label("Name"));
		dp.add(t2);
		dp.add(new Label("Job"));
		dp.add(t3);
		dp.add(new Label("Salary"));
		dp.add(t4);
		dp.add(new Label("Dept No"));
		dp.add(t5);
		dp.add(new Label("Hire Date"));
		dp.add(t6);

		b1 = new Button("FIRST");
		b2 = new Button("NEXT");
		b3 = new Button("PREVIOUS");
		b4 = new Button("LAST");
		b5 = new Button("ADD");
		b6 = new Button("EDIT");
		b7 = new Button("DEL");
		b8 = new Button("SAVE");
		b9 = new Button("CLEAR");
		b10 = new Button("EXIT");

		bp.add(b1);
		bp.add(b2);
		bp.add(b3);
		bp.add(b4);
		bp.add(b5);
		bp.add(b6);
		bp.add(b7);
		bp.add(b8);
		bp.add(b9);
		bp.add(b10);

		// TextField t7 = new TextField();
		ResultSet rs = initDB();

		try {
			while (rs.next()) {
				TextField temp1 = new TextField(10);
				temp1.setText(rs.getString(1));
				temp1.setEditable(false);
				TextField temp2 = new TextField(10);
				temp2.setText(rs.getString(2));
				TextField temp3 = new TextField(10);
				temp3.setText(rs.getString(3));
				TextField temp4 = new TextField(10);
				temp4.setText(rs.getString(4));
				TextField temp5 = new TextField(10);
				temp5.setText(rs.getString(5));

				tp.add(temp1);
				tp.add(temp2);
				tp.add(temp3);
				tp.add(temp4);
				tp.add(temp5);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Frame f = new Frame();
		f.setLayout(new BorderLayout(15, 15));
		f.add(dp, BorderLayout.NORTH);
		f.add(bp, BorderLayout.CENTER);
		f.add(tp, BorderLayout.SOUTH);
		f.setSize(1000, 700);
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				f.dispose();
			}
		});
	}

	public ResultSet initDB() {
		ResultSet rs = null;
		String url = "jdbc:postgresql://192.168.110.48/training?user=plf_training_admin&password=pff123";
		try {
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM OFFICEEMPLOYEE");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public static void main(String[] args) {
		new UI();
	}
}
