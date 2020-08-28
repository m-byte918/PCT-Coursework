import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a number: ");

		long num = keyboard.nextInt();
		System.out.println(num + "! = " + factorial(num));
	}
	public static long factorial(long n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}
}
