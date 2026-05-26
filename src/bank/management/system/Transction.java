
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class Transction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministate,pinchange,balance,exit;
  String pinNumber;
    Transction(String pinNumber)
    {
        this.pinNumber=pinNumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image); 
        
        
        JLabel text=new JLabel("Please Select your Transaction");
        text.setBounds(245,300,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
         deposit = new JButton("Deposit");
deposit.setBounds(170, 415, 150, 30);
deposit.addActionListener(this);
image.add(deposit);

 withdrawl = new JButton("Cash Withdrawal");
withdrawl.setBounds(355, 415, 150, 30);
withdrawl.addActionListener(this);
image.add(withdrawl);

 fastcash = new JButton("Fast Cash");
fastcash.setBounds(170, 450, 150, 30);
fastcash.addActionListener(this);
image.add(fastcash);
        
 ministate = new JButton("Mini Statement");
ministate.setBounds(355, 450, 150, 30);
ministate.addActionListener(this);
image.add(ministate);

 pinchange = new JButton("Pin Change");
pinchange.setBounds(170, 485, 150, 30);
pinchange.addActionListener(this);
image.add(pinchange);
        
 balance = new JButton("Balance Enquiry");
 balance.addActionListener(this);
balance.setBounds(355, 485, 150, 30);
image.add(balance);

 exit = new JButton("Exit");
exit.setBounds(355, 520, 150, 30);
exit.addActionListener(this);
image.add(exit);

        setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    
        
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
         setVisible(false);
      new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new withdrawl(pinNumber).setVisible(true);
        }
            else if (ae.getSource() == fastcash) {
    setVisible(false);
    new fastcash(pinNumber).setVisible(true);

        }
            else if(ae.getSource()==pinchange)
            {
                setVisible(false);
                new pinchange(pinNumber).setVisible(true);
            }
            else if(ae.getSource()==balance)
            {
                setVisible(false);
                new balanceEnquiry(pinNumber).setVisible(true);
            }
            else if(ae.getSource()==ministate)
            {
                setVisible(false);
                new miniStatement(pinNumber).setVisible(true);
            }
}

    public static void main(String[] args)
    {
        new Transction("");
    }
}
