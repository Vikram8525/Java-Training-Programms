package com.chainsys.jfs.oopsconcepts;

import java.util.Scanner;

public class StringNumeric {
	public static void main(String[] args) {
	boolean isValidInput1 = false;

    while (!isValidInput1) {
        System.out.println("Please enter a string:");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        if (containsDigits(input)) {
            System.out.println("Error: Please enter a valid string without numbers.");
        } else {
            System.out.println("You entered: " + input);
            isValidInput1 = true; 
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
}
