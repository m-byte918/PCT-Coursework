import javax.swing.JOptionPane;
/*
 * Name: Christian Rodriguez
 * Date: 11/26/2019
 * Purpose: Objective of this case study is to practice working with arrays and looping.  
 *          Class will work together to create the final solution for a video store program.
 */
public class ArrayCaseStudy { 
    /* 
     * Instructions: Bob is writing a program for his neighborhood video store that collects and 
     * manipulates information about certain movies.  Each video at the store has as a serial 
     * number that is used to uniquely identify that video.   Bob would like to store the 
     * following serial numbers in an array called “serialNum”:
     * 
     *          1324212
     *          2300034
     *          7356323
     *          8453457
     *          9000024
     *          9003324
     * 
     * Since the movie store is continually growing, Bob has decided to create this array with the 
     * length set at 10. 
     */
    public static void main(String[] args) {
        // Declaring and initializing the array
        int[] serialNum = new int[10];
        
        // Will store user option
        int option = 0;

        /* Inserting numbers in array -- could get values from user – but we will hard code the values for now*/
        serialNum[0] = 1324212;
        serialNum[1] = 2300034;
        serialNum[2] = 7356323;
        serialNum[3] = 8453457;
        serialNum[4] = 9000024;
        serialNum[5] = 9003324;
        serialNum[6] = 3236537;
        serialNum[7] = 7543584;
        serialNum[8] = 4200009;
        serialNum[9] = 2124231;
            
        // Loop until user quits
        while (true) {
            String input = JOptionPane.showInputDialog(
                "Options:\n" +
                "0 – Quit\n" +
                "1 – Print Serial Numbers\n"+
                "2 – Delete Serial Number\n"+
                "3 – Add Serial Number"
            );
            if (input == null)
                break; // User hit cancel
            
            option = Integer.parseInt(input);
            if (option == 0)
                break; // User selected 'quit' option

            // Print serial numbers option
            if (option == 1) {
                //print the contents of the array (excluding zeros)
                for (int i = 0; i < serialNum.length; ++i) {
                    if (serialNum[i] != 0)
                        System.out.println(serialNum[i]);
                }
                System.out.println();
            }
            // Delete serial number option
            else if (option == 2) {
                int searchItem = Integer.parseInt(JOptionPane.showInputDialog("Enter number to be deleted:"));
                // Check for valid serial number
                if (searchItem < 1000000 || searchItem > 9999999) {
                    System.out.println("Invalid serial number.");
                    continue;
                }
                // Search for the item
                boolean found = false;
                for (int i = 0; i < serialNum.length; ++i) {
                    // Match -- it will be set to zero to mark deletion
                    if (serialNum[i] == searchItem) {
                        serialNum[i] = 0;
                        found = true;
                        break; // No more loops necessary
                    }
                }
                // Serial number was never found
                if (!found)
                    System.out.println("Serial number was not found!");
            // Add serial number option
            } else if (option == 3) {
                int addItem = Integer.parseInt(JOptionPane.showInputDialog("Enter number to be added:"));
                // Check for valid serial number
                if (addItem < 1000000 || addItem > 9999999) {
                    System.out.println("Invalid serial number.");
                    continue;
                }
                // Search for deleted values
                boolean spaceAvailable = false;
                boolean alreadyExists = false;
                for (int i = 0; i < serialNum.length; ++i) {
                    // Cannot have duplicate serial numbers
                    if (addItem == serialNum[i]) {
                        alreadyExists = true;
                        break; // Duplicate, no more loops necessary
                    }
                    // Replace any deleted (zero) serial numbers with addItem
                    if (serialNum[i] == 0) {
                        serialNum[i] = addItem;
                        spaceAvailable = true;
                        break; // No more loops necessary
                    }
                }
                if (alreadyExists)
                    System.out.println("Serial number already exists!");
                if (!spaceAvailable)
                    System.out.println("There is no more room to add serial numbers!");
            }
        }
        //Required when using JOptionPane
        System.exit(0);
    }
}
