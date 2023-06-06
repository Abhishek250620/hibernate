package com.employe;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Emp {
	public static void main(String[] args) {


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/view","root","root");
			CallableStatement callableStatement=connection.prepareCall("select * from view.emp");
			ResultSet rs=callableStatement.executeQuery();
//			System.out.printf("%10s%20s%20s","ID","NAME","SALARY","DNO","LOC");
//			System.out.println();
//			System.err.println("----------------------------------------------------------------------------------------------");
//			while(rs.next()) {
//				System.out.printf("%10s%20s%20s%20s%20s",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5));
//				System.out.println();
//				System.out.println("----------------------------------------------------------------------------------------------");
//			}
//			callableStatement=connection.prepareCall("call getByName('Smith')");
//			rs=callableStatement.executeQuery();
			System.out.printf("%10s%20s%20s",rs.getInt(1),rs.getString(2),rs.getDouble(3));
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
