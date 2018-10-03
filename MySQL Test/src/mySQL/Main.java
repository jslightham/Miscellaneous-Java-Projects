package mySQL;

import java.sql.*;

public class Main {
	public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM testtable");
		
		while(resultSet.next()){
			System.out.println(resultSet.getInt(1) + "  " + resultSet.getInt(2)+ "  " + resultSet.getInt(3) + "  " + resultSet.getInt(4));  
			
		}
		
	} 	
	catch (Exception e) {
	System.out.println(e);
	}
	}
}
