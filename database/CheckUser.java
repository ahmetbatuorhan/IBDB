
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckUser {
    public static void main(String[]args){
        System.out.println(passCheck("user1","pass1"));
    }
    
    public static String findPassword(String g)
    {
        String returnState = "WRONGPASSALERT12341234";
        try 
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery(" select * from userinfo where userName='" + g + "' ");
            
            while (myRs.next())
            {
                return myRs.getString("password");   
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            return returnState = "WRONGPASSALERT12341234";
        }
        
        return returnState = "WRONGPASSALERT12341234";
        
    }

	public static boolean passCheck(String name, String password) 
        {
            // username
            String pass = findPassword( name);
            if (pass.equals("WRONGPASSALERT12341234"))
            {
                return false;
            }
            else if (pass.equals(password))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
}

	
