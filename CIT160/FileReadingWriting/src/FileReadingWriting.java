
// Wildcard import for input/output
// NOT the same as "using namespace std;" in C++!
import java.io.*;
import java.util.Scanner;

public class FileReadingWriting {
    public static void main(String[] args) throws IOException {
        /** Regular writing (overwrite) **/
        PrintWriter outFile = new PrintWriter("text.txt");
        
        for (int i = 0; i < 5; ++i)
            outFile.println(i * 10);
        
        outFile.close();
        
        /** Appending to a file **/
        // FileWriter allows us to specify append parameter, but does not
        // have the same methods to write to the file that PrintWriter has
        FileWriter fw = new FileWriter("test.txt", true);
        PrintWriter outFile1 = new PrintWriter(fw);
        for (int i = 0; i < 5; ++i)
            outFile1.println(i * 10);
        outFile1.println("I just appended af");
        outFile1.close();
        
        /** Reading from a file **/
        // FileWriter is used for writing, File is used for reading
        File reader = new File("test.txt");
        
        // Scanner is used to read from file like it does for console input
        Scanner inFile = new Scanner(reader);
        
        // Check if there are any more lines in the file
        while (inFile.hasNext()) {
            // Check for int
            if (inFile.hasNextInt()) {
                System.out.println(inFile.nextInt());
                inFile.nextLine(); // Skip over newline character
            } else {
                System.out.println(inFile.nextLine());
            }
        }
    }
}
