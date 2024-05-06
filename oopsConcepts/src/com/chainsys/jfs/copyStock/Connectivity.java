package com.chainsys.jfs.copyStock;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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

    public static void checkStockAgeAndAvailability(List<StockManagementInformation> items) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Connectivity.getConnection();
            String query = "SELECT item_name, start_date FROM stock";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No items available!");
            } else {
                while (resultSet.next()) {
                    String itemName = resultSet.getString("item_name");
                    Date startDate = resultSet.getDate("start_date");
                    LocalDate localStartDate = startDate.toLocalDate();
                    LocalDate currentDate = LocalDate.now();
                    long daysInStock = ChronoUnit.DAYS.between(localStartDate, currentDate);
                    System.out.println("Item: " + itemName + " has been in stock for " + daysInStock + " days.");

                    Period period = Period.between(localStartDate, currentDate);
                    if (daysInStock > 365 && daysInStock < 700) {
                        System.out.println("This item was manufactured more than 1 year ago. Clear this stock by giving offers.");
                        System.out.println("This item may be expiring soon. Restock this item with new item");
                    } else if (daysInStock > 200 && daysInStock < 364) {
                        System.out.println("This item is quite old add Discount for this item.");
                    } else if (daysInStock > 50 && daysInStock < 199) {
                        System.out.println("This item is relatively new.'NEW ARRIVAL'");
                    } else if (daysInStock > 0 && daysInStock < 49) {
                        System.out.println("This item is new.'FRESH ITEM' ");
                    } else {
                        System.out.println("This item is very old.'CLEAR THIS ITEM' ");
                    }

                    for (StockManagementInformation item : items) {
                        if (itemName.equals(item.getItemName())) {
                            item.Display();
                        }
                    }
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    public static boolean adminLogin(String name, String passWord) throws SQLException {
    	Connection connection = Connectivity.getConnection();
    	String adminName = null;
    	String password = null;
    	String checkAdmin = "SELECT * from login where name =? and password =? ";
    	PreparedStatement statement = connection.prepareStatement(checkAdmin);
    	statement.setString(1, name);
    	statement.setString(2, passWord);
    	ResultSet resultSet = statement.executeQuery();
    	 if(resultSet.next()) {
    		 
    	        System.out.println("Login successful");
    	        
    		  
    		  return true;
    	    } else {
    	        System.out.println("Incorrect username or password. Please retry...");
    	        return false;
    	        
    	    }	
    	
    	
    }
    public static void addAdmin(String name, String passWord) throws SQLException{
    	Connection connection = Connectivity.getConnection();
    	String checkAdmin = "insert into login values (?,?)";
    	PreparedStatement statement = connection.prepareStatement(checkAdmin);
    	statement.setString(1, name);
    	statement.setString(2, passWord);
    	int rows= statement.executeUpdate();
    	System.out.println("added : "+rows);
    	
    }
}
