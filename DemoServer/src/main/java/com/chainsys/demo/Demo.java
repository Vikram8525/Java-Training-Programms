package com.chainsys.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

               String register = "insert into UserData( name, phone, date, pass, rpass) values(?,?,?,?,?)";
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
	
	public ArrayList<DemoServerPojo> listOfUsers() throws SQLException, ClassNotFoundException {
        ArrayList<DemoServerPojo> demoServerPojo = new ArrayList<>(); 
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = Connectivity.getConnection();
            
            String userList = "select id, name, phone, date, pass, rpass from UserData";
            prepareStatement = connection.prepareStatement(userList);
            resultSet = prepareStatement.executeQuery();
            
            while (resultSet.next()) {
                DemoServerPojo dpojo = new DemoServerPojo(); 
                dpojo.setId(resultSet.getInt("id"));
                dpojo.setName(resultSet.getString("name"));
                dpojo.setPhone(resultSet.getString("phone"));
                dpojo.setDate(resultSet.getString("date"));
                dpojo.setPass(resultSet.getString("pass"));
                dpojo.setRpass(resultSet.getString("rpass"));
                
                
                demoServerPojo.add(dpojo); 
            }
        } finally {
            
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return demoServerPojo;
    }
	
	public void deleteUser(int id) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = Connectivity.getConnection();
        String delete = "delete from UserData where id= "+id;
        PreparedStatement prepareStatement = connection.prepareStatement(delete);
        int row = prepareStatement.executeUpdate();
        System.out.println("Affected row :"+row);
           
       
   }
    

	
}
