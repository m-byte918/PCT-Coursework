// Author: Christian Rodriguez
// Date: 9-10-2019
// Purpose: In-class exercise 3 (working with strings)

public class Ice03 {
    public static void main(String[] args) {
        String hi = "Hi";
        String hw = "Hello World";
        
        System.out.println( "    String     | length() | indexOf('o') | toLowerCase() | toUpperCase()");
        System.out.println( "---------------|----------|--------------|---------------|---------------");
        System.out.printf("     \"%s\"      |    %d     |      %2d      |      %2s       |      %2s\n", hi, hi.length(), hi.indexOf('o'), hi.toLowerCase(), hi.toUpperCase());
        System.out.printf(" \"%s\" |    %2d    |       %d      |  %s  |  %s\n\n"                      , hw, hw.length(), hw.indexOf('o'), hw.toLowerCase(), hw.toUpperCase());
        
        // Search for index of next "o" starting from just after the first index of "o"
        int index = hw.indexOf("o", hw.indexOf("o") + 1);
        System.out.printf("Index of next \"o\" in \"Hello World\" string is %d\n", index);
        
        // Concatenate `hi` string with the substring of `hw` starting at the index of its "W" character
        String hiWorld = hi.concat(hw.substring(hw.indexOf("W")));
        System.out.printf("Concatenated string: %s\n", hiWorld);
    }
}
