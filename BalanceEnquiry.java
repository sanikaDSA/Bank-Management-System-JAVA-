
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{ 
    
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 600);
        add(image);
        
        back = new JButton("back");
        back.setBounds(200, 310, 135, 30);
        back.addActionListener(this);
        image.add(back);
        
         Conn c = new Conn();
         int balance = 0;
         try{
             ResultSet rs = (ResultSet) c.s.executeQuery("select * from bank where pin '"+pinnumber+"'");
             
             while(rs.next()){
                 if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt((String) rs.getString("amount"));
                 }else{
                    balance -= Integer.parseInt((String) rs.getString("amount"));
             }
             }     
        }catch (Exception e){
                        System.out.println(e);
                        }
           
        JLabel text = new JLabel("Your Current Account balance is Rs " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(110, 130, 400, 30);
        image.add(text);
        
        
        setSize(600, 600);
        setLocation(300, 0);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String args[]){
        new BalanceEnquiry("");
           
           
    }
}
                
    

