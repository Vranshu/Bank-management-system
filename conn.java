package banking.management.system;

import java.sql.*;


public class conn {
    
    Connection c ;
    Statement s ;
    public conn(){
        try {
          
           Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","@Vranda4a");
           
             s = c.createStatement();
          
        
        }catch (Exception e){
            System.out.println(e);
        
        }
    
    }

}