
package bank.management.system;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUP2 extends JFrame implements ActionListener {

    JTextField pan, adhar, countrytf, codetf;
    JButton next;
    JRadioButton syes, sno, Ayes, Ano;
    JComboBox<String> category, income, education, occupation, religion;
    String formno;
    SignUP2(String formno) {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION - PAGE:2");

        JLabel addiPersonal = new JLabel("Page 2:Additional Details");
        addiPersonal.setFont(new Font("Raleway", Font.BOLD, 28));
        addiPersonal.setBounds(230, 100, 600, 50);
        add(addiPersonal);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 26));
        name.setBounds(150, 180, 600, 30);
        add(name);

        String[] valReligion = {"Select", "Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(350, 180, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 26));
        fname.setBounds(150, 230, 600, 30);
        add(fname);

        String[] valcategory = {"Select", "General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valcategory);
        category.setBounds(350, 230, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 26));
        incomeLabel.setBounds(150, 280, 600, 30);
        add(incomeLabel);

        String[] incomeCat = {"Select", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 1,00,000"};
        income = new JComboBox<>(incomeCat);
        income.setBounds(350, 280, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 26));
        gender.setBounds(150, 330, 600, 30);
        add(gender);

        String[] educationval = {"Select", "Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Other"};
        education = new JComboBox<>(educationval);
        education.setBounds(350, 330, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel mstatus = new JLabel("Occupation:");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 26));
        mstatus.setBounds(150, 380, 600, 30);
        add(mstatus);

        String[] occupationval = {"Select", "Salaried", "Self-Employee", "Business", "Retired", "Other"};
        occupation = new JComboBox<>(occupationval);
        occupation.setBounds(350, 380, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN No:");
        address.setFont(new Font("Raleway", Font.BOLD, 26));
        address.setBounds(150, 430, 600, 30);
        add(address);

        pan = new JTextField();
        pan.setBounds(350, 430, 400, 30);
        add(pan);

        JLabel city = new JLabel("Adhar No:");
        city.setFont(new Font("Raleway", Font.BOLD, 26));
        city.setBounds(150, 470, 600, 30);
        add(city);

        adhar = new JTextField();
        adhar.setBounds(350, 470, 400, 30);
        add(adhar);

        JLabel state = new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway", Font.BOLD, 26));
        state.setBounds(150, 510, 600, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(350, 510, 80, 30);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 510, 80, 30);
        add(sno);

        ButtonGroup scitizen = new ButtonGroup();
        scitizen.add(syes);
        scitizen.add(sno);

        JLabel country = new JLabel("Existing acc.:");
        country.setFont(new Font("Raleway", Font.BOLD, 26));
        country.setBounds(150, 550, 600, 30);
        add(country);

        countrytf = new JTextField();
        countrytf.setBounds(350, 550, 400, 30);
        add(countrytf);

        Ayes = new JRadioButton("Yes");
        Ayes.setBounds(350, 590, 80, 30);
        add(Ayes);

        Ano = new JRadioButton("No");
        Ano.setBounds(450, 590, 80, 30);
        add(Ano);

        ButtonGroup acc = new ButtonGroup();
        acc.add(Ayes);
        acc.add(Ano);

        JLabel code = new JLabel("Pin Code:");
        code.setFont(new Font("Raleway", Font.BOLD, 26));
        code.setBounds(150, 630, 600, 30);
        add(code);

        codetf = new JTextField();
        codetf.setBounds(350, 630, 400, 30);
        add(codetf);

        next = new JButton("Next");
        next.setBounds(670, 680, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 760);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       String sreligion=(String)religion.getSelectedItem();
       String scategory=(String) category.getSelectedItem();
       String sincome=(String) income.getSelectedItem();
       String seducation=(String) education.getSelectedItem();
       String soccupation=(String) occupation.getSelectedItem();
       String seniorcitizen=null;
       if(syes.isSelected())
       {
           seniorcitizen="YES";
           
       }
       else if(sno.isSelected())
       {
           seniorcitizen="No";
       }
       String acc=null;
       if(Ayes.isSelected())
       {
           acc="Yes";
       }
       else if(Ano.isSelected())
       {
           acc="No";
       }
       String span=pan.getText();
       String sadhar=adhar.getText();
       try
       {
           connect c=new connect();
 String query = "insert into signup2 values('"
                + formno + "','"
                + sreligion + "','"
                + scategory + "','"
                + sincome + "','"
                + seducation + "','"
                + soccupation + "','"
                + seniorcitizen + "','"
                + acc + "','"
                + span + "','"
                + sadhar + "')";       
       c.s.executeUpdate(query);
       setVisible(false);
       new Signup3(formno).setVisible(true);
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
    }

    public static void main(String[] args) {
        new SignUP2("");
        
    }
}
