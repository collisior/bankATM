package Account;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class View_Account_Trans {

    public static void main(String[] args) {

        placeComponents();
    }

    public static void placeComponents() {

        JFrame frame = new JFrame("View Account Transactions");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font f = new Font("Arial", Font.CENTER_BASELINE,14);
        Font f1 = new Font("Arial", Font.CENTER_BASELINE,19);

        JLabel failed_to_close_account = new JLabel("View Account Transactions", SwingConstants.CENTER);
        failed_to_close_account.setBounds(200, 50, 260, 60);
        failed_to_close_account.setFont(f1);
        panel.add(failed_to_close_account);

        JButton go_back = new JButton("Go back");
        go_back.setBounds(80, 50, 100, 30);
        go_back.setOpaque(true);
        go_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                go_back.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//                return to Clients Page Wait for Byran
            }
        });

        go_back.setFont(f);
        go_back.setBackground(Color.ORANGE);
        panel.add(go_back);

        Box box = Box.createVerticalBox();
        JScrollPane scrollArea = new JScrollPane(box,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollArea.setBounds(150, 150, 350, 300);
        panel.add(scrollArea);

        frame.add(panel);
        frame.setVisible(true);
    }
}