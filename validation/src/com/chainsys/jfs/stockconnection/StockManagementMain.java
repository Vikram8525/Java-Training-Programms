package com.chainsys.jfs.stockconnection;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockManagementMain implements StockManagementInterface {

    public static void main(String[] args) throws SQLException {
        StockManagementMain stockManagementMain = new StockManagementMain(); // Create an instance
        Scanner scanner = new Scanner(System.in);
        List<StockManagementInformation> items = new ArrayList<>();
        ValidationClass v1 = new ValidationClass();

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
            System.out.println("Please Sign Up");
            while (true) {
                System.out.println("Enter UserName:");
                userName = scanner.nextLine();
                if (!v1.validateString(userName)) {
                    System.out.println("Invalid Username!");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.println("Enter Password:");
                passWord = scanner.nextLine();
                if (!v1.isSpecialChar(passWord)) {
                    System.out.println("Invalid Password!");
                } else {
                    break;
                }
            }
            System.out.println("Signed Up Successfully!");
            System.out.println("Please enter your credentials again for verification:");
            while (true) {
                System.out.println("Enter UserName:");
                String inputName = scanner.nextLine();
                System.out.println("Enter Password:");
                String inputPass = scanner.nextLine();
                if (inputName.equals(userName) && inputPass.equals(passWord)) {
                    System.out.println("Verification successful!");
                    break;
                } else {
                    System.out.println("Invalid username or password. Try again.");
                }
            }
        } else if (choose.equals("yes")) {
            String defaultUserName = "root";
            String defaultPassword = "Root@123";

            System.out.println("Please Log In!");
            while (true) {
                System.out.println("Enter UserName:");
                name = scanner.nextLine();
                if (!v1.validateString(name)) {
                    System.out.println("Invalid Username!");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.println("Enter Password:");
                pass = scanner.nextLine();
                if (!v1.isSpecialChar(pass)) {
                    System.out.println("Invalid Password!");
                } else {
                    System.out.println("You have logged in successfully.");
                    break;
                }
            }

            if (!name.equals(defaultUserName) || !pass.equals(defaultPassword)) {
                System.out.println("Invalid username or password.");
                return;
            }
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
                        // Convert LocalDate to java.util.Date
                        LocalDate startDate = item.getStartDate();
                        java.util.Date utilStartDate = java.sql.Date.valueOf(startDate);

                        // Call addStock with the converted date
                        Connectivity.addStock( 0, itemName, item.getItemQuantity(), utilStartDate);
                        System.out.println("Item added successfully!");
                    } catch (SQLException e) {
                        System.out.println("Failed to add item to database: " + e.getMessage());
                    }
                    break;
                case 2:
                	Connectivity.displayStocks();
                    //stockManagementMain.displayItemDetails(items); // Call non-static method using the instance
                    break;
                case 3:
                	//Connectivity.stockExpiry(items);
                    stockManagementMain.checkStockAgeInDays(items); // Call non-static method using the instance
                    break;
                case 4:
                    stockManagementMain.checkStockAvailability(items); // Call non-static method using the instance
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Stock Management System.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
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
