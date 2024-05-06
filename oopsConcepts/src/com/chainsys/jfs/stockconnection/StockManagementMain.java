package com.chainsys.jfs.stockconnection;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockManagementMain implements StockManagementInterface {

    public static void main(String[] args) throws SQLException {
        StockManagementMain stockManagementMain = new StockManagementMain(); 
        Scanner scanner = new Scanner(System.in);
        List<StockManagementInformation> items = new ArrayList<>();
        ValidationClass v1 = new ValidationClass();
        
        while(true) {
        System.out.println("\t\t"+" .....WELCOME TO STOCK MANAGEMENT SYSTEM.....");
        System.out.println("Are you an Employee or an Customer?..");
        System.out.println("For Employee press 1..");
        System.out.println("For Customer press 2..");
        
        

        String userName = "";
        String passWord = "";
        String name = "";
        String pass = "";

        System.out.println("Do you have an Account? (Yes or No)");
        String choose = scanner.nextLine().toLowerCase();
        while (!choose.equals("yes") && !choose.equals("no")) {
            System.out.println("Please Re-enter Valid Input: (yes or no)");
            choose = scanner.nextLine().toLowerCase();
        }
         
      
        	
        if (choose.equals("no")) {
            System.out.println("Admin Signup..");
            
            Scanner sc = new Scanner(System.in);
        	System.out.println("Enter Username ");
        	userName = sc.next();
        	System.out.println("Enter Password ");
        	passWord = sc.next(); 
        	Connectivity.addAdmin(userName, passWord);
        	
        		System.out.println("Enter Username ");
            	name = sc.next();
            	System.out.println("Enter Password ");
            	pass = sc.next(); 
        		
        	Connectivity.adminLogin(userName, passWord);
        	
        
        	
        	}
        else if (choose.equals("yes")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter username ");
            String username = sc.next();
            System.out.println("enter password ");
            String password = sc.next();
            
            boolean loggedIn = Connectivity.adminLogin(username, password);
            
            while (!loggedIn) {
                
                System.out.println("enter username ");
                username = sc.next();
                System.out.println("enter password ");
                password = sc.next();
                loggedIn = Connectivity.adminLogin(username, password);
            }

            boolean exit = false;
            while (!exit) {
                System.out.println("\nStock Management System");
                System.out.println("1. Add Item");
                System.out.println("2. Display Item Details");
                System.out.println("3. Check Stock Age in Days");
                System.out.println("4. Check Stock Availability");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                           
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        StockManagementInformation item = new StockManagementInformation(itemName);
                        items.add(item);
                        try {
                            LocalDate startDate = item.getStartDate();
                            java.util.Date utilStartDate = java.sql.Date.valueOf(startDate);
                            Connectivity.addStock( 0, itemName, item.getItemQuantity(), utilStartDate);
                            System.out.println("Item added successfully!");
                        } catch (SQLException e) {
                            System.out.println("Failed to add item to database: " + e.getMessage());
                        }
                        break;
                    case 2:
                        Connectivity.displayStocks();
                        //stockManagementMain.displayItemDetails(items);
                        break;
                    case 3:
                        Connectivity.checkStockAgeAndAvailability(items);
                        //stockManagementMain.checkStockAgeInDays(items); 
                        break;
                    case 4:
                        stockManagementMain.checkStockAvailability(items); 
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting Stock Management System.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            }
        }
           
        }
        
    }

    @Override
    public void displayItemDetails(List<StockManagementInformation> items) {
        if (items.isEmpty()) {
            System.out.println("No items available!");
        } else {
            System.out.println("\nItem Details:");
            for (StockManagementInformation item : items) {
                System.out.println("Item Name: " + item.getItemName());
                System.out.println("Start Date: " + item.getStartDate());
                System.out.println("-------------------------------------");
            }
        }
    }

    @Override
    public void checkStockAgeInDays(List<StockManagementInformation> items) {
        if (items.isEmpty()) {
            System.out.println("No items available!");
        } else {
            for (StockManagementInformation item : items) {
                LocalDate startDate = item.getStartDate();
                LocalDate currentDate = LocalDate.now();
                long daysInStock = java.time.temporal.ChronoUnit.DAYS.between(startDate, currentDate);
                System.out.println("Item: " + item.getItemName() + " has been in stock for " + daysInStock + " days.");

                Period period = item.calculatePeriodBetween(startDate, currentDate);
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

                item.Display();
            }
        }
    }

    @Override
    public void checkStockAvailability(List<StockManagementInformation> items) {
        if (items.isEmpty()) {
            System.out.println("No items available!");
        } else {
            boolean isAnyItemAvailable = false;
            for (StockManagementInformation item : items) {
                if (item.getItemQuantity() > 50 ) {
                    isAnyItemAvailable = true;
                    break;
                }
            }
            if (isAnyItemAvailable) {
                System.out.println("This Item is available in stock.");
            } else {
                System.out.println("The stock will be depleted soon. \n you need to add the stock to the store soon...");
            }
        }
    }
}
