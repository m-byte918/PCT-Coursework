// Name: Christian Rodriguez
// Date: 10/10/2019
// Desc: In class exercise #7, Working with if statements

import java.util.Scanner;

public class Ice07_Rodriguez {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        float a, b = 0.0f;
        
        System.out.print("First number: ");
        a = (int)(keyboard.nextFloat() + 0.5f);
        
        System.out.print("Second number: ");
        b = (int)(keyboard.nextFloat() + 0.5f);

        if (a == b)
            System.out.println("They are the same when rounded");
        else
            System.out.println("The larger number is: " + (int)((a > b) ? a : b));
    }
}
