package com.chainsys.jfs.databaseconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDOperations {

    public static void insertData(ConnectivityPojo data) throws ClassNotFoundException, SQLException {
        try (Connection con = SampleConnectivity.connectionUtil();
             Statement st = con.createStatement()) {
            String query = "insert into student1 values(" + data.getId() + ",'" + data.getName() + "'," + data.getClassHeld() + "," + data.getClassAttended() + ")";
            st.executeUpdate(query);
        }
    }

    public static void readData() throws ClassNotFoundException, SQLException {
        try (Connection con = SampleConnectivity.connectionUtil();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student1")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int classHeld = rs.getInt("classheld");
                int classAttended = rs.getInt("classattended");
                System.out.println("ID: " + id + ", Name: " + name + ", Class Held: " + classHeld + ", Class Attended: " + classAttended);
            }
        }
    }

    public static void updateData() throws ClassNotFoundException, SQLException {
        try (Connection con = SampleConnectivity.connectionUtil();
             Statement st = con.createStatement()) {
            String query = "UPDATE student1 SET classattended = 80 WHERE id = 11";
            st.executeUpdate(query);
        }
    }

    public static void deleteData() throws ClassNotFoundException, SQLException {
        try (Connection con = SampleConnectivity.connectionUtil();
             Statement st = con.createStatement()) {
            String query = "DELETE FROM student1 WHERE id = 11";
            st.executeUpdate(query);
        }
    }
}
