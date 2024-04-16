package com.chainsys.jfs.day3;

import java.util.Scanner;

public class ValidationForSampleCode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number;
		do {
		    System.out.println("Please enter a positive number!");
		    while (!sc.hasNextInt()) {
		        System.out.println("That's not a number!");
		        sc.next(); // this is important!
		    }
		    number = sc.nextInt();
		} while (number <= 0);
		System.out.println("Thank you! Got " + number);
	}

}
System.out.println("Please enter a positive number!");
int number = 0;
boolean validInput = false;
while (!validInput) {
    if (sc.hasNextInt()) {
        number = sc.nextInt();
        if (number > 0) {
            validInput = true;
        } else {
            System.out.println("Please enter a positive number!");
        }
    } else {
        System.out.println("That's not a number!");
        sc.next(); // clear the invalid input from the buffer
    }
}



Scanner sc = new Scanner(System.in);

System.out.println("Please enter a string representing an integer value:");
String input = "";
boolean validInput = false;
while (!validInput) {
    input = sc.nextLine().trim(); // Read the input and remove leading/trailing whitespaces
    try {
        // Attempt to parse the input string as an integer
        Integer.parseInt(input);
        // If no exception is thrown, the input is a valid integer string
        validInput = true;
    } catch (NumberFormatException e) {
        // If an exception is caught, the input string is not a valid integer
        System.out.println("Input must be a string representing an integer value. Please try again:");
    }
}

// At this point, 'input' contains a valid string representing an integer value entered by the user
System.out.println("You entered: " + input);
