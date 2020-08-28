// Name: Christian Rodriguez
// Date: 11/19/2019
// Desc: Programming Assignment #5 - working with arrays, user input, strings, and file reading/writing

import java.io.*;
import java.util.Scanner;

public class Assignment05_Rodriguez {
    public static void main(String[] args) throws IOException {
        String name    = "";
        String city    = "";
        String state   = "";
        String street  = "";
        String zipCode = "";
        
        // Get and validate input from user
        // Only checks if empty or only contains whitespace
        Scanner input = new Scanner(System.in);
        while (name.trim().isEmpty()) {
            System.out.print("Enter Name: ");
            name = input.nextLine();
        }
        while (street.trim().isEmpty()) {
            System.out.print("Enter Street: ");
            street = input.nextLine();
        }
        while (zipCode.trim().isEmpty()) {
            System.out.print("Enter Zip: ");
            zipCode = input.nextLine();
        }
        // Open up zips.csv for reading. Creating an instance of file within
        // scanner constructor because Scanner::close() will also close the file
        Scanner zips = new Scanner(new File("zips.csv"));
        
        // In order to find the correct zip code, we must loop through each line.
        // If 'state' is not empty, we can safely assume the city has also been
        // found, therefore no more loops will be necessary.
        while (zips.hasNextLine() && state.isEmpty()) {
            // Split line into more manageable parts at each ',' character
            // parts[0] = Zip code, parts[1] = state, parts[2] = city
            String[] parts = zips.nextLine().split(",");
            if (zipCode.equals(parts[0])) {
                state = parts[1];
                
                // Split city name into parts at each space
                for (String part : parts[2].split(" ")) {
                    // Convert each part to lower case (excluding the first letter)
                    part = part.substring(0, 1) + part.substring(1).toLowerCase();
                    // Concatenate each case-corrected part into city
                    city += ' ' + part;
                }
            }
        }
        // If city and state have been found, print concatenated
        // address to console and append same address to file.
        if (!city.isEmpty() && !state.isEmpty()) {
            String address = name + ", " + street + "," + city + ", " + state + " " + zipCode;
            System.out.print(address);
            
            // Append address to addresses.txt
            PrintWriter writer = new PrintWriter(new FileWriter("addresses.txt", true));
            writer.println(address);
            writer.close();
        } else {
            System.out.print("Zip code not found.");
        }
        // Close remaining streams
        input.close();
        zips.close();       
    }
}
