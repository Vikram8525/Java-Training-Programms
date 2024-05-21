package com.chainsys.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.chainsys.model.CustomerPojo;
import com.chainsys.util.Connectivity;
import com.chainsys.util.StockManagementCRUD;

public class StockManagementService implements StockService {

    @Override
    public void employeeMenu(Scanner scanner, List<StockManagementInformation> items) throws SQLException {
        // Implementation
    	while (true) {
        System.out.println("\t\t" + "..Welcome Employee..");
        System.out.println("Do you have an Employee Account (yes or no)");
        String hasAccount = scanner.nextLine().toLowerCase();

        if (hasAccount.equals("no")) {
            // Register new employee
            System.out.println("Creating Employee Account...");
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            System.out.println("Are you a supervisor? (yes or no)");
            boolean isSupervisor = scanner.nextLine().equalsIgnoreCase("yes");
            if (isSupervisor) {
                System.out.println("Enter supervisor password: ");
                String supervisorPassword = scanner.nextLine();
                if (supervisorPassword.equals("Admin@123")) {
                    addEmployee(username, password, isSupervisor);
                    System.out.println("Employee Account Created Successfully!");
                } else {
                    isSupervisor = false;
                    addEmployee(username, password, isSupervisor);
                    System.out.println("Incorrect supervisor password. Assigned as normal employee.");
                }
            } else {
                addEmployee(username, password, isSupervisor);
                System.out.println("Employee Account Created Successfully!");
            }
        } 
        
        else if (hasAccount.equals("yes")) {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            
            if (adminLogin(username, password)) {
                System.out.println("Login Successful!");
                boolean isSupervisor = isAdminSupervisor(username, password);
                employeeMenuOptions(isSupervisor, scanner, items);
            } else {
                System.out.println("Incorrect username or password. Please try again. \nIf you dont have an account create a new account by clicking 'no'");
            }
        } else {
            System.out.println("Invalid choice! Please enter 'yes' or 'no'.");
        }
    	}
    }

