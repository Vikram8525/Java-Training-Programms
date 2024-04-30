package com.chainsys.jfs.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleConnectivity {

public static void main(String[]args) throws SQLException, ClassNotFoundException {
	Connection connectionUtil = connectionUtil();
        System.out.println(connectionUtil);
        CRUDOperations.insertData();
        CRUDOperations.readData();
        CRUDOperations.updateData();
        //CRUDOperations.deleteData();
    }


public static Connection connectionUtil() throws SQLException, ClassNotFoundException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "Vikram@8525");
    return connection;
}


}
