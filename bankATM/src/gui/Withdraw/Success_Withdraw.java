package gui.Withdraw;
import account.*;
import manager.*;
import transaction.*;
import database.*;
import bankATM.*;
import bankATM.Currency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Success_Withdraw {
	public static void main(String[] args) {
		placeComponents();
	}
	public static void placeComponents() {
		JFrame frame = new JFrame("Success Withdraw");
		frame.setSize(650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

        panel.setLayout(null);

        Font f = new Font("Arial", Font.CENTER_BASELINE,14);
        Font f1 = new Font("Arial", Font.CENTER_BASELINE,19);

        JLabel title = new JLabel("Successful Withdraw", SwingConstants.CENTER);
        title.setBounds(200, 50, 250, 60);
        title.setFont(f1);
        panel.add(title);

        JButton go_back = new JButton("Go back");
        go_back.setBounds(80, 50, 100, 30);
        go_back.setOpaque(true);
        go_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Withdraw_Page.placeComponents();
			}
		});

        go_back.setFont(f);
        go_back.setBackground(Color.ORANGE);
        panel.add(go_back);
        
        frame.add(panel);
		frame.setVisible(true);
    }
}
