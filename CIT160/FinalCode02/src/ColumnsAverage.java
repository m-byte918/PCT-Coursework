import java.io.*;
import java.util.Scanner;

public class ColumnsAverage {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner numbers = new Scanner(new File("numbers.txt"));
        int   i = 0;
        float a = 0.0f;
        float b = 0.0f;
        while (numbers.hasNextFloat()) {
            a = numbers.nextFloat();
            b = numbers.hasNextFloat() ? numbers.nextFloat() : 0.0f;
            System.out.println("Column " + (++i) + " average: " + (a + b) / 2.0f);
        }
        numbers.close();
    }
}
