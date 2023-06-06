package com.sample2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bike {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); 		

			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");		


			PreparedStatement p=connection.prepareStatement("insert into ipl(TEAM_NAME,POINTS,NO_MACTH,LOSE,WIN) values(?,?,?,?,?)");
			System.out.println("Enter team name");
			p.setString(1, sc.next());
			System.out.println("Enter Points");
			p.setInt(2, sc.nextInt());
			System.out.println("Enter no of matches");
			p.setInt(3, sc.nextInt());
			System.out.println("Enter how many matches lose");
			p.setInt(4, sc.nextInt());
			System.out.println("Enter how many matches won");
			p.setInt(5, sc.nextInt());
			p.execute();

			System.out.println("Data inserted");

			connection.close();		

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
