// Name: Christian Rodriguez
// Date: 02/03/2020
// Desc: In-class exercise #2 (part 1 & 2), text processing using wrapper classes

import javax.swing.*;
import java.util.StringTokenizer;

public class ICE2 {
    public static void main(String[] args) {
        String input = null; // User input
        StringTokenizer tokenizer = null; // Tokenized user input
        int tokenCount = 0; // Amount of tokens in the tokenizer
        
        // Sentence must be between 4 and 8 words. Validate by
        // prompting for input each time that condition is not met
        while (tokenCount < 4 || tokenCount > 8) {
            // Prompt user for input using JOptionPane
            input = JOptionPane.showInputDialog(
                null, 
                "Please enter a sentence with a minimum of 4 words and a maximum of 8.", 
                "Enter a sentence", 
                JOptionPane.INFORMATION_MESSAGE
            );
            // User hit cancel or exited
            if (input == null) {
                System.exit(0);
            }
            // Trim any unwanted whitespace
            input = input.trim();

            // Split user input by whitespace
            tokenizer = new StringTokenizer(input, " ");
            tokenCount = tokenizer.countTokens();
        }
        // Padding because \t does not work in JOptionPane :c
        String pad = "        ";

        // Initialize StringBuilder to store output for JOptionPane
        StringBuilder output = new StringBuilder();
        
        // Add input sentence to output
        output.append(input + "\n\n");
        
        int totalCharacters = 0; // For output
        
        // Loop through each token
        while (tokenizer.hasMoreTokens()) {
            String token       = tokenizer.nextToken();
            int tokenLength    = token.length();
            int letterCount    = 0;
            int digitCount     = 0;
            int lowerCaseCount = 0;
            int upperCaseCount = 0;
            int spacesCount    = 0;

            for (int i = 0; i < tokenLength; ++i) {
                char ch = token.charAt(i);
                if (Character.isLetter(ch))
                    ++letterCount;
                if (Character.isDigit(ch))
                    ++digitCount;
                if (Character.isLowerCase(ch))
                    ++lowerCaseCount;
                if (Character.isUpperCase(ch))
                    ++upperCaseCount;
                if (Character.isWhitespace(ch))
                    ++spacesCount;
            }
            // Add each token to output, including it's length
            output.append(token + " has " + tokenLength + " characters\n");
            
            // Add everything else
            output.append(pad + "Number of letters is "            + letterCount    + "\n");
            output.append(pad + "Number of digits is "             + digitCount     + "\n");
            output.append(pad + "Number of lower case letters is " + lowerCaseCount + "\n");
            output.append(pad + "Number of upper case letters is " + upperCaseCount + "\n");
            output.append(pad + "Number of spaces is "             + spacesCount    + "\n");
            
            // Update total characters
            totalCharacters += tokenLength;
        }
        output.append("\nThe total number of characters excluding spaces is " + totalCharacters + "." + pad + "\n\n");
        
        // Finished building output, now print it with JOptionPane
        JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.INFORMATION_MESSAGE);
        
        // Stop JOptionPane
        System.exit(0);
    }
}
