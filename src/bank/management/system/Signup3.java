package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JLabel services, pnumber;
   JButton submit ,cancel;
   String formno;
    Signup3(String formno) {
        this.formno=formno;
  getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("Page 3: Account DETAILS");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100, 180, 200, 20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350, 180, 300, 20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(100, 220, 200, 20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350, 220, 300, 20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        JLabel carno = new JLabel("Card No.");
        carno.setFont(new Font("Raleway", Font.BOLD, 22));
        carno.setBounds(100, 300, 200, 30);
        add(carno);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setBounds(350, 300, 300, 30);
        add(number);

        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        JLabel cardetail=new JLabel("Your 16 digit card number"); 
        cardetail.setFont(new Font("Raleway",Font.BOLD,15));
        cardetail.setBounds(100,330,300,30); 
        add(cardetail);

        pnumber = new JLabel("XXXX");
        pnumber.setBounds(350, 370, 300, 30);
        add(pnumber);
        JLabel cardpin=new JLabel("Your 4 digit PIN"); 
        cardpin.setFont(new Font("Raleway",Font.BOLD,15)); 
        cardpin.setBounds(100,400,300,30); 
        add(cardpin);

        services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(100, 500, 200, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(350, 500, 200, 30);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(100, 550, 200, 30);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setBounds(350, 550, 200, 30);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(100, 600, 200, 30);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(350, 600, 200, 30);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above details are correct");
        c7.setBounds(100, 680, 600, 30);
        c7.setBackground(Color.WHITE);
        add(c7);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            submit=new JButton("Submit");
            submit.setBackground(Color.BLACK);
            submit.setForeground(Color.WHITE);
            submit.setBounds(250,720,100,30);
            submit.setFont(new Font("Raleway",Font.BOLD,14));
            add(submit);
            cancel=new JButton("Cancel");
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.setBounds(420,720,100,30);
            cancel.setFont(new Font("Raleway",Font.BOLD,14));
            add(cancel);
            submit.addActionListener(this);
cancel.addActionListener(this);

            
    }
  @Override
public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == submit) {

        String accounttype = null;

        if (r1.isSelected()) accounttype = "Saving Account";
        else if (r2.isSelected()) accounttype = "Fixed Deposit Account";
        else if (r3.isSelected()) accounttype = "Current Account";
        else if (r4.isSelected()) accounttype = "Recurring Deposit Account";

        if (accounttype == null) {
            JOptionPane.showMessageDialog(null, "Account Type is Required");
            return;
        }

        if (!c7.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please confirm the declaration");
            return;
        }

        Random random = new Random();
        String cardnumber = "" + (Math.abs(random.nextLong()) % 9000000000000000L + 1000000000000000L);
        String pinnumber = "" + (Math.abs(random.nextInt(9000)) + 1000);

        String facility = "";
        if (c1.isSelected()) facility += "ATM Card ";
        if (c2.isSelected()) facility += "Internet Banking ";
        if (c3.isSelected()) facility += "Mobile Banking ";
        if (c4.isSelected()) facility += "Email Alerts ";
        if (c5.isSelected()) facility += "Cheque Book ";
        if (c6.isSelected()) facility += "E-Statement ";

        try {
             JOptionPane.showMessageDialog(null, "Finally Created");
            connect conn = new connect();

            String query1 =
"INSERT INTO Signup3(formno, accountType, cardno, pin, facility) VALUES('" +
formno + "','" +
accounttype + "','" +
cardnumber + "','" +
pinnumber + "','" +
facility + "')";


            String query2 =
"INSERT INTO login(formno, cardnumber, pin) VALUES('" +
formno + "','" + cardnumber + "','" + pinnumber + "')";


            conn.s.executeUpdate(query1);
conn.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null,"Card Number: " + cardnumber + "\nPin: " + pinnumber);

            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());    
            e.printStackTrace();
        }
    }
        else if(ae.getSource()==cancel)
                {
                setVisible(false);
                new Login().setVisible(true);
                
    }
}

    public static void main(String[] args) {
        new Signup3("");
    }
}
