package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DataBase
{
    private static ArrayList<Integer> list;
    private static ArrayList<Integer> listNew;
    //will be BookName(1,23,52345,,425611)
    public static String BookName(int a)
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
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo where idbookinfo = "+a+";");
            
            while (myRs.next())
            {
                
                return myRs.getString("bookName");
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return null;
    }
    
    public static String  Author(int b)
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo where idBookInfo = "+b+";");
            
            while (myRs.next())
            {
                
                return myRs.getString("Author");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return null;
    }
    public static String  Statement(int c)
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo where idBookInfo = "+c+";");
            
            while (myRs.next())
            {
                
                return myRs.getString("Statement");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return null;
    }
    public static String genre(int c)
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo where idBookInfo = "+c+";");
            
            while (myRs.next())
            {
                
                return myRs.getString("genre");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return null;
    }
    
    public static int rate(int c)
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo where idBookInfo = " + c + ";");
            
            while (myRs.next())
            {
                
                return myRs.getInt("rate");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return 0;
    }
    
    public static int getPicture(int f)
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo where idBookInfo = " + f + ";");
            
            while (myRs.next())
            {
                
                return myRs.getInt("Picture");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return 0;
    }
    
    
    
    public static ArrayList<Integer> getAllGenre(String s)
    {
        list =  new ArrayList<Integer>();
        
        for(int i = 1 ; i < last() ; i++)
        {
            if( genre(i).equalsIgnoreCase(s))
            {
                list.add(i);
            }
        }
        return list;
    }
    
    public static String textToID(String x)
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo where bookName = " + x + ";");
            
            while (myRs.next())
            {
                
                return myRs.getString("idbookinfo");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return null;
        
    }
    
    public static int last()
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo ORDER BY idbookinfo DESC LIMIT 1;");
            
            while (myRs.next())
            {
                
                return myRs.getInt("idbookinfo");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return 0;
        
    }
    public static int getNew(int a)
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
            
            ResultSet myRs = myStmt.executeQuery("select * from bookinfo where idbookinfo = "+a+";");
            
            while (myRs.next())
            {
                
                return myRs.getInt("GenreID");
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return 0;
    }
    
    public static ArrayList<Integer> getNews()
    {
        list =  new ArrayList<Integer>();
        
        for(int i = 1 ; i < last() ; i++)
        {
            if( getNew(i) == 1)
            {
                list.add(i);
            }
        }
        return list;
    }
            
    
 public static String readLaters(int x)
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from readlater where idreadLater = " + x + ";");
            
            while (myRs.next())
            {
                
                return myRs.getString("userName");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return null;
        
    }
 public static int getLastLater()
    {
        try
        {
            
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                    "Serdar0520");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from readlater ORDER BY idreadLater DESC LIMIT 1;");
            
            while (myRs.next())
            {
                
                return myRs.getInt("idreadLater");
                
            }
            
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            
        }
        return 0;
        
    }
 
 public static ArrayList<Integer> newBooks(String s)
    {
  listNew =  new ArrayList<Integer>();
        
        for(int i = 1 ; i < 18 ; i++)
        {
            if( genre(i).equalsIgnoreCase(s))
            {
             listNew.add(i);
            }
        }
        return listNew;
    }
    public static void main(String[]args){
        System.out.println(getLink(3));
    }

    
public static String  getLink(int b)
{
    try
    {
        
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root",
                "Serdar0520");
        
        Statement myStmt = myConn.createStatement();
        
        ResultSet myRs = myStmt.executeQuery("select * from bookinfo where idBookInfo = "+b+";");
        
        while (myRs.next())
        {
            
            return myRs.getString("Link");
            
        }
        
    }
    catch (Exception exc)
    {
        exc.printStackTrace();
        
    }
    return null;
}

}
