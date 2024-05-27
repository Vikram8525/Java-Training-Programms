<%@page import="com.chainsys.demo.DemoServerPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.chainsys.demo.DemoServerPojo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Display</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
}

table th, table td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

table th {
	background-color: #f2f2f2;
}

table tr:nth-child(even) {
	background-color: #f2f2f2;
}

table tr:hover {
	background-color: #ddd;
}

/* Update button */
.update-btn {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 8px 12px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	margin: 2px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
	border-radius: 4px;
}

.update-btn:hover {
	background-color: #45a049;
}

/* Delete button */
.delete-btn {
	background-color: #f44336; /* Red */
	border: none;
	color: white;
	padding: 8px 12px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	margin: 2px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
	border-radius: 4px;
}

.delete-btn:hover {
	background-color: #d32f2f;
}

/* Text box hover effect */
input[type=text]:hover, input[type=password]:hover {
	border: 1px solid #4CAF50; /* Green */
}

/* Text box focus effect */
input[type=text]:focus, input[type=password]:focus {
	border: 1px solid #4CAF50; /* Green */
	outline: none;
}
</style>

</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>
				<form action="DemoServlet" method="post" style="display:inline;">
					<input type="hidden" name="action" value="sort">
					Name
					<button type="submit" style="display:inline;">Sort</button>
				</form>
			</th>
			<th>Phone</th>
			<th>Date</th>
			<th>Password</th>
			<th>Reentered Password</th>
			<th>Action</th>
		</tr>
		<%
		ArrayList<DemoServerPojo> dataList = (ArrayList<DemoServerPojo>) request.getAttribute("viewing");
		for(DemoServerPojo demo : dataList){
		%>
		<tr>
			<td><%=demo.getId()%></td>
			<td><%=demo.getName()%></td>
			<td><%=demo.getPhone()%></td>
			<td><%=demo.getDate()%></td>
			<td><%=demo.getPass()%></td>
			<td><%=demo.getRpass()%></td>
			<td>
				<!-- Update form -->
				<form action="Update_User.jsp" method="post">
					<input type="hidden" name="action" value="update"> 
					<input type="hidden" name="updateid" value="<%=demo.getId()%>">
					<button type="submit" class="update-btn">Update</button>
				</form>
				<!-- Delete form -->
				<form action="DemoServlet" method="post">
					<input type="hidden" name="action" value="delete"> 
					<input type="hidden" name="deleteid" value="<%= demo.getId() %>">
					<button type="submit" class="delete-btn">Delete</button>
				</form>
			</td>
		</tr>
		<%
		}
		%>
		<form action="searchServlet" method="post">
			<input type="text" name="name" placeholder="Search by user name">
			<input type="submit" value="Search">
		</form>
	</table>
</body>
</html>
