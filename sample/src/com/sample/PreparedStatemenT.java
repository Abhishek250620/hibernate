package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatemenT {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");
			PreparedStatement statement=connection.prepareCall("select datediff(end,Start) from datee");
			ResultSet s=statement.executeQuery();
			while(s.next()) {
				System.out.println(s.getInt(1));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
