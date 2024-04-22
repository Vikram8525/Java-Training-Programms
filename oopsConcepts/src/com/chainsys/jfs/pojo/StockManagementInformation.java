package com.chainsys.jfs.pojo;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StockManagementInformation { 
	
	public void StockManagement() {
		
		StockManagementPojo sp = new StockManagementPojo();
		ValidationClass iv = new ValidationClass();
		System.out.print("enter item name :");
		sp.setItemName(iv.validateNameString());
		System.out.print("enter the Id of the item :");
		sp.setItemId(iv.validateInteger());
		System.out.print("enter the Number of items available in the store :");
		sp.setItemQuantity(iv.validateInteger());
		
		int item = sp.getItemQuantity();
		
		if (item <50)
		{
			System.out.println(" The stock will be depleted. ");
		}
		else {
			System.out.println(" There is enough amount of stock. ");
		}
		
		
	}

	 public static LocalDate validateDateString(String message) {
	        boolean isValidInput = false;
	        Scanner scanner = new Scanner(System.in);
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = null;

	        while (!isValidInput) {
	            System.out.print(message);
	            String input = scanner.nextLine();

	            try {
	                date = LocalDate.parse(input, dateFormatter);
	                System.out.println("You entered: " + date);
	                isValidInput = true;
	            } catch (Exception e) {
	                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
	            }
	        }
	        return date;
	    }

	    public static Period calculatePeriodBetween(LocalDate startDate, LocalDate endDate) {
	        return Period.between(startDate, endDate);
	    }
	}


