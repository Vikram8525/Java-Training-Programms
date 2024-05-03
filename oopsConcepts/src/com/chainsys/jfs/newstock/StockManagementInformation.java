package com.chainsys.jfs.newstock;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.chainsys.jfs.pojo.ValidationClass;

public class StockManagementInformation {
    private String itemName;
    private int itemId;
    private int itemQuantity;
    private java.util.Date startDate;

    public StockManagementInformation(String itemName, Connection connection) throws SQLException, ParseException {
        this.itemName = itemName;
        ValidationClass iv = new ValidationClass();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the item: ");
        this.itemId = iv.validateInteger();
        System.out.print("Enter the number of items available in the store: ");
        this.itemQuantity = iv.validateInteger();

        this.startDate = validateDateString("Enter the last date that the stock has been added (YYYY-MM-DD): ");
        Connectivity.addStock(itemName, itemQuantity,startDate );
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public ItemStatus getItemStatus(Period period) {
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        if (years > 1 && years <= 2) {
            return ItemStatus.OFFER_CLEAR;
        } else if (months >= 5 && months < 11) {
            return ItemStatus.RESTOCK;
        } else if (months < 5 && months >= 2) {
            return ItemStatus.NEW_ARRIVAL;
        } else if (days < 25) {
            return ItemStatus.FRESH_ITEM;
        } else {
            return ItemStatus.CLEAR_ITEM;
        }
    }

    public void Display() {
        if (itemQuantity < 50) {
            System.out.println("The stock will be depleted.");
            System.out.println("The stock must be added.");
        } else {
            System.out.println("There is enough amount of stock.");
        }
    }
    public Period calculatePeriodBetween(Date startDate2, LocalDate endDate) {
        return Period.between(startDate2, endDate);
    }
    public static java.util.Date validateDateString(String message) throws ParseException {
    	Scanner sc=new Scanner(System.in);
    	String date="19/05/2001";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				/*
				 * date = LocalDate.parse(input, dateFormatter);
				 * System.out.println("You entered: " + date); isValidInput = true;
				 */
          java.util.Date date1 = dateFormat.parse(dateFormat.format(date));
            	return date1;
    }
}
