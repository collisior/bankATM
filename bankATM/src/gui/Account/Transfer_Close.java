package Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Transfer_Close {

    public static void main(String args[]) {

        placeComponents();
    }

    public static void placeComponents() {

        JFrame frame = new JFrame("Transfer adn Close");
        frame.setSize(650,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font f = new Font("Arial", Font.CENTER_BASELINE,14);
        Font f1 = new Font("Arial", Font.CENTER_BASELINE,19);

        JLabel transfer_and_close_ = new JLabel("Transfer and Close", SwingConstants.CENTER);
        transfer_and_close_.setBounds(200, 50, 250, 60);
        transfer_and_close_.setFont(f1);
        panel.add(transfer_and_close_);

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

        JLabel money = new JLabel("Confirm the transfer and close", SwingConstants.CENTER);
        money.setBounds(150, 150, 350, 100);
        money.setOpaque(true);

        money.setFont(f1);
        money.setBackground(Color.GRAY);
        panel.add(money);

        JButton confirm = new JButton("Confirm");
        confirm.setBounds(225,350,200,55);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirm.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//                if sucess:
//                Success_Close_Account.placeComponents();
//                else:
//                Failed_Close_Account.placeComponents();
            }
        });

        confirm.setFont(f1);
        confirm.setOpaque(true);
        confirm.setBackground(Color.green);
        panel.add(confirm);

        frame.add(panel);
        frame.setVisible(true);
    }
}
