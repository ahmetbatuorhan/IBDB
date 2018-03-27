package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Search {
	static int foo;
	public static void main(String[] args) {
		DataBase db = new DataBase();
		int a = result(Search("hunger"));
		
		System.out.println(db.Author(a));
		
	}
	
	public static String Search(String g){
		try {
			// 1.get a connection to database
			// 2.create a statement
			// 3.execute sql query
			// 4.process the result

			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root",
					"Serdar0520");

			Statement myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery(" select * from bookinfo where bookName='" +g+ "' ");

			while (myRs.next()) {
				
				return myRs.getString("idbookinfo");

			}

		} catch (Exception exc) {
			exc.printStackTrace();

		}
		
		return null;
	}
	
	public static int result(String g){
		
		int foo  =  Integer.parseInt(g);
		
		return foo;
		
		
	}
	
}
