package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.SimpleDateFormat;


public class SignupOne extends JFrame implements ActionListener {    
     long random;
     JTextField nameTextField,pinTextField,fnameTextField,
             emailTextField,addressTextField ,cityTextField,stateTextField;
     JRadioButton male, female, other, married,unmarried;
     JDateChooser dateChooser; 
     JButton next;
     JLabel formno;           
     
    SignupOne() {
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs(ran.nextLong()% 9000L)+ 1000L;
         
        formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font ("Raleway ",Font.BOLD,38));
        formno.setBounds(140, 20, 600,40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font ("Raleway ",Font.BOLD,20));
        personDetails.setBounds(290,80,400,40);
        add(personDetails);
        
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font ("Raleway ",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont (new Font("Raleway",Font.BOLD,15));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        
        
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font ("Raleway ",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont (new Font("Raleway",Font.BOLD,15));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        
        
        
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font ("Raleway ",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 250, 30);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font ("Raleway ",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400,290,100,30);
        add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(500,290,100,30);
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font ("Raleway ",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont (new Font("Raleway",Font.BOLD,15));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font ("Raleway ",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        add(married);
        
         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,390,100,30);
        add(unmarried);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        
        
        
        
        
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font ("Raleway ",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont (new Font("Raleway",Font.BOLD,15));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        
        JLabel city = new JLabel("City : ");
        city.setFont(new Font ("Raleway ",Font.BOLD,20));
        city.setBounds(100,490,100,30);
        add(city);
        
        
        cityTextField = new JTextField();
        cityTextField.setFont (new Font("Raleway",Font.BOLD,15));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
         
         JLabel state = new JLabel("State : ");
        state.setFont(new Font ("Raleway ",Font.BOLD,20));
        state.setBounds(100,540,100,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont (new Font("Raleway",Font.BOLD,15));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        
         
        JLabel pin = new JLabel("Pin Code : ");
        pin.setFont(new Font ("Raleway ",Font.BOLD,20));
        pin.setBounds(100,600,200,30);
        add(pin);
        
        
        pinTextField = new JTextField();
        pinTextField.setFont (new Font("Raleway",Font.BOLD,15));
        pinTextField.setBounds(300, 600, 400, 30);
        add(pinTextField);
        
        
        
        
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
        String formno = ""+random ;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
          // Format the date to 'YYYY-MM-DD' format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dob = sdf.format(dateChooser.getDate()); // Get the date as a properly formatted string
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "female";
        
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
            
        
        }else if (unmarried.isSelected()){
            marital = "Unmarried";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
                return;
            }
            if (address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Required");
                return;
            }
            
            
            if (city.equals("")){
                JOptionPane.showMessageDialog(null, "City is Required");
                return;
            }
            
            if (dob.equals("")){
                JOptionPane.showMessageDialog(null, "DOB is Required");
                return;
            }
            
           
            if (state.equals("")){
                JOptionPane.showMessageDialog(null, "State is Required");
                
         
            }else{
                conn c = new conn();
                String query = "insert into signup values('"+formno+"','" +name+ "',"
                        + "'"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"',"
                        + "'"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query); 
//                JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                setVisible(false);
            new SignupOneTwo(formno).setVisible(true);
            
            }
           
        
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    }
    
    public static void main(String args[]){
        new SignupOne();
    
    
    }

  




}