package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Pinchange extends JFrame implements ActionListener {
    String pinChange;
    JPasswordField pinText,RepinText;
    JButton Change,Back;
    Pinchange(String pinChange){
        this.pinChange = pinChange;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 830);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(270, 270, 500, 30);
        text.setForeground(Color.white); 
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(210, 320, 100,25);
        pintext.setForeground(Color.white); 
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
        
        pinText = new JPasswordField ();
        pinText.setFont(new Font ("Raleway",Font.BOLD,14));
        pinText.setBounds(340,320,100,25);
        add(pinText);
        
        
        JLabel Repintext = new JLabel("Re-Enter PIN:");
        Repintext.setBounds(210, 360, 120,25);
        Repintext.setForeground(Color.white); 
        Repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(Repintext);
        
        
        RepinText = new JPasswordField();
        RepinText.setFont(new Font ("Raleway",Font.BOLD,14));
        RepinText.setBounds(340,360,100,25);
        add(RepinText);

        
        Change = new JButton("Change");
        Change.setFont(new Font("Raleway",Font.BOLD,18));
        Change.setBounds(370, 440, 130, 30);
        Change.addActionListener(this);
        image.add(Change);
        
        
        Back = new JButton("Back");
        Back.setFont(new Font("Raleway",Font.BOLD,18));
        Back.setBounds(220, 440, 130, 30);
        Back.addActionListener(this);
        image.add(Back);
        
        
        
        setSize(960,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Change){
            try{
                String npin = pinText.getText();
                String Rpin = RepinText.getText();
                if(!npin.equals(Rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN is not match");
                    
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                }
                
                if(Rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                }
                
                Conn c = new Conn();
                String Q1 = "update bank set pin = '"+Rpin+"' where pin = '"+pinChange+"'";
                String Q2 = "UPDATE createaccountthree set pin_NUmber = '"+Rpin+"' where pin_NUmber = '"+pinChange+"'";
                String Q3 = "UPDATE login set pin = '"+Rpin+"' where pin = '"+pinChange+"'";
                
                c.s.executeUpdate(Q1);
                c.s.executeUpdate(Q2);
                c.s.executeUpdate(Q3);
                
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new Transactions(Rpin).setVisible(true);
                
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinChange).setVisible(true);
        }
    }
    public static void  main(String args[]){
        new Pinchange("").setVisible(true);
    }
}
