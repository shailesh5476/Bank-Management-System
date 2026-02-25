package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,mini,pinchange,balance,Exit;
    String pin;
    Transactions(String pin){
        this.pin = pin; 
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 830);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 270, 700, 30);
        text.setForeground(Color.white); 
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);
        
        deposit = new JButton("Deposit");   
        deposit.setBounds(185,320,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Cash Withdrawl");   
        withdraw.setBounds(185,360,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        
        fastcash = new JButton("Fast Cash");   
        fastcash.setBounds(185,400,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        mini = new JButton("Mini Statement");   
        mini.setBounds(375,320,150,30);
        mini.addActionListener(this);
        image.add(mini);
        
        pinchange = new JButton("PIN Change");   
        pinchange.setBounds(375,360,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Check Balance");   
        balance.setBounds(375,400,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
        Exit = new JButton("Exit");   
        Exit.setBounds(380,470,150,30);
        Exit.addActionListener(this);
        image.add(Exit);
        
        

        
        setSize(960,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);

        }else if(ae.getSource() == withdraw){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if (ae.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        }else if (ae.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pin).setVisible(true);
        }else if (ae.getSource() == balance){
            setVisible(false);
            new Balance(pin).setVisible(true);
        }else if (ae.getSource() == mini){
            new MiniStatement(pin).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
