<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Form</title>
</head>
<body>
    <h2>Order Form</h2>
    <form action="OrderServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br><br>

        <label for="contact">Contact Number:</label>
        <input type="text" id="contact" name="contact" required><br><br>

        <button type="submit">Confirm Order</button>
    </form>
</body>
</html>