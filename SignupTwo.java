package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    JTextField adhTextField,panTextField;
    JButton next;
    String formno;
    JRadioButton Yes,No,eNo,eYes;
    JComboBox religion,category,income,educatonvalues,educatonvalues1;
    SignupTwo(String formno){
        
        this.formno = formno;
        getContentPane().setLayout(null); 
        setTitle("NEW ACCOUNT APPLICATION FORM NO - PAGE 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font ("Raleway",Font.BOLD,26));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font ("Raleway",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);
        
        String val[] = {"---Select---","Hindu","Muslim","Sikh","Christian","Others"};
        religion = new JComboBox(val);
        religion.setBounds(300,140,200,25);
        add(religion);
        
          
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font ("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        
        String val1[] = {"---Select---","General","OBC","SC","ST","Others"};
        category = new JComboBox(val1);
        category.setBounds(300,190,200,25);
        add(category);
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font ("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        
        String income1[] = {"---Select---","NULL","< 1,50,000","< 2,50,000","< 5,00,000","< 8,00,000","Upto 10,00,000"};
        income = new JComboBox(income1);
        income.setBounds(300,240,200,25);
        add(income);
             
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font ("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
              
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font ("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String educaton[] = {"---Select---","Non-Graduation","Graduation","Post Graduation","Doctrate","8th","10th","12th","ITI/Diploma","Polytechnic"};
        educatonvalues = new JComboBox(educaton);
        educatonvalues.setBounds(300,310,200,25);
        add(educatonvalues);
        

        JLabel mari = new JLabel("Occupation:");
        mari.setFont(new Font ("Raleway",Font.BOLD,20));
        mari.setBounds(100,370,200,30);
        add(mari);
       
        String educaton1[] = {"---Select---","Salaried","Self-Employed","Bussiness","Student","Retired","Agriculture","Others"};
        educatonvalues1 = new JComboBox(educaton1);
        educatonvalues1.setBounds(300,370,200,25);
        add(educatonvalues1);
        
        
        
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font ("Raleway",Font.BOLD,20));
        address.setBounds(100,420,200,30);
        add(address);
        
        
        
        panTextField = new JTextField();
        panTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,420,200,25);
        add(panTextField);
        
        
        JLabel city = new JLabel("Adhar Number:");
        city.setFont(new Font ("Raleway",Font.BOLD,20));
        city.setBounds(100,470,200,30);
        add(city);
        
       
        adhTextField = new JTextField();
        adhTextField.setFont(new Font ("Raleway",Font.BOLD,14));
        adhTextField.setBounds(300,470,200,25);
        add(adhTextField);
        
       
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font ("Raleway",Font.BOLD,20));
        state.setBounds(100,520,200,30);
        add(state);
        
        
        Yes = new JRadioButton("YES");
        Yes.setBounds(300, 520, 60, 25);
        Yes.setBackground(Color.white);
        add(Yes);
        
        
        No = new JRadioButton("NO");
        No.setBounds(420, 520, 60, 25);
        No.setBackground(Color.white);
        add(No);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(Yes);
        senior.add(No);
        
        
        JLabel pin   = new JLabel("Exisiting Account:");
        pin.setFont(new Font ("Raleway",Font.BOLD,20));
        pin.setBounds(100,570,200,30);
        add(pin);
        
        
       
        eYes = new JRadioButton("YES");
        eYes.setBounds(300, 570, 60, 25);
        eYes.setBackground(Color.white);
        add(eYes);
        
        
        eNo = new JRadioButton("NO");
        eNo.setBounds(420, 570, 60, 25);
        eNo.setBackground(Color.white);
        add(eNo);
        
        ButtonGroup exist = new ButtonGroup();
        exist.add(Yes);
        exist.add(No); 
        
        
        
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
    String reli = (String)religion.getSelectedItem();
    String cate = (String)category.getSelectedItem();
    String inco = (String)income.getSelectedItem();
    String edu = (String)educatonvalues.getSelectedItem();
    String occu = (String)educatonvalues1.getSelectedItem();
    String pan = panTextField.getText();
    String adhaar =  adhTextField.getText();
    String senior = null;
    if(Yes.isSelected()){
        senior = "YES";
    }else if(No.isSelected()){
        senior = "NO";
    }
    String exis = null;
    if(eYes.isSelected()){
        exis = "YES";
    }else if(eNo.isSelected()){
        exis = "NO";
    }     
    try{
        Conn c = new Conn();
        String query = "insert into createaccounttwo values ('"+formno+"','"+reli+"','"+cate+"','"+inco+"','"+edu+"','"+occu+"','"+pan+"','"+adhaar+"','"+senior+"','"+exis+"')";
        c.s.executeUpdate(query);
        setVisible(false);
        new Signupthree(formno).setVisible(true);
                
    }catch (Exception e){
        System.out.println(e);
    }
}

 
public static void main(String args[]){
    new SignupTwo("");
}
}
