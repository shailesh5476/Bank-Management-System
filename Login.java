package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, clear, signup,Exit;
    JTextField cardText;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardText = new JTextField();
        cardText.setBounds( 300, 150, 230, 30 );
        cardText.setFont(new Font ("Arial",Font.BOLD,14));
        add(cardText);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds( 300, 220, 230, 30 );
        pinTextField.setFont(new Font ("Arial",Font.BOLD,14));
        add(pinTextField);
        
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.green);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.red);
        clear.setForeground(Color.black);
        clear.addActionListener(this);
        add(clear);
        
        
        signup = new JButton("CREATE ACCOUNT");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        Exit = new JButton("Cancel");   
        Exit.setBounds(600,400,150,30);
        Exit.setBackground(Color.RED);
        Exit.setForeground(Color.BLACK);
        Exit.addActionListener(this);
        add(Exit);
        
        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == clear){
        cardText.setText("");
        pinTextField.setText("");
    }else if(ae.getSource() == login){
         Conn conn = new Conn();
         String card = cardText.getText();
         String pin = pinTextField.getText();
         String Query = "SELECT * FROM Login WHERE Card_Number = '"+card+"' AND pin = '"+pin+"'";
         try{
             ResultSet rs = conn.s.executeQuery(Query);
             if(rs.next()){
                 setVisible(false);
                 new Transactions(pin).setVisible(true);
             }else{
                 JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN ");
             }
         }catch (Exception a){
             System.out.println(a);
         }
    }else if(ae.getSource() == signup){
        setVisible(false);
        new SignupOne().setVisible(true);  
    }else if(ae.getSource() == Exit){
        System.exit(0);
    }
}
public static void main(String args[]){
    new Login();
}
}
