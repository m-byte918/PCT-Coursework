// Christian Rodriguez
// 8/27/2019
// Simple hello world program

// Every program starts with a class
public class HelloWorld {
    
    // That class must have a main function
    public static void main(String[] args) {
        System.out.println("Yo whats up guys its ya boi\n\tChristian Rodriguez\n");
        
        byte test = 1;
        System.out.println(test);
        
        // Concatenation
        System.out.println("String " + "concatenation");
        System.out.println("I have " + 5 + " apples");
        System.out.println("Quotes \"inside of\" a string");
        
        // printf
        double particles = 41.9;
        System.out.printf("The amount of particles I have is: %6.1f\n", particles);
        
        double universeSize = 92846749284.694586;
        System.out.printf("The size of the universe is: %,6f\n", universeSize);
        
        String name = "Christian";
        System.out.printf("My name is: %10s", name);
    }
}