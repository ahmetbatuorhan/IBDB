package database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class Rate {
	public static void RatePlus( int bookID) {
		try {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root", "Serdar0520");

		PreparedStatement statement = (PreparedStatement) myConn.prepareStatement("UPDATE bookinfo SET Rate = Rate + 1 WHERE idbookinfo = "+bookID+"");
		
		statement.executeUpdate();
		statement.close();
		myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	public static void RateMinus( int bookID) {
		try {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false", "root", "Serdar0520");

		PreparedStatement statement = (PreparedStatement) myConn.prepareStatement("UPDATE bookinfo SET Rate = Rate - 1 WHERE idbookinfo = "+bookID+"");
		
		statement.executeUpdate();
		statement.close();
		myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
}
