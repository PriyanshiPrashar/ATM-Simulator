package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUp1 extends JFrame implements ActionListener {

    long random;
    JTextField nametf, frametf, emailtf, addresstf, citytf, statetf, countrytf, codetf;
    JButton next;
    JDateChooser dobtf;
    JRadioButton male, female, married, unmarried, other;

    SignUp1() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No:" + " " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(165, 40, 600, 40);
        add(formno);

        JLabel Personal = new JLabel("Page 1:Personal Details");
        Personal.setFont(new Font("Raleway", Font.BOLD, 28));
        Personal.setBounds(230, 100, 600, 50);
        add(Personal);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 26));
        name.setBounds(150, 180, 600, 50);
        add(name);

        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 18));
        nametf.setBounds(350, 185, 400, 30);
        add(nametf);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 26));
        fname.setBounds(150, 220, 600, 50);
        add(fname);

        frametf = new JTextField();
        frametf.setFont(new Font("Raleway", Font.BOLD, 18));
        frametf.setBounds(350, 225, 400, 30);
        add(frametf);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 26));
        dob.setBounds(150, 260, 600, 50);
        add(dob);

        dobtf = new JDateChooser();
        dobtf.setForeground(Color.BLACK);
        dobtf.setBounds(350, 270, 400, 30);
        add(dobtf);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 26));
        gender.setBounds(150, 300, 600, 50);
        add(gender);

        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(350, 300, 100, 50);
        add(male);

        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(450, 300, 300, 50);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("EMail:");
        email.setFont(new Font("Raleway", Font.BOLD, 26));
        email.setBounds(150, 340, 600, 50);
        add(email);

        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway", Font.BOLD, 18));
        emailtf.setBounds(350, 350, 400, 30);
        add(emailtf);

        JLabel mstatus = new JLabel("Marital Status:");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 26));
        mstatus.setBounds(150, 380, 600, 50);
        add(mstatus);

        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(350, 380, 100, 50);
        add(married);

        unmarried = new JRadioButton("Un-Married");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(450, 380, 100, 50);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(550, 380, 130, 50);
        add(other);

        ButtonGroup sts = new ButtonGroup();
        sts.add(married);
        sts.add(unmarried);
        sts.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 26));
        address.setBounds(150, 420, 600, 50);
        add(address);

        addresstf = new JTextField();
        addresstf.setFont(new Font("Raleway", Font.BOLD, 18));
        addresstf.setBounds(350, 430, 400, 30);
        add(addresstf);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 26));
        city.setBounds(150, 460, 600, 50);
        add(city);

        citytf = new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD, 18));
        citytf.setBounds(350, 470, 400, 30);
        add(citytf);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 26));
        state.setBounds(150, 500, 600, 50);
        add(state);

        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 18));
        statetf.setBounds(350, 510, 400, 30);
        add(statetf);

        JLabel country = new JLabel("Country:");
        country.setFont(new Font("Raleway", Font.BOLD, 26));
        country.setBounds(150, 540, 600, 50);
        add(country);

        countrytf = new JTextField();
        countrytf.setFont(new Font("Raleway", Font.BOLD, 18));
        countrytf.setBounds(350, 550, 400, 30);
        add(countrytf);

        JLabel code = new JLabel("Pin Code:");
        code.setFont(new Font("Raleway", Font.BOLD, 26));
        code.setBounds(150, 580, 600, 50);
        add(code);

        codetf = new JTextField();
        codetf.setFont(new Font("Raleway", Font.BOLD, 18));
        codetf.setBounds(350, 590, 400, 30);
        add(codetf);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(670, 630, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String formno = "" + random;
        String name = nametf.getText();
        String fname = frametf.getText();
      Date date = dobtf.getDate();
String dob = "";

if (date != null) {
//    dobtf sdf = new dobtf("dd-MM-yyyy");
//    dob = sdf.format(date);'
}


        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailtf.getText();

        String mrital = null;
        if (married.isSelected()) {
            mrital = "Married";
        } else if (unmarried.isSelected()) {
            mrital = "Unmarried";
        } else if (other.isSelected()) {
            mrital = "Other";
        }

        String address = addresstf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pin = codetf.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
                return;
            }
            else
            {
                connect c=new connect();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+mrital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignUP2(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignUp1();
    }
}
