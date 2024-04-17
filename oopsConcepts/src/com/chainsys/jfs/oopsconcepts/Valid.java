package com.chainsys.jfs.oopsconcepts;

import java.util.Scanner;

public class Valid {

	   public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	  
	        boolean isValidInput = false;

	        while (!isValidInput) {
	            System.out.println("Please enter an integer:");
	            String input = scanner.nextLine();

	            try {
	               
	                int number = Integer.parseInt(input);

	                if (number < 0) {
	                    System.out.println("Error: Please enter a non-negative integer.");
	                } else {
	                    System.out.println("You entered: " + number);
	                    isValidInput = true; 
	                }
	            } catch (NumberFormatException e) {
	                
	                System.out.println("Error: Please enter a valid integer.");
	            }
	        }
	        
	        boolean isValidInput3 = false;

	        while (!isValidInput3) {
	            System.out.println("Please enter a double:");

	            // Read user input
	            String input = scanner.nextLine();

	            // Check if the input can be parsed into a double and if it's not negative
	            try {
	                double number = Double.parseDouble(input);
	                if (number < 0) {
	                    System.out.println("Error: Please enter a non-negative double.");
	                } else {
	                    System.out.println("You entered: " + number);
	                    isValidInput3 = true; // Set flag to true to exit the loop
	                }
	            } catch (NumberFormatException e) {
	                // If parsing fails, display an error message
	                System.out.println("Error: Please enter a valid double.");
	            }
	        }
	        
	        boolean isValidInput2 = false;

	        while (!isValidInput2) {
	            System.out.println("Please enter a string:");
	            String input = scanner.nextLine();

	            if (containsDigits(input)) {
	                System.out.println("Error: Please enter a valid string without numbers.");
	            } else if (containsSpecialCharacters(input)) {
	                System.out.println("Error: Please enter a valid string without special characters.");
	            } else {
	                System.out.println("You entered: " + input);
	                isValidInput2 = true;
	            }
	        }
	    }

	    private static boolean containsDigits(String input) {
	        for (char c : input.toCharArray()) {
	            if (Character.isDigit(c)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private static boolean containsSpecialCharacters(String input) {
	        for (char c : input.toCharArray()) {
	            if (!Character.isLetterOrDigit(c)) {
	                return true;
	            }
	        }
	        return false;
	    }

}
