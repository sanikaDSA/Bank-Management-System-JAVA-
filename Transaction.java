
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit, withdrawal, fastcash, ministatement, pinchange, balance, exit;
    String pinnumber;
    Transaction(String pinnumber){
       
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(180, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(150, 330, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Cash Withdra");
        withdrawal.setBounds(300, 330, 130, 25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150, 360, 130, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(150, 420, 130, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("PIN Change");
        pinchange.setBounds(150, 390, 130, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
      
        balance = new JButton("Balance Enquiry");
        balance.setBounds(300, 360, 130, 25);
        balance.addActionListener(this);
        image.add(balance);
      
        exit = new JButton("Exit");
        exit.setBounds(300, 390, 130, 25);
        exit.addActionListener(this);
        image.add(exit);
      
        
        setSize(800, 800);
        setLocation(300, 0);
     //   setUndecorated(true);
        setVisible(true);
        
    }

    Transaction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
            
        } else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdewal(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
         }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
          }else if(ae.getSource() == balance){
             setVisible(false);
              new BalanceEnquiry(pinnumber).setVisible(true);
           } else if(ae.getSource() == ministatement){
           
              new MiniStatement(pinnumber).setVisible(true);
    } 
    }
    public static void main(String args[]){
        new Transaction("");
    }

   

    
}
