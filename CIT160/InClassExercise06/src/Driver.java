// Name: Christian Rodriguez
// Date: 09/26/2019
// Desc: In class exercise #6, creating UML diagrams and converting them to code

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        // Get widget color
        System.out.print("Enter widget color: ");
        String widgetColor = keyboard.nextLine();
        
        // Get widget shape
        System.out.print("Enter widget shape: ");
        String widgetShape = keyboard.nextLine();
        
        // Get production time as integer
        int productionTimeMinutes = 0;
        while (productionTimeMinutes <= 0) {
            System.out.print("Enter number of minutes to create (greater than zero): ");
            while (!keyboard.hasNextInt()) {
                System.out.print("Number must be an integer: ");
                keyboard.next();
            }
            // Production time must be greater than 0
            productionTimeMinutes = keyboard.nextInt();
        }
        // Get number of widgets needed
        int amountOrdered = 0;
        while (amountOrdered <= 0) {
            System.out.print("Enter number of widgets needed (greater than zero): ");
            while (!keyboard.hasNextInt()) {
                System.out.print("Number must be an integer: ");
                keyboard.next();
            }
            // Production time must be greater than 0
            amountOrdered = keyboard.nextInt();
        }
        // Create widget class with attributes and output to screen epicly
        Widgets widgets = new Widgets(widgetColor, widgetShape, productionTimeMinutes);
        System.out.printf("It will take %d days to produce %d %s %s widgets", widgets.numDays(amountOrdered), amountOrdered, widgets.getColor(), widgets.getShape());
    }
}
