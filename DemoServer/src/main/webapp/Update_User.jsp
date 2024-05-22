<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Registration</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-image: url('background-image.jpg'); /* Replace 'background-image.jpg' with your image path */
        background-size: cover;
    }

    .container {
        max-width: 500px;
        margin: 100px auto;
        padding: 20px;
        background-color: rgba(255, 255, 255, 0.8); /* Transparency */
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* Shadow effect */
    }

    .container:hover {
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.5); /* Hover effect */
    }

    h2 {
        text-align: center;
        color: #333;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        transition: border-color 0.3s;
    }

    input[type="text"]:hover,
    input[type="password"]:hover {
        border-color: #666;
    }

    input[type="text"]:focus,
    input[type="password"]:focus {
        outline: none;
        border-color: #4CAF50;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 5px;
        background-color: #4CAF50;
        color: #fff;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

<div class="container">
    <h2>User Registration</h2>
    <form action="DemoServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" pattern="[0-9]{10}" required>
        
        <label for="date">Date:</label>
        <input type="text" id="date" name="date" placeholder="YYYY-MM-DD" pattern="\d{4}-\d{2}-\d{2}" required>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" minlength="6" required>
        
        <label for="repassword">Re-enter Password:</label>
        <input type="password" id="repassword" name="repassword" minlength="6" required>

        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>
