package com.sample;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertingFile {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","root");
			PreparedStatement ps=connection.prepareCall("insert into files values(?,?)");
			FileReader fr=new FileReader("C:\\Users\\Abhishek M R\\Documents\\hello.txt");
			ps.setInt(1, 3);
			ps.setClob(2, fr);
			ps.execute();
			System.out.println("Data inserted sucessfully");
			ps=connection.prepareCall("select * from files");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				Reader r=rs.getCharacterStream(2);
				int ch=r.read();
				while(ch!=-1) {
					System.out.print((char)ch);
					ch=r.read();
				}
				System.out.println();
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
