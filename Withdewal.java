package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdewal extends JFrame  implements ActionListener{
    
    JTextField amount;
    JButton withdra, back;
    String pinnumber;
    Withdewal(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(150, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(150, 300, 300, 30);
        amount.setFont(new Font("Arial",Font.BOLD, 14));
        image.add(amount);
        
        
        
        withdra = new JButton("Withdrawl");
        withdra.setBounds(300, 400, 130, 25);
        withdra.addActionListener(this);
        image.add(withdra);
        
        back = new JButton("Back");
        back.setBounds(300, 430, 130, 25);
        back.addActionListener(this);
         image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdra) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else{
                try{
                Conn con = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','"+withdra+"','"+amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdrawal Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
              } catch (Exception e){
                  System.out.println(e);
              }
                
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new Withdewal("");
    }
}


 