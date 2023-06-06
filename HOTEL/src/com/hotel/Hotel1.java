package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Hotel1 {

	static Scanner sc=new Scanner(System.in);
	static Connection connection;
	static PreparedStatement ps;
	public static void conn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","root");
	}

	static void insert() throws ClassNotFoundException, SQLException {
		conn();
		ps=connection.prepareStatement("insert into hotel(NAME,PHNO,LOC,RATINGS,NOBRANCHES) VALUES(?,?,?,?,?)");
		System.out.println("Enter Hotel name");
		ps.setString(1,sc.next());
		System.out.println("Enter Hotel phno");
		ps.setString(2,sc.next());
		System.out.println("Enter Hotel Location");
		ps.setString(3, sc.next());
		System.out.println("Enter Hotel Rating");
		ps.setDouble(4, sc.nextDouble());
		System.out.println("Enter Hotel No of Branches");
		ps.setInt(5,sc.nextInt());
		ps.execute();
		System.out.println("Data inserted");
		connection.close();
	}
	static void delete() throws SQLException, ClassNotFoundException {
		conn();
		ps=connection.prepareStatement("delete from hotel where Id=?");
		System.out.println("Enter the id which you want to delete");
		ps.setInt(1, sc.nextInt());
		ps.execute();
		System.out.println("Data deleted");
		connection.close();
	}
	static void displayTable() throws ClassNotFoundException, SQLException {
		conn();
		ps=connection.prepareStatement("select * from hotel");
		ResultSet rs=ps.executeQuery();
		System.err.println("--------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s%20s%20s%20s%20s%20s","ID","NAME","PHNO","LOC","RATINGS","NO_BRANCHES");
		System.out.println();
		System.err.println("--------------------------------------------------------------------------------------------------------------");
		while(rs.next()) {
			System.out.printf("%5s%20s%20s%20s%20s%20s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------------------------------------");
		}
		connection.close();
	}
	static void update() throws ClassNotFoundException, SQLException {
		conn();
		ps=connection.prepareStatement("update hotel set RATINGS=? where ID=?");
		System.out.println("Enter new Rating");
		ps.setDouble(1, sc.nextDouble());
		System.out.println("Enter which id you should update");
		ps.setInt(2, sc.nextInt());
		ps.execute();
		System.out.println(ps);
		System.out.println("Data updated");
		connection.close();
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		while(true) {
			System.out.println("\n1.insert\n2.Dispaly table\n3.delete row\n4.upadate\n5.exit\nEnter choice");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:insert();
			break;
			case 2:displayTable();
			break;
			case 3:delete();
			break;
			case 4:update();
			break;
			case 5:System.out.println("------------------Program ended---------------");
			System.exit(0);
			default:System.out.println("invalid choice\n");
			}
		}
	}
}
