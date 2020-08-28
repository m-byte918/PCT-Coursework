// Name: Christian Rodriguez
// Date: 9/17/2019
// Desc: Programming Assignment #1

public class Rodriguez_ProgrammingAssignment01 {
    public static float toCelsius(int fahrenheit) {
        return 5 / 9 * (fahrenheit - 32);
    }
    public static float toFahrenheit(int celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static void main(String[] args) {
        
        // PART I. TEMPERATURE CONVERSION
       
        //***** 1. declare any constants here
        final int WATER_FREEZING_POINT_FAHRENHEIT = 32;
        
        //***** 2. declare temperature in Fahrenheit as an int 
        int fahrenheit = WATER_FREEZING_POINT_FAHRENHEIT;
        
        //***** 3. calculate equivalent Celsius temperature 
        int celsius = (int)toCelsius(fahrenheit);
        
        //***** 4. output the temperature in Celsius
        System.out.println("Freezing point of water in celsius: " + celsius);
                                                  
        //***** 5. convert Celsius temperature back to Fahrenheit
        int fahrenheit2 = (int)toFahrenheit(celsius);
                
        //***** 6. output Fahrenheit temperature to check correctness
        System.out.println("Freezing point of water in fahrenheit: " + fahrenheit2);
       
        // PART II. COFFEE CONSUMPTION
        
        int totalCustomers           = 17000;
        int amountPrefersMocha       = (int)(totalCustomers * (38.0f / 100.0f)); // 38%
        int amountPurchasedOneOrMore = (int)(totalCustomers * (62.0f / 100.0f)); // 62%
        
        System.out.println("Amount of customers that prefer mocha-flavored coffee drinks: "          + amountPrefersMocha);
        System.out.println("Amount of customers that purchased one or more coffee drinks per week: " + amountPurchasedOneOrMore);
       
        // PART III. YOUR INITIALS PATTERN
        
        System.out.println("  /$$$$$$  /$$                 /$$             /$$     /$$                           /$$$$$$$                  /$$           /$$");
        System.out.println(" /$$__  $$| $$                |__/            | $$    |__/                          | $$__  $$                | $$          |__/"); 
        System.out.println("| $$  \\__/| $$$$$$$   /$$$$$$  /$$  /$$$$$$$ /$$$$$$   /$$  /$$$$$$  /$$$$$$$       | $$  \\ $$  /$$$$$$   /$$$$$$$  /$$$$$$  /$$  /$$$$$$  /$$   /$$  /$$$$$$  /$$$$$$$$");
        System.out.println("| $$      | $$__  $$ /$$__  $$| $$ /$$_____/|_  $$_/  | $$ |____  $$| $$__  $$      | $$$$$$$/ /$$__  $$ /$$__  $$ /$$__  $$| $$ /$$__  $$| $$  | $$ /$$__  $$|____ /$$/");
        System.out.println("| $$      | $$  \\ $$| $$  \\__/| $$|  $$$$$$   | $$    | $$  /$$$$$$$| $$  \\ $$      | $$__  $$| $$  \\ $$| $$  | $$| $$  \\__/| $$| $$  \\ $$| $$  | $$| $$$$$$$$   /$$$$/");
        System.out.println("| $$    $$| $$  | $$| $$      | $$ \\____  $$  | $$ /$$| $$ /$$__  $$| $$  | $$      | $$  \\ $$| $$  | $$| $$  | $$| $$      | $$| $$  | $$| $$  | $$| $$_____/  /$$__/"); 
        System.out.println("|  $$$$$$/| $$  | $$| $$      | $$ /$$$$$$$/  |  $$$$/| $$|  $$$$$$$| $$  | $$      | $$  | $$|  $$$$$$/|  $$$$$$$| $$      | $$|  $$$$$$$|  $$$$$$/|  $$$$$$$ /$$$$$$$$");
        System.out.println(" \\______/ |__/  |__/|__/      |__/|_______/    \\___/  |__/ \\_______/|__/  |__/      |__/  |__/ \\______/  \\_______/|__/      |__/ \\____  $$ \\______/  \\_______/|________/");
        System.out.println("                                                                                                                                  /$$  \\ $$");                         
        System.out.println("                                                                                                                                 |  $$$$$$/"); 
        System.out.println("                                                                                                                                  \\______/"); 
    }
} 