// Name: Christian Rodriguez
// Date: 02/28/2020
// Desc: Programming assignment 02 - using abstract classes and interfaces

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Driver class to test both the basic and advanced calculators.
 * 
 * @author Christian Rodriguez
 * @version 1.0
 */
public class MyCalculatorApp_Rodriguez {
	private static String                       input        = "";
	private static Scanner                      keyboard     = new Scanner(System.in);
	private static BasicCalculator_Rodriguez    basicCalc    = new BasicCalculator_Rodriguez();
	private static AdvancedCalculator_Rodriguez advancedCalc = new AdvancedCalculator_Rodriguez();

	/**
	 * Prints out a message then terminates the program.
	 * 
	 * @param message Message to print
	 */
	public static void exitWithMessage(String message) {
		System.out.println(message);
		System.exit(0);
	}

	/**
	 * Validates and returns a new double based on the provided string. If the 
	 * provided string cannot be parsed to a double, then the program terminates.
	 * 
	 * @param str String to be parsed and returned as a new double
	 * @return    The double value represented by the str argument
	 */
	public static double getParsedDouble(String str) {
		double parsedDouble = 0.0;
		try {
			parsedDouble = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			exitWithMessage("Invalid number");
		}
		return parsedDouble;
	}
	
	/**
	 * Validates and returns a new integer based on the provided string. If the 
	 * provided string cannot be parsed to an integer, then the program terminates.
	 * 
	 * @param str String to be parsed and returned as a new integer
	 * @return    The integer value represented by the str argument
	 */
	public static int getParsedInt(String str) {
		int parsedInt = 0;
		try {
			parsedInt = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			exitWithMessage("Invalid number");
		}
		return parsedInt;
	}

	/**
	 * Collect all numbers entered by the user until they enter 'calculate'.
	 * The collected numbers are then returned as an array of doubles
	 * 
	 * @return An array of doubles
	 */
	public static double[] collectDoubles() {
		input = keyboard.nextLine();
		
		// Using arraylists because of their variable length
		// It is of type double because integers can be converted to doubles without data loss
		ArrayList<Double> parsedDoubles = new ArrayList<Double>();

		// Collect numbers until user enters 'calculate'
		while (!input.equals("calculate")) {
			parsedDoubles.add(getParsedDouble(input));
			input = keyboard.nextLine();
		}
		// Calculator methods do not account for empty arrays so return one containing a single zero
		int doubleAmount = parsedDoubles.size();
		if (doubleAmount == 0) {
			return new double[1];
		}
		// Copy arraylist to regular array because ArrayList::toArray() will return the wrong type
		double[] doubleArray = new double[doubleAmount];
		for (int i = 0; i < doubleAmount; ++i) {
			doubleArray[i] = parsedDoubles.get(i);
		}
		return doubleArray;
	}
	
	/**
	 * Prompts user for which calculator function they would like to perform, 
	 * performs them, then prints the result.
	 */
	public static void runCalculator() {
		String sentinel = " (enter \"calculate\" to print the result): ";
		System.out.print("Enter the operation you would like to perform: ");
		
		// Do any operation supported by basic calculator and advanced calculator
		switch (keyboard.nextLine()) {
			case "+":
			case "add":
				System.out.println("Enter the numbers you would like to add" + sentinel);
				System.out.println("Result: " + basicCalc.add(collectDoubles()));
				break;
			case "-":
			case "subtract":
				System.out.println("Enter the numbers you would like to subtract" + sentinel);
				System.out.println("Result: " + basicCalc.subtract(collectDoubles()));
				break;
			case "*":
			case "multiply":
				System.out.println("Enter the numbers you would like to multiply" + sentinel);
				System.out.println("Result: " + basicCalc.multiply(collectDoubles()));
				break;
			case "/":
			case "divide": {
				System.out.println("Please enter the numerator");
				double numerator = getParsedDouble(keyboard.nextLine());
				
				System.out.println("Please enter the denominator");
				double denominator = getParsedDouble(keyboard.nextLine());
	
				try {
					System.out.println("Result: " + basicCalc.divide(numerator, denominator));
				} catch (ArithmeticException e) {
					exitWithMessage("Error: divide by zero"); // Print it in a nicer way
				}
				break;
			}
			case "%":
			case "mod": {
				System.out.println("Please enter the numerator");
				int numerator = getParsedInt(keyboard.nextLine());
				
				System.out.println("Please enter the denominator");
				int denominator = getParsedInt(keyboard.nextLine());

				try {
					System.out.println("Result: " + advancedCalc.mod(numerator, denominator));
				} catch (ArithmeticException e) {
					exitWithMessage("Error: divide by zero"); // Print it in a nicer way
				}
				break;
			}
			case "sqrt": {
				System.out.println("Please enter the radicand");
				
				double radicand = getParsedDouble(keyboard.nextLine());
				if (radicand <= 0) {
					// Any value <= 0 entered into AdvancedCalculator_Rodriguez::squareRoot()
					// freezes the program for some reason. So, prevent that from happening.
					exitWithMessage("Radicand must be greater than zero");
				}
				System.out.println("Result: " + advancedCalc.squareRoot(radicand));
				break;
			}
			default:
				exitWithMessage("Operation is not supported");
		}
	}
	
	/**
	 * Runs the calculator until the user decides to exit.
	 * 
	 * @param args Program arguments from the console
	 */
	public static void main(String[] args) {
		while (!input.equalsIgnoreCase("n")) {
			runCalculator();
			System.out.print("\nAgain? (Y/N) ");
			input = keyboard.nextLine();
			System.out.println();
		}
	}
}