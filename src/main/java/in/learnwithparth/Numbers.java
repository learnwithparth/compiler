package in.learnwithparth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    public static void main(String[] args) {
        try {
            File myObj = new File("number");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // read a line from program
                String data = myReader.nextLine();
                // seperate lexems from the line
                String lexems[] = data.split("[ \\n\\t,(){}=+\\-;]");
                // System.out.println("Reading a line" + data);
                System.out.println("Lexemes are " + Arrays.toString(lexems));
                // check the token
                for (String lexem : lexems) {
                    // Compile the pattern
                    Pattern numLiteralPattern = Pattern.compile("-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?");

                    // Match the pattern in the input string
                    Matcher numLiteralMatcher = numLiteralPattern.matcher(lexem);

                    // Find and print the numbers
                    while (numLiteralMatcher.find()) {
                        System.out.println("Found number: " + numLiteralMatcher.group());
                    }

                    
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

// Find the date from the given files
