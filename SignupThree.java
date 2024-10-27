package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);  
        
        
        
     JLabel l1 = new JLabel("Page 3 : Account Details ");
     l1.setFont(new Font("Raleway",Font.BOLD,22));
    l1.setBounds(280,40,400,40);
    add(l1);
    
    JLabel type = new JLabel("Account Type : ");
    type.setFont(new Font("Raleway",Font.BOLD,22));
    type.setBounds(100,100,400,40);
    add(type); 
    
    r1 = new JRadioButton("Saving Account");
    r1.setBounds(100,150,200,30);
    add(r1);
    
    r2 = new JRadioButton("Current Account");
    r2.setBounds(100,180,200,30);
    add(r2);
     
    r3 = new JRadioButton("Fixed Deposit Account");
    r3.setBounds(300,150,400,30);
    add(r3);
    
    r4 = new JRadioButton("Recurring Deposit Account");
    r4.setBounds(300,180,400,30);
    add(r4);
     
     ButtonGroup accountTypegroup = new ButtonGroup();
        accountTypegroup.add(r1);
        accountTypegroup.add(r2 );
        accountTypegroup.add(r3);
        accountTypegroup.add(r4);
        
        
        
        
    JLabel card = new JLabel("Card Number : ");
    card.setFont(new Font("Raleway",Font.BOLD,22));
    card.setBounds(100,240,200,40);
    add(card); 
    JLabel card1 = new JLabel("(Your 16 Digit Card Number )");
    card1.setFont(new Font("Raleway",Font.BOLD,11));
    card1.setBounds(102,270,200,20);
    add(card1); 
    
    
    JLabel no = new JLabel("XXXX-XXXX-XXXX-1315 ");
    no.setFont(new Font("Raleway",Font.BOLD,22));
    no.setBounds(300,240,400,40);
    add(no); 
    
    JLabel pin = new JLabel("PIN : ");
    pin.setFont(new Font("Raleway",Font.BOLD,22));
    pin.setBounds(100,320,100,40);
    add(pin);
    JLabel pin1 = new JLabel("(Your 4 Digit Password )");
    pin1.setFont(new Font("Raleway",Font.BOLD,11));
    pin1.setBounds(102,350,200,20);
    add(pin1); 
    
    JLabel pass = new JLabel("XXXX");
    pass.setFont(new Font("Raleway",Font.BOLD,22));
    pass.setBounds(300,320,200,40);
    add(pass); 
    
    JLabel service = new JLabel("Service Required : ");
    service.setFont(new Font("Raleway",Font.BOLD,22));
    service.setBounds(100,400,400,40);
    add(service);
    
    c1 = new JCheckBox("ATM Card");
    c1.setBounds(100, 450, 200, 40);
    add(c1);
    
    c2 = new JCheckBox("Mobile Banking");
    c2.setBounds(100, 520, 200, 40);
    add(c2);
    
    c3 = new JCheckBox("Cheque Book");
    c3.setBounds(100, 590, 200, 40);
    add(c3);
    
    c4 = new JCheckBox("Internet Banking");
    c4.setBounds(300, 450, 200, 40);
    add(c4);
    
    c5 = new JCheckBox("E-mail & SMS Alerts");
    c5.setBounds(300, 520, 200, 40);
    add(c5);
    
    c6 = new JCheckBox("E-Statement");
    c6.setBounds(300, 590, 200, 40);
    add(c6);
    
    c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge ");
    c7.setBounds(80, 660, 800, 40);
    add(c7);
    
    cancel = new JButton("CANCEL");
    cancel.setBackground(Color.RED);
    cancel.setForeground(Color.black);
    cancel.setBounds(250, 720, 100, 40);
    cancel.addActionListener(this);
    add(cancel);
    
    submit = new JButton("SUBMIT");
    submit.setBackground(Color.green);
    submit.setForeground(Color.black);
    submit.setBounds(400, 720, 100, 40);
    submit.addActionListener(this);
    add(submit);
    
    
    getContentPane().setBackground(Color.white);
    setSize(850,820);
    setLocation(350,0);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){
            
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if (r2.isSelected()){
                accountType = "Current account";
            }else if (r3.isSelected()){
                accountType = "Fixed Deposit account";
            }else if (r4.isSelected()){
                accountType = "Recurring Deposit account";
            }
            
            Random random = new Random();
            String cardnumber = ""+ Math.abs((random.nextLong()% 90000000L)+ 2024131500000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong()% 9000L)+ 1000L);
            
            String facility = " ";
            if (c1.isSelected()){
                facility += "ATM Card";
            } else if (c2.isSelected()){
                facility += "Mobile Banking";
            }else if (c3.isSelected()){
                facility += "Cheque Book";
            }else if (c4.isSelected()){
                facility += "Internet Banking";
            }else if (c5.isSelected()){
                facility += "E-mail & SMS Alerts";
            }else if (c6.isSelected()){
                facility += "E-Statement";
            }
            try{
                if (accountType.equals(" ")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required ");
                }else {
                    conn c = new conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                 
                    c.s.executeUpdate(query1);  
                    c.s.executeUpdate(query2);  
                
                    JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                    JOptionPane.showMessageDialog(null, "Card Number" + cardnumber + "\n Pin Number" + pinnumber);
                
                }
            
            
            }catch (Exception e){
                System.out.println(e);
            
            }
            
            
            
        }else if(ae.getSource()==cancel){
        
        }
    
    
    }
    
    
    public static void main(String args[]){
        new SignupThree("");
    }



}