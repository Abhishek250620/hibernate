package com.sample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) {
		try {

			// 1. Load and register drive
			Class.forName("com.mysql.cj.jdbc.Driver"); 		

			// 2.Establish the connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");		

			// 3. Create the statement
			Statement stmt=connection.createStatement();		

			// 4. Execute the statement
			stmt.execute("insert into demo values(35,'Smith')");		
			
			//5. Close the connection
			connection.close();		

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
