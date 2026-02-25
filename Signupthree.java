package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Signupthree extends JFrame implements ActionListener {
    JRadioButton FD,RD,Salary,Current,Saving;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Signupthree(String formno){
        this.formno = formno;
        getContentPane().setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,26));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        Saving = new JRadioButton("Saving Account");
        Saving.setFont(new Font("Raleway",Font.BOLD,16));
        Saving.setBackground(Color.white);
        Saving.setBounds(100, 180, 150, 20);
        add(Saving);
        
        Current = new JRadioButton("Current Account");
        Current.setFont(new Font("Raleway",Font.BOLD,16));
        Current.setBackground(Color.white);
        Current.setBounds(100, 210, 150, 20);
        add(Current);
        
        Salary = new JRadioButton("Salary Account");
        Salary.setFont(new Font("Raleway",Font.BOLD,16));
        Salary.setBackground(Color.white);
        Salary.setBounds(300, 180, 150, 20);
        add(Salary);
        
        FD = new JRadioButton("Fixed Deposit Account");
        FD.setFont(new Font("Raleway",Font.BOLD,16));
        FD.setBackground(Color.white);
        FD.setBounds(300, 210, 250, 20);
        add(FD);
        
        RD = new JRadioButton("Recurring Deposit Account");
        RD.setFont(new Font("Raleway",Font.BOLD,16));
        RD.setBackground(Color.white);
        RD.setBounds(500, 180, 250, 20);
        add(RD);
        
        ButtonGroup BG = new ButtonGroup();
        BG.add(FD);
        BG.add(RD);
        BG.add(Salary);
        BG.add(Saving);
        BG.add(Current);
        
        
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,290,200,30);
        add(card);
        
        JLabel cardN = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cardN.setFont(new Font("Raleway",Font.BOLD,16));
        cardN.setBounds(400,290,300,20);
        add(cardN);
        
        JLabel cardN1 = new JLabel("Your 16 Digit Card Number");
        cardN1.setFont(new Font("Raleway",Font.BOLD,12));
        cardN1.setBounds(100,320,300,30);
        add(cardN1);

        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,100,30);
        add(pin);
        
        JLabel pin1 = new JLabel("XXXX");
        pin1.setFont(new Font("Raleway",Font.BOLD,16));
        pin1.setBounds(500,370,100,30);
        add(pin1);
                
        JLabel pinD = new JLabel("Your 4 Digit Password");
        pinD.setFont(new Font("Raleway",Font.BOLD,12));
        pinD.setBounds(100,400,300,30);
        add(pinD);
         
        JLabel Service = new JLabel("Services Required:");
        Service.setFont(new Font("Raleway",Font.BOLD,22));
        Service.setBounds(100,450,300,30);
        add(Service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100, 490, 80, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(100, 530, 150, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100, 570, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350, 490, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(350, 530, 150, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350, 570, 150, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are  correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100, 610, 800, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setForeground(Color.black);
        submit.setBackground(Color.green);
        submit.setFont(new Font("Raleway",Font.BOLD,24));
        submit.setBounds(650, 650, 120, 40);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.red);
        cancel.setFont(new Font("Raleway",Font.BOLD,24));
        cancel.setBounds(520, 650, 120, 40);
        cancel.addActionListener(this);
        add(cancel);
       
        setSize(850,820);
        setLocation(350,0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == submit){
        String Account = null;
        if(Saving.isSelected()){
            Account = "Saving Account";
        }else if(Current.isSelected()){
            Account = "Current Account";
        }else if(Salary.isSelected()){
            Account = "Salary Account";
        }else if(FD.isSelected()){
            Account = "Fixed Deposit Account";
        }else if(RD.isSelected()){
            Account = "Recurring Deposit Account";
        }
        Random random = new Random();
        String cardnumber = ""+Math.abs((random.nextLong()%90000000L)+2167013200000000L);
        String pin2 = ""+Math.abs((random.nextLong()%9000L)+1000L);
        String facility = "";
        if(c1.isSelected()){
            facility = facility + "ATM Card";
        }else if(c2.isSelected()){
            facility = facility + "Internet Banking";
            
        }else if (c3.isSelected()){
            facility = facility + "Mobile Banking";
        }else if (c4.isSelected()){
            facility = facility + "Email & SMS Alerts";
        }else if (c5.isSelected()){
            facility = facility + "Cheque Book";
        }else if (c6.isSelected()){
            facility = facility + "E-Statement";
        }
        
        try{
            if(Account.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is Required");
            }else{
                Conn conn = new Conn();
                String Query = "INSERT INTO createaccountthree VALUES ('"+formno+"', '"+Account+"','"+cardnumber+"','"+pin2+"','"+facility+"')";
                String Query1 = "INSERT INTO login VALUES ('"+formno+"','"+cardnumber+"','"+pin2+"')";
                
                conn.s.executeUpdate(Query);
                conn.s.executeUpdate(Query1);
                
                JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\nPIN: "+pin2);
                setVisible(false);
                new Deposit(pin2).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
    }else if (ae.getSource() == cancel){
           setVisible(false);
           new Login().setVisible(true);
    }
}
public static void main(String args[]){
    new Signupthree("");
}
}
