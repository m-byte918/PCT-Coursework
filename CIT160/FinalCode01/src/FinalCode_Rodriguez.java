
import java.io.*;

public class FinalCode_Rodriguez {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("ITDepartment.txt"));
        String[][] info = {
            {
                "Miller, Jacob",
                "ATHS/E221",
                "jmiller3@pct.edu"
            },
            {
                "Singh, Mahendra",
                "ATHS/E223B",
                "msingh@pct.edu"
            },
            {
                "Wood, Anita",
                "ATHS/E224",
                "awood@pct.edu"
            }
        };
        for (int i = 0; i < info.length; ++i) {
            for (int j = 0; j < info[i].length; ++j)
                writer.println(info[i][j]);
            writer.println();
        }
        writer.close();
    }
}
