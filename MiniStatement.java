package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    MiniStatement( String pin){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        
        JLabel mini = new JLabel("");
        mini.setBounds(20, 140 ,400 ,350 );
        add(mini);
        
        JLabel bank = new JLabel("Private Bank");
        bank.setFont(new Font("Raleway",Font.BOLD,30));
        bank.setBounds(100, 20, 200, 25);
        add(bank);
        
        JLabel bank1 = new JLabel("Date & Time");
        bank1.setFont(new Font("Raleway",Font.BOLD,16));
        bank1.setBounds(60, 130, 200, 20);
        add(bank1);
        
        JLabel bank2 = new JLabel("Type");
        bank2.setFont(new Font("Raleway",Font.BOLD,16));
        bank2.setBounds(210, 130, 200, 20);
        add(bank2);
        
        JLabel bank3 = new JLabel("Amount");
        bank3.setFont(new Font("Raleway",Font.BOLD,16));
        bank3.setBounds(280, 130, 200, 20);
        add(bank3);
        
        
        
        JLabel card = new JLabel();
        card.setFont(new Font("Raleway",Font.BOLD,18));
        card.setBounds(10, 80, 350, 20);
        add(card);
        
        
        JLabel b = new JLabel("Your current account balance is");
        
        b.setBounds(10, 500, 380, 20);
        b.setFont(new Font("Raleway",Font.BOLD,20));
        add(b);
        
        JLabel balance = new JLabel();
        balance.setBounds(10, 520, 380, 20);
        balance.setFont(new Font("Raleway",Font.BOLD,20));
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pin = '"+pin+"'");
            
            while(rs.next()){
                card.setText("Card Number:"+rs.getString("Card_Number").substring(0, 4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
            while(rs.next()){
                
                mini.setText(mini.getText()+ "<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount")+"<br><br><html>");
                 if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                } 
            }
            balance.setText(" Rs."+ bal+"\\-");
            
        }catch (Exception e){
            System.out.println(e);
        }
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
