package com.chainsys.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Connectivity {
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "Vikram@8525");
        return connection;
    }

    public static void addStock(int itemId , String itemName, int itemQuantity, java.util.Date startDate) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = Connectivity.getConnection();
            String addDetails = "insert into stock values (?,?,?,?)";
            statement = connection.prepareStatement(addDetails);
            statement.setInt(1, itemId);
            statement.setString(2, itemName);
            statement.setInt(3, itemQuantity);
            statement.setDate(4, new java.sql.Date(startDate.getTime()));
            int executeUpdate = statement.executeUpdate();
            System.out.println(executeUpdate);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    public static void displayStocks() throws SQLException {
    	Connection connection = Connectivity.getConnection();
    	String displayStock = "SELECT * FROM studentdata.stock";
    	PreparedStatement statement = connection.prepareStatement(displayStock);
    	ResultSet rows = statement.executeQuery();
    	ResultSetMetaData metaData = rows.getMetaData();
    	int count = metaData.getColumnCount();
    	for(int i =1;i<=count;i++) {
    		System.out.print(metaData.getColumnName(i)+" ");
    	}
    	System.out.println();
    	while(rows.next()) {
    		for(int i = 1;i<=count;i++) {
    			System.out.print(rows.getString(i)+ " ");
    		}
    		System.out.println();
    	}
    }
    public void stockExpiry(String item) throws SQLException {
    	Connection connection = Connectivity.getConnection();
    	String expiryCheck = "SELECT start_date FROM studentdata.stock where item_name=?";
    	PreparedStatement statement = connection.prepareStatement(expiryCheck);
    	statement.setString(1, item);
    	// ArrayList<Date> list = new ArrayList<>();
      ResultSet resultSet = statement.executeQuery();
    	 while (resultSet.next()) {
          Date date = resultSet.getDate("start_date");
          //list.add(date);
          
          
    	 }
    	
    }
}
