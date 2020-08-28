// Name: Christian Rodriguez
// Date: 02/28/2020
// Desc: Programming assignment 02 - using abstract classes and interfaces

/**
 * Extends capability of the BasicCalculator_Rodriguez class
 * 
 * @author Christian Rodriguez
 * @version 1.0
 */
public class AdvancedCalculator_Rodriguez extends BasicCalculator_Rodriguez {
	/**
	 * Returns the modulus of the provided numerator and denominator
	 * 
	 * @param  numerator           Numerator of the division
	 * @param  denominator         Denominator of the division
	 * @return                     The result of the modulus
	 * @throws ArithmeticException If a division by zero occurs
	 */
	public int mod(int numerator, int denominator) throws ArithmeticException {
		if (denominator == 0)
			throw new ArithmeticException();
		return (int)(numerator % denominator);
	}

	/**
	 * Returns the square root of the provided number
	 * 
	 * @param num Radicand to get the square root of
	 * @return    The square root of the provided number
	 */
	public double squareRoot(double num) {
		double sr = num / 2.0;
		double temp = 0.0;
		do {
			temp = sr;
			sr = (temp + (num / temp)) / 2.0;
		} while ((temp - sr) != 0.0);
		return sr;
	}
}
