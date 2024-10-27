package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener { 
    
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        
        //SET THE TITLE OF FRAME
        setTitle("**AUTOMATIC TELLER MACHINE (ATM)**");
        setLayout(null);
        
        
        
        // SET IMAGEICON IN FRAME
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/deposit.png"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
            //CREATE LABEL
        JLabel label1 = new JLabel(i3);
        label1.setBounds(100,80,100,100);
        add(label1);
        
        JLabel text = new JLabel("Welcome To ATM ");
        text.setFont(new Font("Osward",Font.BOLD,36));
        text.setBounds(250,70,500,100);
        add(text);
        
        JLabel cardno = new JLabel("CARD NO ");
        cardno.setFont(new Font("raleway",Font.BOLD,25));
        cardno.setBounds(250,150,130,100);
        add(cardno);
        
        JLabel pin = new JLabel("PIN NO ");
        pin.setFont(new Font("raleway",Font.BOLD,25));
        pin.setBounds(250,200,500,100);
        add(pin);
        
        
        cardTextField = new JTextField();
        cardTextField.setBounds(400,180,200,30);
        cardTextField.setFont(new Font("arial",Font.BOLD,13));
        add(cardTextField);
        
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(400,230,100,30);
        pinTextField.setFont(new Font("arial",Font.BOLD,13));
         //pinTextField.setBackground(Color.black);
        add(pinTextField);
        
        login = new JButton("LOG IN");
        login.setBounds(400,270,70,40);
        login.setBackground(Color.white);
        login.setForeground(Color.black );
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.white);
        clear.setForeground(Color.red);
        clear.setBounds(530,270,70,40);
        clear.addActionListener(this);
        add(clear );
        
         
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.white);
        signup.setForeground(Color.green );
        signup.setBounds(400,320,200,40);
        signup.addActionListener(this);
        add(signup );
        
        // SET FRAME BACKGROUND 
        getContentPane().setBackground(Color.white);
        
        setSize(800,480);
        setVisible(true);
        setLocation(300,200);
    } 
    public void actionPerformed(ActionEvent ae ){
        if (ae.getSource()==clear){ 
            cardTextField.setText("");
            pinTextField.setText("");
           
           
        }else if (ae.getSource()==login){
            conn c = new conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query ="select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"' ";
            try {
               ResultSet rs = c.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                
               
               }
               
            
            }catch (Exception e){
                System.out.println(e);
            
            }
        
        
        }else if (ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        
    }

    
    public static void main (String args[]){
        new Login();
    
    
    
    }
} 
