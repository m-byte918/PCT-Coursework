// Name: Christian Rodriguez
// Date: 01/27/2020
// Desc: In class exercise #1a, working with 2d arrays

public class ICE1a {
    public static void main(String[] args) {
        // Initialize using initializer list
        int[][] grades = {
            { 1, 100, 85, 91, 75, 82 },
            { 2, 81,  75, 68, 92, 87 },
            { 3, 99,  71, 75, 84, 91 },
            { 0, 97,  91, 68, 72, 83 }
        };
        for (int i = 0; i < grades.length; ++i) {
            float average = 0.0f; // For precision
            for (int j = 0; j < grades[i].length; ++j)
                average += grades[i][j];
            System.out.println("The average of test #" + (i + 1) + " is " + (average / grades[i].length));
        }
    }
}
