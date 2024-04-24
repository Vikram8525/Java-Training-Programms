package com.chainsys.jfs.Stock;

import com.chainsys.jfs.pojo.ValidationClass;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StockManagementInformation {

    public void addProductDetails(StockManagementPojo product) {
        Scanner scanner = new Scanner(System.in);
        ValidationClass iv = new ValidationClass();

        System.out.print("Enter item name: ");
        product.setItemName(iv.validateNameString());
        System.out.print("Enter the ID of the item: ");
        product.setItemId(iv.validateInteger());
        System.out.print("Enter the number of items available in the store: ");
        product.setItemQuantity(iv.validateInteger());
        System.out.print("Enter the date the item was last added (YYYY-MM-DD): ");
        product.setDate(validateDateString());
    }

    public void displayProductDetails(List<StockManagementPojo> products) {
        if (products.isEmpty()) {
            System.out.println("\nNo products available!");
        } else {
            System.out.println("\nProduct Details:");
            for (StockManagementPojo product : products) {
                System.out.println(product);
                System.out.println("-------------------------------------");
            }
        }
    }

    public void checkStockAvailability(List<StockManagementPojo> products) {
        if (products.isEmpty()) {
            System.out.println("\nNo products available!");
        } else {
            System.out.println("\nStock Availability:");
            for (StockManagementPojo product : products) {
                System.out.println("Product Name: " + product.getItemName());
                if (product.getItemQuantity() > 0) {
                    System.out.println("Available in stock.");
                } else {
                    System.out.println("Out of stock.");
                }
                System.out.println("-------------------------------------");
            }
        }
    }

    public LocalDate validateDateString() {
        boolean isValidInput = false;
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;

        while (!isValidInput) {
            String input = scanner.nextLine();

            try {
                date = LocalDate.parse(input);
                System.out.println("You entered: " + date);
                isValidInput = true;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            }
        }
        return date;
    }
}
