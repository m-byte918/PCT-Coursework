// Name: Christian Rodriguez
// Date: 02/28/2020
// Desc: Programming assignment 02 - using abstract classes and interfaces

/**
 * Provides framework to calculators for basic operations
 * 
 * @author Christian Rodriguez
 * @version 1.0
 */
public interface Arithmetic_Rodriguez {
	// Methods within interfaces are abstract by default so I will not use the keyword (also i'm lazy)
	
	/**
	 * Returns the sum of provided doubles
	 * 
	 * @param nums Numbers to be added
	 * @return     The sum of all numbers provided
	 */
	public double add(double... nums);

	/**
	 * Returns the sum of provided integers
	 * 
	 * @param nums Numbers to be added
	 * @return     The sum of all numbers provided
	 */
	public int    add(int...    nums);

	/**
	 * Returns the difference of all provided doubles
	 * 
	 * @param nums Numbers to be subtracted
	 * @return     The difference of all numbers provided
	 */
	public double subtract(double... nums);
	
	/**
	 * Returns the difference of all provided integers
	 * 
	 * @param nums Numbers to be subtracted
	 * @return     The difference of all numbers provided
	 */
	public int    subtract(int...    nums);

	/**
	 * Returns the product of all provided doubles
	 * 
	 * @param nums Numbers to be multiplied
	 * @return     The product of all numbers provided
	 */
	public double multiply(double... nums);
	
	/**
	 * Returns the product of all provided integers
	 * 
	 * @param nums Numbers to be multiplied
	 * @return     The product of all numbers provided
	 */
	public int    multiply(int...    nums);

	/**
	 * Returns the quotient of the provided numerator and denominator
	 * 
	 * @param numerator            Numerator of the division
	 * @param denominator          Denominator of the division
	 * @return            		   The result of the division
	 * @throws ArithmeticException If a division by zero occurs
	 */
	public double divide(double numerator, double denominator) throws ArithmeticException;
	
	/**
	 * Returns the quotient of the provided numerator and denominator
	 * 
	 * @param numerator            Numerator of the division
	 * @param denominator          Denominator of the division
	 * @return            		   The result of the division
	 * @throws ArithmeticException If a division by zero occurs
	 */
	public double divide(int    numerator, int    denominator) throws ArithmeticException;
}
