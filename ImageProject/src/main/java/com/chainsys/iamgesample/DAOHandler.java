package com.chainsys.iamgesample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOHandler {
    public boolean saveProduct(dao product) {
        String sql = "INSERT INTO Products (Name, Description, Image) values (?, ?, ?)";
        try (Connection conn = Connectivity.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBytes(3, product.getImage());

            int row = statement.executeUpdate();
            return row > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
