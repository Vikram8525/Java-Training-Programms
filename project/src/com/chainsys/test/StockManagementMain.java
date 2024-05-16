package com.chainsys.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chainsys.dao.StockManagementInformation;
import com.chainsys.dao.StockManagementService;

public class StockManagementMain {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        List<StockManagementInformation> items = new ArrayList<>();
        StockManagementService service = new StockManagementService();

        while (true) {
            System.out.println("\t\t" + " .....WELCOME TO STOCK MANAGEMENT SYSTEM.....");
            System.out.println("Are you an Employee or a Customer?");
            System.out.println("For Employee, press 1.");
            System.out.println("For Customer, press 2.");
            System.out.println("For Exiting, press 3.");
            System.out.println("==================================");
            System.out.println("Enter your choice: ");
            

            int userType = scanner.nextInt();
            scanner.nextLine();

            switch (userType) {
                case 1:
                    service.employeeMenu(scanner, items);
                    break;
                case 2:
                    service.customerMenu(items);
                    break;
                case 3:
                    System.out.println("Exiting the Stock Management System..");
                    System.out.println("Thanks for visiting..");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1 for Employee or 2 for Customer.");
            }
        }
    }
}
