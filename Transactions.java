package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,cash,pin,statement,exit,enquiry;
     String pinnumber;       
            
    Transactions(String pinnumber){
        this.pinnumber =pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmscreen.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("***Please select your Transaction***  ");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(200,300,700,35);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(153,415,160,35);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cash = new JButton("Fast Cash");
        cash.setBounds(153,450,160,35);
        cash.addActionListener(this);
        image.add(cash);
        
        pin = new JButton("Pin Change");
        pin.setBounds(153,485,160,35);
        pin.addActionListener(this);
        image.add(pin);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(360,415,160,35);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        statement = new JButton("Mini Statement");
        statement.setBounds(360,450,160,35);
        statement.addActionListener(this);
        image.add(statement);
        
        enquiry = new JButton("Balance Enquiry");
        enquiry.setBounds(360,485,160,35);
        enquiry.addActionListener(this);
        image.add(enquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(360,520,160,35);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
        
    
    }
    public  void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        
        }else if (ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        
        }
    
    }
        
    public static void main(String args[]){
        new Transactions("");
     
    }



}
