package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementMethod {
	static Scanner sc=new Scanner(System.in);
	static void delete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");
			PreparedStatement ps=connection.prepareCall("delete from bike where Id=?");
			System.out.println("Enter the bike id which you wnt to delete");
			ps.setInt(1, sc.nextInt());
			ps.execute();
			System.out.println("Data deleted sucessfully");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		delete();
	}
}
