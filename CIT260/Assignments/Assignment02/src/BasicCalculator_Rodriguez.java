// Name: Christian Rodriguez
// Date: 02/28/2020
// Desc: Programming assignment 02 - using abstract classes and interfaces

/**
 * Implements basic operations provided by the Arithmetic_Rodriguez interface
 * 
 * @author Christian Rodriguez
 * @version 1.0
 */
public class BasicCalculator_Rodriguez implements Arithmetic_Rodriguez {
	// Javadoc tool "inherits" comments from Arithmetic_Rodriguez interface so there is no need to rewrite them here

	@Override
	public double add(double... nums) {
		double result = 0.0;
		for (double d : nums)
			result += d;
		return result;
	}
	@Override
	public int add(int... nums) {
		int result = 0;
		for (int i : nums)
			result += i;
		return result;
	}
	@Override
	public double subtract(double... nums) {
		double result = nums[0];
		for (int i = 1; i < nums.length; ++i)
			result -= nums[i];
		return result;
	}
	@Override
	public int subtract(int... nums) {
		int result = nums[0];
		for (int i = 1; i < nums.length; ++i)
			result -= nums[i];
		return result;
	}
	@Override
	public double multiply(double... nums) {
		double result = nums[0];
		for (int i = 1; i < nums.length; ++i)
			result *= nums[i];
		return result;
	}
	@Override
	public int multiply(int... nums) {
		int result = nums[0];
		for (int i = 1; i < nums.length; ++i)
			result *= nums[i];
		return result;
	}
	@Override
	public double divide(double numerator, double denominator) throws ArithmeticException {
		if (denominator == 0.0)
			throw new ArithmeticException();
		return numerator / denominator;
	}
	@Override
	public double divide(int numerator, int denominator) throws ArithmeticException {
		return divide((double)numerator, (double)denominator); // Returns a double anyway, so why not
	}
}
