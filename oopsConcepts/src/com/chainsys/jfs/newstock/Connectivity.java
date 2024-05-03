package com.chainsys.jfs.newstock;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Connectivity {
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "Vikram@8525");
		return connection ;
	}
      public static void addStock(String itemName,int itemQuantity, java.util.Date startDate) throws SQLException {
    	  Connection connection =Connectivity.getConnection();
    	  String addDetails ="insert into stock values (1,?,?,?)";
    	  PreparedStatement statement= connection.prepareStatement(addDetails);
    	  statement.setString(1, itemName);
    	  statement.setInt(2, itemQuantity);
    	 
    	  statement.setDate(3, new java.sql.Date(startDate.getTime()));
    	  int executeUpdate = statement.executeUpdate();
    	  System.out.println(executeUpdate);
      }
}

