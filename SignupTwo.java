 
package bank.managment.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton other, syes, sno,eyes,eno;
  
    JComboBox religion, Category, occupation, education,income;
    String formno;
    private String catrgory;
    
    
    SignupTwo(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Ralway",Font.BOLD, 38));
        additionalDetails.setBounds(140, 15, 600, 40);
        add(additionalDetails);
        
        
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Ralway",Font.BOLD, 20));
        name.setBounds(100, 110, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 110, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
       
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Ralway",Font.BOLD, 20));
        fname.setBounds(100, 170, 200, 30);
        add(fname);
        
        String vaLCategory[] = {"General","OBC","SC","ST","other"};
        Category = new JComboBox(vaLCategory);
        Category.setBounds(300, 170, 400, 30);
        Category.setBackground(Color.WHITE);
        add(Category);
 
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Ralway",Font.BOLD, 20));
        dob.setBounds(100, 210, 200, 30);
        add(dob);
        
        String incomeCategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 210, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
 
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Ralway",Font.BOLD, 20));
        gender.setBounds(100, 250, 200, 30);
        add(gender);
        
        String educationValues[] = {"Non Graduation","Graduate","Post-Graduate","Doctrate","others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 270, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
 
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Ralway",Font.BOLD, 20));
        email.setBounds(100, 280, 200, 30);
        add(email);
        
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Ralway",Font.BOLD, 20));
        marital.setBounds(100, 350, 200, 30);
        add(marital);
        
        String occupationValues[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 350, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
 
        
        
        JLabel address = new JLabel("PAN No:");
        address.setFont(new Font("Ralway",Font.BOLD, 20));
        address.setBounds(100, 400, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 400, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("Adhar No:");
        city.setFont(new Font("Ralway",Font.BOLD, 20));
        city.setBounds(100, 440, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 440, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Ralway",Font.BOLD, 20));
        state.setBounds(100, 480, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 480, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 480, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        ButtonGroup marrigegroup = new ButtonGroup();
        marrigegroup.add(syes);
        marrigegroup.add(sno);
        
        
        
        
        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Ralway",Font.BOLD, 20));
        existing.setBounds(100, 530, 200, 30);
        add(existing);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 530, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 530, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        ButtonGroup emarrigegroup = new ButtonGroup();
        emarrigegroup.add(eyes);
        emarrigegroup.add(eno);
       
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 570, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(new Color(252, 208, 76));
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) Category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
         } else if (eno.isSelected()) {
              existingaccount= "No";
         }
        
        
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
         } else if (sno.isSelected()) {
             seniorcitizen = "No";
         } 
        
        String span = addressTextField.getText();
        String saadhar = cityTextField.getText();
        
        
        try{
            
                Conn c = new Conn();
                String query = "insert into signuptwo (formno,religion,category,income,education,occupation,aadhar,seniorcitizen,existingaccount)"+" values('"+formno+"','"+religion+"','"+catrgory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);

             
            
            //Signup3 Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
           }catch (Exception e) {
            System.out.println(e);
            
        }

                
        
    }
    
    public static void main(String args[]){
        new SignupTwo("");
        
    }
    
}
