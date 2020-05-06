package gui.Client;
import account.*;
import manager.*;
import transaction.*;
import database.*;
import gui.Withdraw.Withdraw_Account;
import bankATM.*;
import bankATM.Currency;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class ClientAccountInfo {
	public static void displayAccounts()
	{
		JFrame frame = new JFrame("Client Accounts");
		frame.setSize(650,500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JButton back = new JButton("Home");
		back.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
			}
        	
        });
		back.setBounds(50,20,75,50);
		panel.add(back);
		
		
		JButton openNewAcc = new JButton("Open New Account");
		openNewAcc.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createNewAccount();
				
			}
        	
        });
		openNewAcc.setBounds(400,20,175,50);
		panel.add(openNewAcc);
		
		
		JButton defaultAccount = new JButton("Deposit Account - Default Account");
		defaultAccount.setBounds(180,100,250,50);
		panel.add(defaultAccount);
		
		JButton savingsAccount = new JButton("Savings Account");
		savingsAccount.setBounds(180,160,250,50);
		panel.add(savingsAccount);
		
		JButton checkingsAccount = new JButton("Checking Account");
		checkingsAccount.setBounds(180,220,250,50);
		panel.add(checkingsAccount);
		
		JButton securityAccount = new JButton("Security Account");
		securityAccount.setBounds(180,280,250,50);
		panel.add(securityAccount);
		
		JButton loansAccount = new JButton("Loans Account");
		loansAccount.setBounds(180,340,250,50);
		panel.add(loansAccount);
		//need to implement scroll feature for all these above account types
		
		frame.setVisible(true);
	}
	
	private static void createNewAccount()
	{
		JFrame frame = new JFrame("Open New Account");
		frame.setSize(650,500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
			}
        	
        });
		back.setBounds(50,20,75,50);
		panel.add(back);
		
		JButton savings = new JButton("Savings");
		savings.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createNewAccPage("Savings/Checking");
				
			}
        	
        });
		savings.setBounds(190, 120,150,40);
		panel.add(savings);
		
		JButton checking = new JButton("Checking");
		checking.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createNewAccPage("Savings/Checking");
				
			}
        	
        });
		checking.setBounds(190,170,150,40);
		panel.add(checking);
		
		JButton security = new JButton("Security");
		security.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createNewAccPage("Security");
				
			}
        	
        });
		security.setBounds(190,220,150,40);
		panel.add(security);
		
		
		frame.setVisible(true);
	}
	
	private static void createNewAccPage(String accType)
	{
		JFrame frame = new JFrame("New " + accType + " Account");
		frame.setSize(650,500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
			}
        	
        });
		back.setBounds(50,20,75,50);
		panel.add(back);
		
		JLabel header = new JLabel("New " + accType + " Account");
		header.setBounds(200,40,200,40);
		panel.add(header);
		
		JLabel securityAccReminder = new JLabel("Security account only allowed for Clients with minimum $10k in Savings");
		securityAccReminder.setBounds(120,90,500,40);
		panel.add(securityAccReminder);
		
		JButton create = new JButton("Create");
		create.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame approved = new JFrame("Account Created Successfully");
				approved.setSize(650,500);
				approved.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JPanel panel = new JPanel();
				approved.add(panel);
				panel.setLayout(null);
				JLabel successful = new JLabel("Created successfully");
				successful.setBounds(200,150,300,100);
				panel.add(successful);
				JButton back = new JButton("Back");
				back.addActionListener(new ActionListener()
		        {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						approved.dispatchEvent(new WindowEvent(approved, WindowEvent.WINDOW_CLOSING));
						
					}
		        	
		        });
				back.setBounds(50,20,75,50);
				panel.add(back);
				approved.setVisible(true);
				
			}
        	
        });
		create.setBounds(180, 140, 200,40);
		panel.add(create);
		
		
		frame.setVisible(true);
	}

}
