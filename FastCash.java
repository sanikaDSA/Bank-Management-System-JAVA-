package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdrawal, fastcash, ministatement, pinchange, balance, exit;
    String pinnumber;
    private String Withdra;
    FastCash(String pinnumber){
       
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRWL AMOUNT");
        text.setBounds(180, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Rs.100");
        deposit.setBounds(150, 330, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Rs.500");
        withdrawal.setBounds(300, 330, 130, 25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Rs.1000");
        fastcash.setBounds(150, 360, 130, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        
        pinchange = new JButton("Rs.5000");
        pinchange.setBounds(150, 390, 130, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
      
        balance = new JButton("Rs.2000");
        balance.setBounds(300, 360, 130, 25);
        balance.addActionListener(this);
        image.add(balance);
      
        exit = new JButton("Rs.10000");
        exit.setBounds(300, 390, 130, 25);
        exit.addActionListener(this);
        image.add(exit);
      
        ministatement = new JButton("BACK ");
        ministatement.setBounds(300, 420, 130, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        setSize(800, 800);
        setLocation(300, 0);
     //   setUndecorated(true);
        setVisible(true);
        
    }

    FastCash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = (ResultSet) c.s.executeQuery("select * from bank where pin '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt((String) rs.getString("amount"));
                    }else{
                         balance -= Integer.parseInt((String) rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                
                String query = "insert into bank values('"+pinnumber+"','"+date+"','"+Withdra+"','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + "Debited Sucessfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        } 
    }
    public static void main(String args[]){
        new FastCash("");
    }

   

    
}
