package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JButton B1,B2,B3;
    JLabel Pin,cardno;
    JTextField t2;
    JPasswordField t1;
    Login()
    {
     setTitle("Automated Teller Machine");
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm-card.png"));
     Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
    
     ImageIcon i3=new ImageIcon(i2);
     
              JLabel label=new JLabel(i3);
              label.setBounds(70,30,100,100);
     add(label);
     
     JLabel text=new JLabel("Welcome To ATM");
     text.setFont(new Font("Osward",Font.BOLD,38));
     text.setBounds(200, 30, 500, 100);
     add(text);
      cardno=new JLabel("Card No:");
     cardno.setFont(new Font("Osward",Font.BOLD,28));
     cardno.setBounds(120, 150, 500, 100);
     add(cardno);
      Pin=new JLabel("PIN:");
     Pin.setFont(new Font("Osward",Font.BOLD,28));
     Pin.setBounds(120, 220, 500, 100);
     add(Pin);
      t1=new JPasswordField();
     t1.setBounds(320,250,200,50);
          t1.setFont(new Font("Aerial",Font.BOLD,25));

     
     add(t1);
      t2=new JTextField();
     t2.setBounds(320,180,200,50);
     t2.setFont(new Font("Raleway",Font.BOLD,25));
     add(t2);
      B1=new JButton("LogIn");
     add(B1);
     B1.setBackground(Color.black);
     B1.setForeground(Color.white);
     
     B1.setBounds(200, 350, 150, 35);
     B1.addActionListener(this);
      B2=new JButton("CLEAR");
     add(B2);
     B2.setBounds(360, 350, 150, 35);
     B2.setBackground(Color.black);
     B2.setForeground(Color.white);
     B2.addActionListener(this);
     
      B3=new JButton("SignUp");
             B3.setBounds(220, 390, 250, 35);
         B3.addActionListener(this);
     add(B3);
     B3.setBackground(Color.black);
     B3.setForeground(Color.white);
     
     
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
       setSize(800,500);
        setVisible(true);
        setLocation(350,200);
    }
//    B1==Login , B2==Clear , B3==SignUp
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==B3)
        {
          
        }
        else if(ae.getSource()==B2){
              t1.setText("");
            t2.setText("");
    }

   
 
       else if (ae.getSource() == B1) { // Login button

    connect conn = new connect();

    String cardNumber = t2.getText();
    String pinNumber = new String(t1.getPassword());

    try {
        String query = "SELECT * FROM login WHERE cardnumber = ? AND pin = ?";
        PreparedStatement ps = conn.c.prepareStatement(query);

        ps.setString(1, cardNumber);
        ps.setString(2, pinNumber);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            setVisible(false);
            new Transction("").setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    }
    public static void main(String[] args) {
        new Login();
    }
}