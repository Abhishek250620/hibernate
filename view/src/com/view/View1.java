package com.view;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employe","root","root");
			CallableStatement cs=conn.prepareCall("select * from employe.emp");
			ResultSet r=cs.executeQuery();
			while(r.next()) {
			System.out.println(r.getInt(1)+"\t"+r.getString(2)+"\t"+r.getDouble(3)+"\t"+r.getInt(4)+"\t"+r.getString(5));
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
