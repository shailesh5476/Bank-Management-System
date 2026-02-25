package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {
    JTextField nameTextField,pinTextField,FnameTextField,stateTextField,cityTextField,mailTextField,addTextField;
    long random;
    JButton next;
    JDateChooser datechoose;
    JRadioButton Male,Female,Marrid,unmarride,divorced;
    SignupOne(){
        
        getContentPane().setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() %9000L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO.  " + random);
        formno.setFont(new Font ("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personal = new JLabel("Page 1: Personal Details");
        personal.setFont(new Font ("Raleway",Font.BOLD,26));
        personal.setBounds(290,80,400,30);
        add(personal);
        
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font ("Raleway",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);
        
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,200,25);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father Name:");
        fname.setFont(new Font ("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        FnameTextField = new JTextField();
        FnameTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        FnameTextField.setBounds(300,190,200,25);
        add(FnameTextField);
        
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font ("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        
        datechoose = new JDateChooser();
        datechoose.setBounds(300,240,200,25);
        datechoose.setForeground(Color.black);
        add(datechoose);
        
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font ("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);


        Male = new JRadioButton("Male");
        Male.setBounds(300, 290, 60, 25);
        Male.setBackground(Color.white);
        add(Male);
        
        
        Female = new JRadioButton("Female");
        Female.setBounds(450, 290, 120, 25);
        Female.setBackground(Color.white);
        add(Female);
        
        ButtonGroup genderG = new ButtonGroup();
        genderG.add(Male);
        genderG.add(Female);
        
        
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font ("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        
        
        mailTextField = new JTextField();
        mailTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        mailTextField.setBounds(300,340,200,25);
        add(mailTextField);
        

        JLabel mari = new JLabel("Marital Status:");
        mari.setFont(new Font ("Raleway",Font.BOLD,20));
        mari.setBounds(100,390,200,30);
        add(mari);
        
        
        
        Marrid = new JRadioButton("Married");
        Marrid.setBounds(300, 390, 120, 25);
        Marrid.setBackground(Color.white);
        add(Marrid);
        
        
        unmarride = new JRadioButton("Unmarried");
        unmarride.setBounds(420, 390, 130, 25);
        unmarride.setBackground(Color.white);
        add(unmarride);
        
        divorced = new JRadioButton("Divorced");
        divorced.setBounds(550, 390, 140, 25);
        divorced.setBackground(Color.white);
        add(divorced);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(Marrid);
        maritalGroup.add(unmarride);
        maritalGroup.add(divorced);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font ("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        
        
        addTextField = new JTextField();
        addTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        addTextField.setBounds(300,440,200,25);
        add(addTextField);
        
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font ("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
       
        cityTextField = new JTextField();
        cityTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,200,25);
        add(cityTextField);
        
       
        JLabel state = new JLabel("State:");
        state.setFont(new Font ("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,200,25);
        add(stateTextField);
        
        
        JLabel pin   = new JLabel("PIN Code:");
        pin.setFont(new Font ("Raleway",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);
        
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,200,25);
        add(pinTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.blue);
        next.setForeground(Color.black);
        next.setFont(new Font("Raleway",Font.BOLD,16));
        next.setBounds(650, 630, 80, 40);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    
 public void actionPerformed(ActionEvent ae){
    String formno = "" + random;
    String name = nameTextField.getText();
    String fname = FnameTextField.getText();
    String dob = ((JTextField)datechoose.getDateEditor().getUiComponent()).getText(); 
    String gen = null;
    if(Male.isSelected()){
        gen = "Male";
    }else if(Female.isSelected()){
        gen = "Female";
    }
    String mail = mailTextField.getText();
    String mar = null;
    if(Marrid.isSelected()){
        mar = "Married";
    }else if(unmarride.isSelected()){
        mar = "Unmarried";
    }else if(divorced.isSelected()){
        mar = "Divorced";
    }
    String add = addTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pin = pinTextField.getText();
    
     
    try{
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is Required");
        }else if(dob.equals("")){
            JOptionPane.showMessageDialog(null,"Date of Birth is Required");
        }else {
            Conn c = new Conn();
            String query = "insert into createaccount values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gen+"','"+mail+"','"+mar+"','"+add+"','"+city+"','"+state+"','"+pin+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }        
    }catch (Exception e){
        System.out.println(e);
    }
}

 
public static void main(String args[]){
    new SignupOne();
}
}
