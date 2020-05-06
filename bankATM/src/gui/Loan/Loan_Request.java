package Loan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Loan_Request {
    public static void main(String[] args) {

        placeComponents();
    }

    public static void placeComponents() {

        JFrame frame = new JFrame("Loan Request");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font f = new Font("Arial", Font.CENTER_BASELINE,14);
        Font f1 = new Font("Arial", Font.CENTER_BASELINE,19);

        JLabel title = new JLabel("Loan Request Page", SwingConstants.CENTER);
        title.setBounds(200, 50, 250, 60);
        title.setFont(f1);
        panel.add(title);

        JButton go_back = new JButton("Go back");
        go_back.setBounds(80, 50, 100, 30);
        go_back.setOpaque(true);

        go_back.setFont(f);
        go_back.setBackground(Color.ORANGE);
        panel.add(go_back);
        go_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                go_back.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                // return to main page, wait for byrant
            }
        });

        JTextField money = new JTextField(20);
        money.setBounds(125,200,275,40);
        JLabel enter = new JLabel("Please enter Amount of Loan to Request", SwingConstants.CENTER);
        enter.setBounds(125,130,400,40);
        enter.setFont(f1);
        enter.setLabelFor(money);
        panel.add(money);
        panel.add(enter);

        JButton currency = new JButton("Currency");
        currency.setBounds(430,200,100,40);
        currency.setFont(f);
        panel.add(currency);

        JButton Enter = new JButton("Enter");
        Enter.setBounds(275,300,100,40);
        Enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                go_back.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                // if successful:
//                Loan_Left.placeComponents();
                // else:
//                Payment_Failed.placeComponents();
            }
        });

        Enter.setFont(f1);
        panel.add(Enter);

        frame.add(panel);
        frame.setVisible(true);
    }
}
