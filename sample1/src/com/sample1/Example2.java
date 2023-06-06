package com.sample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


//--------------PreaparedStatement---------------------
//    Statement(I)--> Static Insertion
//    PreparedStatement(I)--> Dynamic Insertion

public class Example2 {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		try {

			// 1. Load and register drive
			Class.forName("com.mysql.cj.jdbc.Driver"); 		

			// 2.Establish the connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");		

			// 3. Create the statement
			// 4. Execute the statement0	
//			PreparedStatement p=connection.prepareStatement("alter table bike add speed double");  adding column to exiting table
//			p.setString(1, sc.next());
//			p.setDouble(2, sc.nextDouble());
//			PreparedStatement p1=connection.prepareStatement("update bike set speed='7000' where id=3");  //Updating column
//			PreparedStatement p=connection.prepareStatement("alter table bike drop column rating");
			PreparedStatement p=connection.prepareStatement("select * from bike");
//			p1.execute();
			ResultSet r= p.executeQuery();
//			System.out.println("ID\tBRAND\tCOST\tSPEED");
			System.err.printf("%10s%20s%20s","Id","Name","Cost");
			System.out.println();
			System.err.println("--------------------------------------------------------");
			while(r.next()) {
				Thread.sleep(1000);
				System.out.printf("%10s%20s%20s",r.getInt(1),r.getString(2),r.getDouble(3));
				System.out.println();
				System.out.println("--------------------------------------------------------");
//				System.out.print(r.getInt(1)+"\t");
//				System.out.print(r.getString(2)+"\t");
//				System.out.print(r.getDouble(3)+"\t");
//				System.out.print(r.getDouble(4)+"\t");
//				System.out.println();
			}
			
//			System.out.println("Data inserted");
			//5. Close the connection
			connection.close();		

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
