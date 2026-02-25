package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JButton Exit,deposit;
    JTextField amount;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 830);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Deposit in your");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 300, 500, 30);
        image.add(text);
        
        JLabel text1 = new JLabel("Account:");
        text1.setForeground(Color.white);
        text1.setFont(new Font("System",Font.BOLD,16));
        text1.setBounds(170, 330, 80, 30);
        image.add(text1);        
        
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(250,330,200,30);
        image.add(amount);
        
        Exit = new JButton("Back");   
        Exit.setBounds(200,470,150,30);
        Exit.addActionListener(this);
        image.add(Exit);
        
        
        deposit = new JButton("Deposit");   
        deposit.setBounds(380,470,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        setSize(960,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Exit){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }else if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog( null, "Please enter the Amount for Deposit Transaction:");
            }else{
                try{
                    Conn conn = new Conn();
                    String Query = "INSERT INTO bank VALUES('"+pin+"','"+date+"','Deposit','"+number+"')";
                    conn.s.executeUpdate(Query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+"/- Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    public static void main(String args[]){
        new Deposit("");
    }
}
