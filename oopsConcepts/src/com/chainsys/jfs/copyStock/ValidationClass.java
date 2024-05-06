package com.chainsys.jfs.copyStock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidationClass {

    public boolean validateString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public boolean isSpecialChar(String input) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
  
    		public static int validateInteger() {
    			Scanner scanner = new Scanner(System.in);

    			while (true) {
    				System.out.print(" (Please enter an integer) ");
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
    				System.out.print(" (Please enter a double) ");

    				String input = scanner.nextLine();

    				try {
    					double number = Double.parseDouble(input);
    					if (number < 0) {
    						System.out.println("Error: Please enter a non-negative double.");
    					} else {
    						System.out.println("You entered: " + number);
    						return number;
    					}
    				} catch (NumberFormatException e) {

    					System.out.println("Error: Please enter a valid double.");
    				}
    			}
    		}

    		public static String validateString() {
    			Scanner scanner = new Scanner(System.in);

    			while (true) {
    				System.out.print(" (Please enter a string) ");
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

    		public static String validateEmailAddress() {
    		    Scanner scanner = new Scanner(System.in);
    		    boolean isValidInput = false;

    		    while (!isValidInput) {
    		        System.out.println(" (eg : mailid12@gmail.com) ");
    		        String email = scanner.nextLine();

    		        if (isValidEmail(email)) {
    		            System.out.println("Valid email address: " + email);
    		            isValidInput = true;
    		        } else {
    		            System.out.println("Invalid email address. \nPlease enter a valid email. Your email must contain:\n"
    		                    + "at least one lowercase letter (a-z).\n"
    		                    + "at least one special character (@#$%^&+=).\n"
    		                    + "And must have at least 8 characters. It should not contain any capital letters.");
    		        }
    		    }
    		    return null;
    		}

    		public static boolean isValidEmail(String email) {
    		    String emailRegex = "^(?=.*[a-z])(?=.*[@#$%^&+=]).{8,}\\.com$";
    		    String capitalRegex = ".*[A-Z].*";

    		   
    		    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(emailRegex);
    		    java.util.regex.Pattern capitalPattern = java.util.regex.Pattern.compile(capitalRegex);

    		    java.util.regex.Matcher matcher = pattern.matcher(email);
    		    java.util.regex.Matcher capitalMatcher = capitalPattern.matcher(email);

    		    return matcher.matches() && !capitalMatcher.find();
    		}

    		
    		public static String validateNameString() {
    			boolean isValidInput1 = false;

    		    while (!isValidInput1) {
    		        System.out.print(" (you can enter any name that can have space / . between them) ");
    		        Scanner sc = new Scanner(System.in);

    		        String input = sc.nextLine();

    		        if (containsDigits(input)) {
    		            System.out.println("Error: Please enter a valid string without numbers.");
    		        } else {
    		            System.out.println("You entered: " + input);
    		            isValidInput1 = true; 
    		        }
    		    }
    			return null;

    		}
    		public static String validatePassword() {
    		    Scanner scanner = new Scanner(System.in);
    		    boolean isValidInput = false;

    		    while (!isValidInput) {
    		        System.out.println(" (eg : Password@123) ");
    		        String password = scanner.nextLine();

    		        if (isValidPassword(password)) {
    		            System.out.println("Valid password: " + password);
    		            isValidInput = true;
    		        } else {
    		            System.out.println("Invalid password. \nPlease enter a valid password. Your password must contain:\n"
    		                    + "at least one uppercase letter (A-Z).\n"
    		                    + "at least one lowercase letter (a-z).\n"
    		                    + "at least one special character (!@#$%^&*).\n"
    		                    + "at least one numeric character (0-9).\n"
    		                    + "And must have at least 8 characters.");
    		        }
    		    }
    		    return null;
    		}

    		public static boolean isValidPassword(String password) {
    		    String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*\\d).{8,}$";
    		    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(passwordRegex);
    		    java.util.regex.Matcher matcher = pattern.matcher(password);
    		    return matcher.matches();
    		}
    		
    		public static String validateDateString() {
    	        boolean isValidInput = false;
    	        Scanner scanner = new Scanner(System.in);
    	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    	        while (!isValidInput) {
    	            System.out.print("Enter the date (YYYY-MM-DD): ");
    	            String input = scanner.nextLine();

    	            try {
    	                LocalDate.parse(input, dateFormatter);
    	                System.out.println("You entered: " + input);
    	                isValidInput = true;
    	            } catch (Exception e) {
    	                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
    	            }
    	        }
    	        return null; 
    	    }
    		
     }



