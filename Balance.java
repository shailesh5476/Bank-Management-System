package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Balance extends JFrame implements ActionListener {
    String pin;
    JButton Back;
    Balance(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 830);
        add(image);
        
        Back = new JButton("Back");
        Back.setFont(new Font("Raleway",Font.BOLD,18));
        Back.setBounds(220, 440, 130, 30);
        Back.addActionListener(this);
        image.add(Back);
        
        
        Conn c = new Conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pin+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text1 = new JLabel("WELCOME");
        text1.setBounds(300, 270, 500, 30);
        text1.setForeground(Color.white); 
        text1.setFont(new Font("System",Font.BOLD,20));
        image.add(text1);

        
        JLabel text = new JLabel("Your Current balance is Rs."+balance+"\\-");
        text.setBounds(170, 320, 500, 30);
        text.setForeground(Color.white); 
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);
        
        
        setSize(960,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
              
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
    public static void main(String args[]){
        new Balance("");
    }
    
}
