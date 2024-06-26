package com.chainsys.jfs.stockconnection;

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
    public static void stockExpiry(String item) throws SQLException {
        Date date;
        Connection connection = Connectivity.getConnection();
        String expiryCheck = "SELECT start_date FROM studentdata.stock WHERE item_name=?";
        PreparedStatement statement = connection.prepareStatement(expiryCheck);
        statement.setString(1, item);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            date = resultSet.getDate("start_date");
            LocalDate startDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            LocalDate currentDate = LocalDate.now();
            long daysInStock = ChronoUnit.DAYS.between(startDate, currentDate);
            System.out.println("Item: " + item + " has been in stock for " + daysInStock + " days.");

            Period period = Period.between(startDate, currentDate);
            if (period.getYears() > 1 && period.getYears() == 2) {
                System.out.println("This item was manufactured more than 1 year ago. Clear this stock by giving offers.");
                System.out.println("This item may be expiring soon. Restock this item with new item");
            } else if (period.getMonths() >= 5 && period.getMonths() < 11) {
                System.out.println("This item is quite old you need to re stock this item.");
            } else if (period.getMonths() < 5 && period.getMonths() >= 2) {
                System.out.println("This item is relatively new.'NEW ARRIVAL'");
            } else if (period.getDays() < 31) {
                System.out.println("This item is new.'FRESH ITEM' ");
            } else {
                System.out.println("This item is very old.'CLEAR THIS ITEM' ");
            }
        } else {
            System.out.println("No record found for item: " + item);
        }

        // Don't forget to close your resources (connection, statement, resultSet) here.
    }
}
