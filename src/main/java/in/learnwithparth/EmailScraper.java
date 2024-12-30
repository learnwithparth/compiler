package in.learnwithparth;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.io.*;

public class EmailScraper {

    public static void main(String[] args) {
        String url = "https://www.charusat.ac.in/university-officers"; // Replace with your target URL

        try {
            // Fetch the HTML content of the webpage
            Document doc = Jsoup.connect(url).get();

            // Extract text content from the webpage
            String pageText = doc.text();

            // Define a regex pattern for email addresses
            String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?";
            Pattern pattern = Pattern.compile(emailRegex);

            // Match the regex pattern against the webpage text
            Matcher matcher = pattern.matcher(pageText);

            // Use a HashSet to store unique email addresses
            HashSet<String> emailAddresses = new HashSet<>();

            while (matcher.find()) {
                emailAddresses.add(matcher.group());
            }

            // Print the found email addresses
            if (emailAddresses.isEmpty()) {
                System.out.println("No email addresses found on the page.");
            } else {
                System.out.println("Email addresses found:");
                for (String email : emailAddresses) {
                    System.out.println(email);
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while connecting to the URL.");
            e.printStackTrace();
        }
    }
}
