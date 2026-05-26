
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class balanceEnquiry  extends JFrame implements ActionListener{
    String pinNumber;
    JButton back;
    balanceEnquiry(String pinNumber){
            this.pinNumber=pinNumber;
    setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
        
         
         back=new JButton("Back");
         back.setBounds(355,520, 150, 30);
         image.add(back);
         back.addActionListener(this);
         
         connect c = new connect();
          int balance = 0;
        try {
            

            ResultSet rs = c.s.executeQuery(
                    "select * from bank where pin = '" + pinNumber + "'");

           

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdraw")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         JLabel text=new JLabel("Your Current Account balance is Rs"+" "+balance);
       text.setForeground(Color.WHITE);
       text.setBounds(170,300,400,30);
       image.add(text);
         setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back){
        setVisible(false);
        new Transction(pinNumber).setVisible(true);
    }
    }
    public static void main(String[] args)
    {
        new balanceEnquiry("");
    }
}
