package com.chainsys.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.util.Connectivity;

public class Demo {
	ArrayList<DemoServerPojo> viewing = new ArrayList<>();
	public void add (String name,String phone,String date,String pass,String rpass) {
		DemoServerPojo dp = new DemoServerPojo(name,phone,date,pass,rpass);
		viewing.add(dp);
		
	}
	public ArrayList<DemoServerPojo> Display() {
		return viewing;
	}
	public void registerUser( DemoServerPojo demoServerPojo) throws SQLException, ClassNotFoundException {

        Connection connection = null;
           PreparedStatement prepareStatement = null;
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               connection = Connectivity.getConnection();

               String register = "insert into UserData(id, name, phone, date, pass, rpass) values(0,?,?,?,?,?)";
               prepareStatement = connection.prepareStatement(register);
               prepareStatement.setString(1, demoServerPojo.getName());
               prepareStatement.setString(2, demoServerPojo.getPhone());
               prepareStatement.setString(3, demoServerPojo.getDate());
               prepareStatement.setString(4, demoServerPojo.getPass());
               prepareStatement.setString(5, demoServerPojo.getRpass());

               int rows = prepareStatement.executeUpdate();
               System.out.println("Added : " + rows);
           } finally {
               if (prepareStatement != null) {
                   prepareStatement.close();
               }
               if (connection != null) {
                   connection.close();
               }
           }
       }
}
