// Author: Christian Rodriguez
// Date: 9-10-2019
// Purpose: In-class exercise 4 (String challenge)

import javax.swing.JOptionPane;

public class Ice04 {
    public static void main(String []args) {
        // Get input and remove leading and trailing whitespace
        String message = JOptionPane.showInputDialog("Please provide your email address: ").trim();

        // Get location of @ symbol
        int indexOfAt = message.indexOf('@');
        
        // Check if email is empty, contains a space, does not contain an @ symbol, or does not contain a dot after the @ symbol
        if (message.length() == 0 || message.contains(" ") || indexOfAt == -1 || !message.substring(indexOfAt + 1).contains(".")) {
            JOptionPane.showMessageDialog(null, "Invalid email address");
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Your email is " + message);
    }
}
