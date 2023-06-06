package com.hotel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo extends Hotel1 {
	
	static void createTable() throws ClassNotFoundException, SQLException {
		conn();
		ps=connection.prepareStatement("CREATE TABLE `hotels`.`demo1`(`id` INT NOT NULL,  PRIMARY KEY (`id`));");
		ps.execute();
		connection.close();
	}

	public static void main(String[] args) {
		try {
			createTable();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
