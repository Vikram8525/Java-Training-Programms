package com.chainsys.jfs.newstock;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.chainsys.jfs.pojo.ValidationClass;

public class StockManagementInformation {
    private String itemName;
    private int itemId;
    private int itemQuantity;
    private LocalDate startDate;

    public StockManagementInformation(String itemName) {
        this.itemName = itemName;
        ValidationClass iv = new ValidationClass();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the item: ");
        this.itemId = iv.validateInteger();
        System.out.print("Enter the number of items available in the store: ");
        this.itemQuantity = iv.validateInteger();

        this.startDate = validateDateString("Enter the last date that the stock has been added (YYYY-MM-DD): ");
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public LocalDate getStartDate() {
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
    public Period calculatePeriodBetween(LocalDate startDate, LocalDate endDate) {
        return Period.between(startDate, endDate);
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
}
