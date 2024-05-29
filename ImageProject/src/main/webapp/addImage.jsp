<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Image</title>
</head>
<body>
    <h2>Add Image</h2>
    <form method="post" action="UploadImageServlet" enctype="multipart/form-data">
        Product Name: <input type="text" name="productName"><br>
        Product Description: <input type="text" name="productDescription"><br>
        Select image to upload:
        <input type="file" name="image"><br>
        <input type="submit" value="Upload">
    </form>
</body>
</html>

    