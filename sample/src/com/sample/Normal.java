package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Normal {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");
			Statement statement=connection.createStatement();
			statement.execute("CREATE TABLE `employe`.`demo` (\r\n"
					+ "  `idnew_table` INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (`idnew_table`));");
			System.out.println("Data stored");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
