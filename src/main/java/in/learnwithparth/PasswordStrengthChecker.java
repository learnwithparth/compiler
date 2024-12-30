package in.learnwithparth;

import java.util.Scanner;

public class PasswordStrengthChecker {

    // Method to check password strength
    public static String checkPasswordStrength(String password) {
        // Regular expressions for different conditions
        String lengthRegex = ".{8,}"; // At least 8 characters
        String uppercaseRegex = ".*[A-Z].*"; // At least one uppercase letter
        String lowercaseRegex = ".*[a-z].*"; // At least one lowercase letter
        String digitRegex = ".*[0-9].*"; // At least one digit
        String specialCharRegex = ".*[!@#$%^&*()\\-_=+{};:,<.>].*"; // At least one special character

        boolean isLongEnough = password.matches(lengthRegex);
        boolean hasUppercase = password.matches(uppercaseRegex);
        boolean hasLowercase = password.matches(lowercaseRegex);
        boolean hasDigit = password.matches(digitRegex);
        boolean hasSpecialChar = password.matches(specialCharRegex);

        // Determine password strength
        if (isLongEnough && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            return "Strong";
        } else if (isLongEnough && ((hasUppercase && hasLowercase) || (hasLowercase && hasDigit) || (hasDigit && hasSpecialChar))) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();

        // Check and display password strength
        String strength = checkPasswordStrength(password);
        System.out.println("Password strength: " + strength);

        scanner.close();
    }
}