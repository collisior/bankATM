package gui.MyTrans;

import javax.swing.*;

import account.*;
import bankATM.Client;
import database.*;
import transaction.Transaction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class ALL_Trans {
	

	static Client client = null;

	public static void setup() {
		DBClient dbobj = new DBClient();
		try {
			client = dbobj.retrieveById("c7577a78-ec82-4e04-85c6-468f029617e6");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		placeComponents(null);
	}

	public static void placeComponents(Date date) {
		date = new Date(3910,02,10);
		System.out.println("date" + date);
		setup();
		System.out.println("client id " + client.getId());
		
		DBTransaction tObj = new DBTransaction();
		DBAccount taObj = new DBAccount();
		ArrayList<Transaction> transactions = null;
		try {
			Account a = taObj.retrieveById("6bf61a1e-0697-4b08-a0ff-86d6cb3d70dr");
//			transactions = tObj.retrieveTransactions();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = "";
//		for (Transaction t : transactions) {
//			if (t.getCreated().getYear() == date.getYear() && t.getCreated().getMonth() == date.getMonth())
//				str += t.getId() + ": \n" + t + "\n\n";
//		}
		for (int i =0; i<10; i++) {
			str += " Hold \n\n\n";
		}
		
	
		JFrame frame = new JFrame("My Transaction");
		frame.setSize(650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		Font f = new Font("Arial", Font.CENTER_BASELINE, 14);
		Font f1 = new Font("Arial", Font.CENTER_BASELINE, 19);

		JLabel title = new JLabel(" All My Transactions Page", SwingConstants.CENTER);
		title.setBounds(200, 50, 250, 60);
		title.setFont(f1);
		panel.add(title);

		JButton go_back = new JButton("Go back");
		go_back.setBounds(80, 50, 100, 30);
		go_back.setOpaque(true);
		go_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go_back.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				Mytrans.placeComponents();
			}
		});

		go_back.setFont(f);
		go_back.setBackground(Color.ORANGE);
		panel.add(go_back);

		JTextArea textField = new JTextArea();

		
		textField.setText(str);

		JLabel displayCurrent = new JLabel("Display All Transactions: ");
		displayCurrent.setBounds(150, 110, 150, 40);
		panel.add(displayCurrent);

		Box box = Box.createVerticalBox();
		JScrollPane scrollArea = new JScrollPane(box, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollArea.setBounds(150, 150, 350, 230);
		scrollArea.add(textField);
		panel.add(scrollArea);

		frame.add(panel);
		frame.setVisible(true);
	}

	public static void viewAllTransactions(Date date) {
		JFrame frame = new JFrame("View All Transactions");
		frame.setSize(650, 500);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);

		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

			}

		});
		back.setBounds(50, 20, 75, 50);
		panel.add(back);

		JLabel displayCurrent = new JLabel("Transactios: ");
		displayCurrent.setSize(650, 500);

		JTextArea textField = new JTextArea();

		DBTransaction tObj = new DBTransaction();
		ArrayList<Transaction> transactions = null;
		try {
			transactions = tObj.retrieveTransactions(Mytrans.client);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = "";
		for (Transaction t : transactions) {
			if (t.getCreated().getYear() == date.getYear() && t.getCreated().getMonth() == date.getMonth())
				str += t.getId() + ": \n" + t + "\n\n";
		}
		textField.setText(str);

		JScrollPane scroll = new JScrollPane(textField);
		scroll.setBounds(10, 11, 455, 249); // <-- THIS
		frame.getContentPane().add(scroll);
		frame.setLocationRelativeTo(null);

		panel.add(displayCurrent);

		frame.setVisible(true);

	}
}
