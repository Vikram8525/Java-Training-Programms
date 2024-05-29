<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Result</title>
</head>
<body>
    <h2>Upload Result</h2>
    <% String message = (String) request.getAttribute("message"); %>
    <% if (message != null && !message.isEmpty()) { %>
        <p><%= message %></p>
    <% } else { %>
        <p>No message available.</p>
    <% } %>

    <!-- Button to redirect to displayProducts.jsp -->
    <form action="displayProducts.jsp">
        <input type="submit" value="View Products">
    </form>
</body>
</html>