    @Override
    public void employeeMenuOptions(boolean isSupervisor, Scanner scanner, List<StockManagementInformation> items) throws SQLException {
        // Implementation
        boolean exitEmployee = false;
        while (!exitEmployee) {
            System.out.println("\nEmployee Menu:");
            if (isSupervisor) {
                System.out.println("\t\t" + "..Welcome Supervisor..");
            } else {
                System.out.println("\t\t" + "..Welcome Employee..");
            }

            System.out.println("1. View Stock");
            if (isSupervisor) {
                System.out.println("2. Add Stock");
                System.out.println("3. Delete Stock");
            }
            System.out.println("4. Check Stock Freshness");
            System.out.println("5. Check Stock Availability");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    StockManagementCRUD.displayStocks();
                    break;
                case 2:
                    if (isSupervisor) {
                        addStock(items);
                    } else {
                        System.out.println("You are not authorized to add stock.");
                    }
                    break;
                case 3:
                    if (isSupervisor) {
                        deleteStock(items);
                    } else {
                        System.out.println("You are not authorized to delete stock.");
                    }
                    break;
                case 4:
                    StockManagementCRUD.checkStockAgeAndAvailability(items);
                    break;
                case 5:
                    stockAvailability(items);
                    break;
                case 6:
                    exitEmployee = true;
                    System.out.println("Exiting Employee Menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    @Override
    public void addStock(List<StockManagementInformation> items) throws SQLException {
        // Implementation
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        StockManagementInformation item = new StockManagementInformation(itemName);
        items.add(item);
        try {
            LocalDate startDate = item.getStartDate();
            java.util.Date utilStartDate = java.sql.Date.valueOf(startDate);
            StockManagementCRUD.addStock(0, itemName, item.getItemQuantity(), utilStartDate, item.getPrice());
            System.out.println("Item added successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to add item to database: " + e.getMessage());
        }
    }

    @Override
    public void deleteStock(List<StockManagementInformation> items) throws SQLException {
        // Implementation
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the item to delete: ");
        String itemName = scanner.nextLine();

        boolean success = StockManagementCRUD.deleteStock(itemName);
        if (success) {
            System.out.println("Item '" + itemName + "' deleted successfully.");

            items.removeIf(item -> item.getItemName().equalsIgnoreCase(itemName));
        } else {
            System.out.println("Failed to delete item '" + itemName + "'.");
        }
    }

    @Override
    public void customerMenu(List<StockManagementInformation> items) throws SQLException {
        // Implementation
    	Scanner scanner = new Scanner(System.in);
    	 CustomerPojo cp = new CustomerPojo();
    	 ValidationClass vc = new ValidationClass();
    	 StockManagementService service = new StockManagementService();
    	 //start
    	 
    	System.out.println("\t\t" + "..Welcome Customer..");
        System.out.println("Do you have a Customer Account (yes or no)");
        String hasAccount = scanner.nextLine().toLowerCase();

        if (hasAccount.equals("no")) {
            // Register new employee
            System.out.println("...Creating Customer Account...");
            System.out.println("Enter your name: ");
            String username = scanner.nextLine();
            int uniqueID = generateUniqueID();
            System.out.println("Your unique id is :" + uniqueID);
            System.out.println("----------Remember this id----------");
            String number = vc.validatePhoneNumber();
            String email = vc.validateEmailAddress();
            String password = vc.validatePassword();
            System.out.println("Enter your address :");
            String address = scanner.nextLine();
            addCustomer(username, uniqueID, number, email, password, address);
            }
   
        else if (hasAccount.equals("yes")) {
            boolean loggedIn = false;
            while (!loggedIn) {
                System.out.println("Enter your Customer Id (or type 'end' to cancel): ");
                String id = scanner.nextLine();
                
                if (id.equalsIgnoreCase("end")) {
                	service.customerMenu(items);
                    break; // Break the loop if the user inputs "end"
                    
                }
                
                System.out.println("Enter your password: ");
                String password = scanner.nextLine();
                
                if (customerLogin(id, password)) {
                    System.out.println("Login Successful!");
                    loggedIn = true;
                } else {
                    System.out.println("Incorrect Id or password. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid choice! Please enter 'yes' or 'no'.");
        }

        boolean exitCustomer = false;
        while (!exitCustomer) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Check Stock Details");
            System.out.println("2. Check Product Freshness");
            System.out.println("3. Buy Your Product");
            System.out.println("4. Exit!");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    StockManagementCRUD.displayStocks();
                    break;
                case 2:
                    StockManagementCRUD.checkStockAgeAndAvailability(items);
                    break;
                case 3:
                    StockManagementCRUD.buyStock();
                    break;
                case 4:
                    exitCustomer = true;
                    System.out.println("Exiting Customer Menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    	
    }

    @Override
    public void addEmployee(String username, String password, boolean isSupervisor) throws SQLException {
        // Implementation
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = Connectivity.getConnection();
            String insertQuery = "INSERT INTO employees (username, password, is_supervisor) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setBoolean(3, isSupervisor);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee added successfully!");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public boolean adminLogin(String name, String passWord) throws SQLException {
        // Implementation
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean loggedIn = false;
        try {
            connection = Connectivity.getConnection();
            String loginQuery = "SELECT * FROM employees WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(loginQuery);
            statement.setString(1, name);
            statement.setString(2, passWord);
            resultSet = statement.executeQuery();
            loggedIn = resultSet.next();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return loggedIn;
    }

    @Override
    public boolean isAdminSupervisor(String username, String password) throws SQLException {
        // Implementation
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isSupervisor = false;
        try {
            connection = Connectivity.getConnection();
            String supervisorQuery = "SELECT is_supervisor FROM employees WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(supervisorQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int supervisorValue = resultSet.getInt("is_supervisor");
                isSupervisor = (supervisorValue == 1);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return isSupervisor;
    }

    @Override
    public void stockAvailability(List<StockManagementInformation> items) throws SQLException {
        // Implementation
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Available Enough");
            System.out.println("2. Will Depleted");
            System.out.println("3. Required Item");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkAvailability("available_enough");
                    break;
                case 2:
                    checkAvailability("Will_Depleted");
                    break;
                case 3:
                    checkAvailability("Required_item");
                    break;
                case 4:
                    System.out.println("Exiting stock availability check.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }

    @Override
    public void checkAvailability(String status) throws SQLException {
        // Implementation
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Connectivity.getConnection();
            String query = "SELECT item_name, item_quantity FROM stock";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            System.out.println("Stock Availability:");
            while (resultSet.next()) {
                String itemName = resultSet.getString("item_name");
                int quantity = resultSet.getInt("item_quantity");

                switch (status) {
                    case "available_enough":
                        if (quantity >= 50) {
                            System.out.println(itemName + ": There is enough stock available.");
                        }
                        break;
                    case "Will_Depleted":
                        if (quantity >= 10 && quantity < 50) {
                            System.out.println(itemName + ": Stock will be depleted soon.");
                        }
                        break;
                    case "Required_item":
                        if (quantity > 0 && quantity < 10) {
                            System.out.println(itemName + ": Final few stock! Add it ASAP.");
                        }
                        break;
                }
            }
        } finally {
            // Closing resources
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    // start
    // Method to generate a random ID number
    private static int generateRandomID() {
        Random random = new Random();
        return 1000 + random.nextInt(9000); // Generate a 4-digit random number
    }

    // Method to check if the generated ID number already exists in the database
    private static boolean isIDExists(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM Customer WHERE id = ?";
        try (Connection conn = Connectivity.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Return true if ID exists, false otherwise
                }
            }
        }
        return false;
    }

    // Method to generate a unique ID number
    private static int generateUniqueID() throws SQLException {
        int id;
        do {
            id = generateRandomID();
        } while (isIDExists(id)); // Generate new ID until it's unique
        return id;
    }
  
    public void addCustomer(String customerName, int id, String mobileNumber, String mailId, String password, String address) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = Connectivity.getConnection();
            String insertQuery = "INSERT INTO Customer (customerName, id, mobileNumber, mailId, password, address, lastVisitedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, customerName);
            statement.setInt(2, id);
            statement.setString(3, mobileNumber);
            statement.setString(4, mailId);
            statement.setString(5, password);
            statement.setString(6, address);
            statement.setDate(7,new java.sql.Date( new Date().getTime()));
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Customer added successfully!");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    

    public boolean customerLogin(String id, String passWord) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean loggedIn = false;
        try {
            connection = Connectivity.getConnection();
            String loginQuery = "SELECT * FROM Customer WHERE id = ? AND password = ?";
            statement = connection.prepareStatement(loginQuery);
            statement.setString(1, id);
            statement.setString(2, passWord);
            resultSet = statement.executeQuery();
            loggedIn = resultSet.next();
            
            if (loggedIn) {                
                Date lastVisitedDate = resultSet.getDate("lastVisitedDate");                
                Date currentDate = new Date();
                long milliDif = currentDate.getTime() - lastVisitedDate.getTime();
                long daysSinceLastVisit = TimeUnit.DAYS.convert(milliDif, TimeUnit.MILLISECONDS);
                System.out.println("\t\t ------Welcome Back Customer------");
                if(daysSinceLastVisit == 0) {
                	System.out.println("You have visited our store today ");
                }
                else if(daysSinceLastVisit == 1) {
                	System.out.println("You have visited our store yesterday ");
                }
                else if(daysSinceLastVisit > 1 && daysSinceLastVisit <= 7){
                	System.out.println("You have visited our store within this week");
                }
                else if(daysSinceLastVisit > 7 && daysSinceLastVisit <= 30) {
                	System.out.println("You have visited our store within this Month");
                }
                System.out.println("You Have visited Our Store before " + daysSinceLastVisit + " days");
                String updateQuery = "UPDATE Customer SET lastVisitedDate = ? WHERE id = ?";
                statement = connection.prepareStatement(updateQuery);
                statement.setDate(1, new java.sql.Date(currentDate.getTime()));
                statement.setString(2, id);
                statement.executeUpdate();
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return loggedIn;
    }

}
