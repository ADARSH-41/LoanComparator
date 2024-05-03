package data_dictionary;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table = c1.getSelectedItem();
				Server s1 = new Server();
				s1.getColumns(table);
			}
		});

		l2 = new Label("Column");
		c2 = new Choice();
		Button b2 = new Button("Get Data");

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item1 = c2.getSelectedItem();
				tf3 = new TextField();
				tf3.setText("Constraints");
				tf3.setBounds(150, 500, 200, 50);
				add(tf3);
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
