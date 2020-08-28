// Name: Christian Rodriguez
// Date: 02/03/2020
// Desc: In-class exercise #2 (part 3), using the StringBuilder class

public class ICE2b {
    public static void main(String[] args) {
        // First str
        StringBuilder str = new StringBuilder();
        str.append("This is a test");
        str.append("of the append method");
        
        System.out.println(str);
        System.out.println("str's capacity: " + str.capacity());
        
        // Second str
        StringBuilder str1 = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println(str1);
        
        // Third str
        StringBuilder str1Reversed = str1.reverse();
        System.out.println(str1Reversed);
        
        str1.delete(4, 7); // Delete 'TUV' (or, 'VUT' in the reversed string)
        System.out.println(str1); // Print out result
    }
}
