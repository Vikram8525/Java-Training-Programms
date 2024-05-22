<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<style>
@font-face {
	font-family: 'One Piece';
	src: url('path/to/one-piece-font.woff2') format('woff2'),
		url('path/to/one-piece-font.woff') format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	font-family: 'One Piece', Arial, sans-serif;
	margin: 0;
	padding: 0;
	position: relative;
}

.navbar {
	display: flex;
	background-color: rgba(248, 249, 250, 0.8);
	padding: 10px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	position: relative;
	z-index: 2;
}

.nav-item {
	margin-right: 10px;
}

.nav-link {
	padding: 15px 20px;
	border-radius: 5px;
	transition: all 0.3s ease;
}

.nav-link:hover {
	background-color: #dee2e6;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

main {
	margin: 0;
	padding: 0;
	display: flex;
	align-items: flex-start;
	justify-content: center;
	position: relative;
	z-index: 1;
}

.form-container {
	background-color: rgba(0, 0, 0, 0.8);
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(255, 255, 255, 0.3);
	transition: all 0.3s ease;
	margin-top: 20px;
	color: #ffffff;
}

form {
	margin-top: 20px;
}

input[type="text"], input[type="email"], input[type="tel"], input[type="password"],
	textarea, select {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	transition: border-color 0.3s ease;
}

input[type="submit"], button {
	width: 100%;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

input[type="submit"]:hover, button:hover {
	background-color: #45a049;
}

article {
	background-size: cover;
	background-position: center;
	padding: 20px;
	border-radius: 10px;
	transition: all 0.3s ease;
}

article h1 {
	text-align: center;
	color: #ffffff;
}

article table {
	width: 100%;
}

article label {
	font-weight: bold;
}

article center button {
	margin-top: 20px;
}

video {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	object-fit: cover;
	z-index: 0;
	opacity: 0.5;
}

.form-container:hover {
	box-shadow: 0 0 30px rgba(0, 0, 0, 0.5);
}
</style>
</head>
<body>
	<video autoplay muted loop>
		<source src="Media/sample start.mp4" type="video/mp4">
	</video>
	<header>
		<nav class="navbar">
			<div class="nav-item">
				<a class="nav-link" href="index.html">One Piece</a>
			</div>
			<div class="nav-item">
				<a class="nav-link" href="index.html">Home</a>
			</div>
			<div class="nav-item">
				<a class="nav-link" href="index.html#about">About</a>
			</div>
			<div class="nav-item">
				<a class="nav-link" href="index.html#contact">Contact</a>
			</div>
		</nav>
	</header>
	<main>
		<div class="form-container">
			<article>
				<h1>Registration Form</h1>
				<form action="DemoServlet">
					<table>
						<tr>
							<td><label for="fname"><h2>
										Name:<span style="color: crimson;">*</span>
									</h2></label></td>
							<td><input type="text" id="fname" name="fname" required
								minlength="2" maxlength="30" placeholder="Enter your first name"></td>
						</tr>
						<tr>
							<td><label for="phone"><h2>
										Phone Number:<span style="color: crimson;">*</span>
									</h2></label></td>
							<td><input type="tel" id="phone" name="phone" required
								pattern="[0-9]{10}" placeholder="Enter your mobile number"></td>
						</tr>
						<tr>
							<td><label for="date"><h2>Date of Birth:</h2></label></td>
							<td><input type="date" id="date" name="date" required
								min="1923-01-01" max="2023-01-01"></td>
						</tr>
						<tr>
							<td><label for="password"><h2>
										Password:<span style="color: crimson;">*</span>
									</h2></label></td>
							<td><input type="password" id="password" name="password"
								required minlength="8" maxlength="16"
								placeholder="Enter your password"></td>
						</tr>
						<tr>
							<td><label for="repassword"><h2>
										Retype Password: <span style="color: crimson;">*</span>
									</h2></label></td>
							<td><input type="password" id="repassword" name="repassword"
								required minlength="8" maxlength="16"
								placeholder="Enter your password again"></td>
						</tr>

					</table>
					<input type="submit" value="Submit">
				</form>
			</article>
		</div>
	</main>
</body>
</html>
