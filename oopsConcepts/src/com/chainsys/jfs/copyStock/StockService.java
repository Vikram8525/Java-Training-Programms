package com.chainsys.jfs.copyStock;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface StockService {
    void employeeMenu(Scanner scanner, List<StockManagementInformation> items) throws SQLException;

    void employeeMenuOptions(boolean isSupervisor, Scanner scanner, List<StockManagementInformation> items) throws SQLException;

    void addStock(List<StockManagementInformation> items) throws SQLException;

    void deleteStock(List<StockManagementInformation> items) throws SQLException;

    void customerMenu(List<StockManagementInformation> items) throws SQLException;

    void addEmployee(String username, String password, boolean isSupervisor) throws SQLException;

    boolean adminLogin(String name, String passWord) throws SQLException;

    boolean isAdminSupervisor(String username, String password) throws SQLException;

    void stockAvailability(List<StockManagementInformation> items) throws SQLException;

    void checkAvailability(String status) throws SQLException;
}
