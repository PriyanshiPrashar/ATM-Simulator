package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class miniStatement extends JFrame implements ActionListener {

    JButton back;
    String pinNumber;

    miniStatement(String pinNumber) {

        this.pinNumber = pinNumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("System", Font.BOLD, 18));
        bank.setBounds(140, 15, 200, 30);
        add(bank);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(20, 50, 360, 1);
        add(sep1);

        JLabel card = new JLabel();
        card.setFont(new Font("System", Font.PLAIN, 14));
        card.setBounds(20, 65, 350, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setVerticalAlignment(JLabel.TOP);

        JScrollPane scroll = new JScrollPane(mini);
        scroll.setBounds(20, 100, 360, 230);
        add(scroll);

        JLabel balance = new JLabel();
        balance.setFont(new Font("System", Font.BOLD, 14));
        balance.setBounds(20, 350, 300, 30);
        add(balance);

        back = new JButton("Back");
        back.setBounds(150, 400, 100, 30);
        back.addActionListener(this);
        add(back);

        JLabel footer = new JLabel("Thank you for banking with us");
        footer.setFont(new Font("System", Font.ITALIC, 12));
        footer.setBounds(100, 460, 250, 20);
        add(footer);

        try {
            connect conn = new connect();
            ResultSet rs = conn.s.executeQuery(
                    "select * from login where pin='" + pinNumber + "'");

            if (rs.next()) {
                String cno = rs.getString("cardnumber");
                card.setText("Card Number : " +
                        cno.substring(0, 4) + " XXXX XXXX " + cno.substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            connect conn = new connect();
            ResultSet rs = conn.s.executeQuery(
                    "select * from bank where pin='" + pinNumber + "'");

            int bal = 0;
            String statement = "<html>";

            while (rs.next()) {
                statement += rs.getString("date") + "&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br>";

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            statement += "</html>";
            mini.setText(statement);
            balance.setText("Current Balance : Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(420, 520);
        setLocation(100, 50);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new miniStatement("1234");
    }
}
