package database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class SignUp {
	public static void main(String[] args) {
		SignUps("user", "pass","grgdf","asdg","asdf");
	}

	public static void SignUps( String name, String surname,String userName,String password,String email) {
			try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root", "Serdar0520");
	
			PreparedStatement statement = (PreparedStatement) myConn.prepareStatement("INSERT INTO userinfo(Name,Surname,userName,password,email)VALUES(?,?,?,?,?)");
			statement.setString(1, name);
			statement.setString(2, surname);
                        statement.setString(3, userName);
                        statement.setString(4, password);
                        statement.setString(5, email);
			
			statement.executeUpdate();
			statement.close();
			myConn.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}

    public void SignUps(String textEntryName, String textEntrySurname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
