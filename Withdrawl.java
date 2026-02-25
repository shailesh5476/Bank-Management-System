package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    JButton Exit,withdrawl;
    JTextField amount;
    String pin;
    Withdrawl(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 830);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdrawl in your");
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
        
        
        withdrawl = new JButton("Withdraw");   
        withdrawl.setBounds(380,470,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        setSize(960,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Exit){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog( null, "Please enter the Amount for Withdraw Transaction:");
            }else{
                try{
                    Conn conn = new Conn();
                    String Query = "INSERT INTO bank VALUES('"+pin+"','"+date+"','Withdrawl','"+number+"')";
                    conn.s.executeUpdate(Query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+"/- Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}
