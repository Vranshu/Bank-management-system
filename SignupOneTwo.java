package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;




public class SignupOneTwo extends JFrame implements ActionListener {    
     long random;
     JTextField panTextField ,aadharnoTextField;
     JRadioButton yes, no,existingyes,existingno;
     JComboBox<String> sreligion, category, income, education, occupation;
//     JDateChooser dateChooser;
     JButton next;
     String formno;
     
    SignupOneTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");
  
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font ("Raleway ",Font.BOLD,20));
        additionalDetails.setBounds(290,50,400,40);
        add(additionalDetails);
        
        JLabel Religion = new JLabel("Religion : ");
        Religion.setFont(new Font ("Raleway ",Font.BOLD,20));
        Religion.setBounds(100,140,200,30);
        add(Religion);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Cristian","Other"};
        sreligion = new JComboBox<>(valReligion);
        sreligion.setBounds(300,140,400,30);
        add(sreligion);
        
        JLabel Category = new JLabel("Category : ");
        Category.setFont(new Font ("Raleway ",Font.BOLD,20));
        Category.setBounds(100,190,200,30);
        add(Category);
        String valCategory[]={"Gineral","OBC","SC","ST","Other"};
        
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        add(category);
        
        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font ("Raleway ",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        String valIncome[]={"Nill","<1,50,000","<2,50,000","<5,00,000","Upto 10L"};
        
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        add(income);
        
        
        JLabel Educational = new JLabel("Educational  ");
        Educational.setFont(new Font ("Raleway ",Font.BOLD,20));
        Educational.setBounds(100,290,200,30);
        add(Educational);
        JLabel Qualification = new JLabel("Qualification : ");
        Qualification.setFont(new Font ("Raleway ",Font.BOLD,20));
        Qualification.setBounds(100,315,200,30);
        add(Qualification);
        String educationValues[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
        
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        add(education);
     
        JLabel Occupation = new JLabel("Occupation : ");
        Occupation.setFont(new Font ("Raleway ",Font.BOLD,20));
        Occupation.setBounds(100,365,200,30);
        add(Occupation);
        String OccupationValues[]={"Salaried","Self-Employed","Business","Student","Retired"};
        
        occupation = new JComboBox(OccupationValues);
        occupation.setBounds(300,365,400,30);
        add(occupation);
        
        
        JLabel Pan = new JLabel("PAN Number : ");
        Pan.setFont(new Font ("Raleway ",Font.BOLD,20));
        Pan.setBounds(100,440,200,30);
        add(Pan);
        panTextField = new JTextField();
        panTextField.setFont (new Font("Raleway",Font.BOLD,15));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        
        JLabel aadharno = new JLabel("Aadhar Number : ");
        aadharno.setFont(new Font ("Raleway ",Font.BOLD,20));
        aadharno.setBounds(100,490,200,30);
        add(aadharno);
        aadharnoTextField = new JTextField();
        aadharnoTextField.setFont (new Font("Raleway",Font.BOLD,15));
        aadharnoTextField.setBounds(300, 490, 400, 30);
        add(aadharnoTextField);
        
         
        JLabel state = new JLabel("Senior Citizen : ");
        state.setFont(new Font ("Raleway ",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300,540,100,30);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(400,540,100,30);
        add(no);
     
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(yes);
        gendergroup.add(no);
  
        JLabel pin = new JLabel(" Existing Account: ");
        pin.setFont(new Font ("Raleway ",Font.BOLD,20));
        pin.setBounds(100,600,200,30);
        add(pin);
        
        existingyes = new JRadioButton("Yes");
        existingyes.setBounds(300,600,100,30);
        add(existingyes);
        
        existingno = new JRadioButton("No");
        existingno.setBounds(400,600,100,30);
        add(existingno);
     
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existingyes);
        existingGroup.add(existingno);
        
        //NEXT BUTTON GO TO NEXT PAGE
        
        next = new JButton("Next");
        next.setBackground(Color.green);
        next.setForeground(Color.black);
        next.setBounds(600, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,20);
        setVisible(true);
        
        
    }
    public void actionPerformed (ActionEvent ae){
           // Collect data from form components
        String formno = ""+ random;
        String religion = (String) sreligion.getSelectedItem();
        String categoryValue = (String) category.getSelectedItem();
        String incomeValue = (String) income.getSelectedItem();
        String educationValue = (String) education.getSelectedItem();
        String occupationValue = (String) occupation.getSelectedItem();
        String panNumber = panTextField.getText();
        String aadharNumber = aadharnoTextField.getText();
        String seniorCitizen = yes.isSelected() ? "Yes" : "No";
        String existingAccount = existingyes.isSelected() ? "Yes" : "No";

         try{
                conn c = new conn();
                String query = "INSERT INTO signupTwo (formno,religion, category,"
                        + " income, education, occupation, pan_number, aadhar_number,"
                        + " senior_citizen, existing_account) "
                        + "VALUES ('" + formno + "','" + religion + "', '" + categoryValue + "',"
                        + " '" + incomeValue + "', '" + educationValue + "', '" + occupationValue + "',"
                        + " '" + panNumber + "', '" + aadharNumber + "', '" + seniorCitizen + "', '" + existingAccount + "')";
                 c.s.executeUpdate(query); 
                 
                setVisible(false);
                new SignupThree(formno).setVisible(true);
         
         } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]){
        new SignupOneTwo("");
    
    
    }
}