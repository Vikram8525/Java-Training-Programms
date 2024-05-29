<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Base64" %>
<%@ page import="com.chainsys.iamgesample.Connectivity" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display Products</title>
    <style>
        .card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin: 10px;
            width: 200px;
            float: left;
            cursor: pointer;
            transition: transform 0.2s;
        }
        .card img {
            max-width: 100%;
            height: 300px;
            object-fit: cover;
        }
        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
    </style>
    <script>
        function redirectToIndex() {
            window.location.href = 'index.jsp';
        }
    </script>
</head>
<body>
    <h2>Products</h2>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %>
    <%
        Connection conn = null;
        try {
            conn = Connectivity.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            while (rs.next()) {
                String productName = rs.getString("Name");
                String productDescription = rs.getString("Description");
                Blob blob = rs.getBlob("Image");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
    %>
                <div class="card" onclick="redirectToIndex()">
                    <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Product Image">
                    <div class="card-details">
                        <h3><%= productName %></h3>
                        <p><%= productDescription %></p>
                    </div>
                </div>
    <%
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    %>
</body>
</html>
