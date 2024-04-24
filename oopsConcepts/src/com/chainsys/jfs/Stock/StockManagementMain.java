package com.chainsys.jfs.Stock;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockManagementMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StockManagementPojo> products = new ArrayList<>();
        StockManagementInformation smi = new StockManagementInformation();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nStock Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Display Product Details");
            System.out.println("3. Check Stock Availability");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    StockManagementPojo product = new StockManagementPojo();
                    smi.addProductDetails(product);
                    products.add(product);
                    break;
                case 2:
                    smi.displayProductDetails(products);
                    break;
                case 3:
                    smi.checkStockAvailability(products);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Stock Management System.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
        scanner.close();
    }
}
