package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

public class readLater {
	private static ArrayList<Integer> readLater;
	private static DataBase db;
        
        public static void readBookLater(String name,int bookID)
        {
            try
            {
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "Serdar0520");
                
                PreparedStatement statement = (PreparedStatement) myConn.prepareStatement("INSERT INTO readlater(userName,bookID)VALUES(?,?)");
                statement.setString(1, name);
                statement.setInt(2, bookID);
                
                statement.executeUpdate();
                statement.close();
                myConn.close();
            }
            catch (Exception exc)
            {
                exc.printStackTrace();
            }
            
	}
	public void readLaterRemove(String name,int bookID){
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "Serdar0520");

			PreparedStatement statement = (PreparedStatement) myConn.prepareStatement("INSERT INTO readlater(userName,bookID)VALUES(?,?)");
			statement.setString(1, name);
			statement.setInt(2, bookID);
		
			statement.executeUpdate();
			statement.close();
			myConn.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	}
	public static int getBookID(int a)
    {
        try
        {
            // 1.get a connection to database
            // 2.create a statement
            // 3.execute sql query
            // 4.process the result
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false"	, "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from readlater where idreadLater = "+a+";");
            
            while (myRs.next())
            {
                
                return myRs.getInt("bookID");
            }
            myStmt.close();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return 0;
    }
	
	public static ArrayList<Integer> futureReading(String s)
    {
		readLater =  new ArrayList<Integer>();
        
        for(int i = 1 ; i < db.getLastLater() + 1 ; i++)
        {
            if( DataBase.readLaters(i).equals(s))
            {
            	readLater.add(getBookID(i));
            }
        }
        
        return readLater;
    }
	public static void main(String []args){
		System.out.println(futureReading("serdar"));
		
	}
	
}
