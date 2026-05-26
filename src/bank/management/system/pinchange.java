package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing .*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener{
     JButton change,back;
         JPasswordField  repint,pin;
         String pinNumber;
    pinchange (String pinNumber)
    {
       this.pinNumber=pinNumber;
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Change your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
         JLabel pintext=new JLabel("New Pin:");
         pintext.setForeground(Color.WHITE);
         pintext.setFont(new Font("System",Font.BOLD,16));
         pintext.setBounds(165,320,180,25);
        image.add( pintext);
        
          pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel repin=new JLabel("Re-Enter New Pin:");
          repin.setForeground(Color.WHITE);
          repin.setFont(new Font("System",Font.BOLD,16));
          repin.setBounds(165,360,180,25);
        image.add(  repin);
        
          repint=new JPasswordField();
        repint.setFont(new Font("Raleway",Font.BOLD,25));
        repint.setBounds(330,360,180,25);
        image.add(repint);
        
        
         change=new JButton("Change");
        change.setBounds(355,455,150,30);
        image.add(change);
        change.addActionListener(this);
          back=new JButton("Back");
        back.setBounds(355,490,150,30);
        image.add(back);
        back.addActionListener(this);
        
        
setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource()==change){
         try 
         {
            
             String npin =pin.getText();
             String rpin=repint.getText();
             if(!npin.equals(rpin))
             {
                 JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                 return;
             }
             if(npin.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Please eneter Pin");
                 return;
             }
             if(rpin.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Please Re-enter Pin ");
                 return;
             }
             connect conn=new connect();
            String query1 = "update bank set pin='"+rpin+"' where pin='"+pinNumber+"'";
String query2 = "update login set pin='"+rpin+"' where pin='"+pinNumber+"'";
String query3 = "update signup3 set pin='"+rpin+"' where pin='"+pinNumber+"'";


             
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             conn.s.executeUpdate(query3);
                              JOptionPane.showMessageDialog(null,"Pin Changed Succesfully");
                              setVisible(false);
                              new Transction(rpin).setVisible(true);

         }
         
         catch(Exception e)
         {
             System.out.print(e);
         }
    }
         else
         {
             setVisible(false);
             new Transction(pinNumber).setVisible(true);
         }
    }
    public static void main(String args[])
    {
        new pinchange("").setVisible(true);
    }
}
