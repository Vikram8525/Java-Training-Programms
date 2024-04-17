package validations;

import java.util.Scanner;

public class EmailValid {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("Please enter your email address:");
            String email = scanner.nextLine();

            if (isValidEmail(email)) {
                System.out.println("Valid email address: " + email);
                isValidInput = true;
            } else {
                System.out.println("Invalid email address. \nPlease enter a valid email. your e mail must contain. \natleast a (Capital letter A-Z).\natleast a (small letter a-z). \natleast a (Special Character !@#$%^&*). \natleast a (Numeric Character 0-9) \nAnd must have 8 characters. \nExample(Mailid123@gmail.com)");
            }
        }
    }

    private static boolean isValidEmail(String email) {
        
        String emailRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}\\.com$";
        
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(emailRegex);
        
        java.util.regex.Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }

}
