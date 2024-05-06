package com.chainsys.jfs.copyStock;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chainsys.jfs.stockconnection.Connectivity;
import com.chainsys.jfs.stockconnection.StockManagementInformation;

public class StockManagementMain implements StockManagementInterface {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\t\t" + " .....WELCOME TO STOCK MANAGEMENT SYSTEM.....");
            System.out.println("Are you an Employee or a Customer?");
            System.out.println("For Employee press 1.");
            System.out.println("For Customer press 2.");
            System.out.println("To exit press any other key.");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    employeeMenu();
                    break;
                case "2":
                    customerMenu();
                    break;
                default:
                    System.out.println("Exiting Stock Management System.");
                    System.exit(0);
            }
        }
    }

    private static void employeeMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Employee Login");
        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        boolean loggedIn = Connectivity.adminLogin(username, password);

        while (!loggedIn) {
            System.out.println("Incorrect username or password. Please retry...");
            System.out.println("Enter Username:");
            username = scanner.nextLine();
            System.out.println("Enter Password:");
            password = scanner.nextLine();
            loggedIn = Connectivity.adminLogin(username, password);
        }

        List<StockManagementInformation> items = new ArrayList<>();

        while (true) {
            System.out.println("\nStock Management System");
            System.out.println("1. View Stock Details");
            System.out.println("2. Add Stock");
            System.out.println("3. Delete Stock");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Connectivity.displayStocks();
                    break;
                case 2:
                	
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
                case 3:
                    deleteStock();
                    break;
                case 4:
                    System.out.println("Exiting Stock Management System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }


    private static void deleteStock() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter item name to delete: ");
//        String itemName = scanner.nextLine();
//        Connectivity.deleteStock(itemName);
//        System.out.println("Item deleted successfully!");
    }

    private static void customerMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        List<StockManagementInformation> items = new ArrayList<>();
        
        while (true) {
            System.out.println("\nCustomer Menu");
            System.out.println("1. Check Stock Details");
            System.out.println("2. Check Stock Freshness");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Connectivity.displayStocks();
                    break;
                case 2:
                    Connectivity.checkStockAgeAndAvailability(items);
                    break;
                case 3:
                    System.out.println("Exiting Customer Menu.");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 3.");
            }
        }
    }

    @Override
    public void displayItemDetails(List<StockManagementInformation> items) {
        
    }

    @Override
    public void checkStockAgeInDays(List<StockManagementInformation> items) {
    
    }

    @Override
    public void checkStockAvailability(List<StockManagementInformation> items) {
        
    }
}
