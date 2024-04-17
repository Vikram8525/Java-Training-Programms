package validations;

import java.util.Scanner;

public class InputValid {


    public static int validateInteger() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter an integer:");
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);

                if (number < 0) {
                    System.out.println("Error: Please enter a non-negative integer.");
                } else {
                    System.out.println("You entered: " + number);
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    public static double validateDouble() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
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
                    return number; // Set flag to true to exit the loop
                }
            } catch (NumberFormatException e) {
                // If parsing fails, display an error message
                System.out.println("Error: Please enter a valid double.");
            }
        }
    }

    public static String validateString() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a string:");
            String input = scanner.nextLine();

            if (containsDigits(input)) {
                System.out.println("Error: Please enter a valid string without numbers.");
            } else if (containsSpecialCharacters(input)) {
                System.out.println("Error: Please enter a valid string without special characters.");
            } else {
                System.out.println("You entered: " + input);
                return input;
            }
        }
    }

    public static boolean containsDigits(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialCharacters(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
