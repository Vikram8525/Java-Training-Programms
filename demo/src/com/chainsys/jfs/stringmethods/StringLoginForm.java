package com.chainsys.jfs.stringmethods;

import java.util.Scanner;

public class StringLoginForm {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Get user information
		System.out.print("Enter your username: ");
		String username = scanner.nextLine();
		System.out.print("Enter your email address: ");
		String email = scanner.nextLine();
		System.out.print("Enter your password: ");
		String password = scanner.nextLine();

		// Validate user information
		boolean isUsernameValid = isUsernameValid(username);
		boolean isEmailValid = isEmailValid(email);
		boolean isPasswordValid = isPasswordValid(password);

		// Display validation results
		if (isUsernameValid && isEmailValid && isPasswordValid) {
			System.out.println("User information is valid.");
		} else {
			System.out.println("User information is invalid.");
		}

		scanner.close();
	}

	// Validate username (must contain only letters and numbers)
	private static boolean isUsernameValid(String username) {
		return username.matches("[a-zA-Z0-9]+");
	}

	// Validate email address (simple validation for demonstration)
	private static boolean isEmailValid(String email) {
		return email.contains("@") && email.contains(".");
	}

	// Validate password (must be at least 8 characters long)
	private static boolean isPasswordValid(String password) {
		return password.length() >= 8;
	}

}
