// Christian Rodriguez
// 9/3/2019
// Simple program to average grades of three students

import java.util.Scanner;

public class Grader {
    
    public static void main(String[] args) {
        int[] grades = {0, 0, 0};
        Scanner keyboard = new Scanner(System.in);
        
        for (int i = 0; i < 3; ++i) {
            System.out.printf("Enter grade %d: ", i + 1);
            grades[i] = keyboard.nextInt();
            keyboard.nextLine();
        }
        float gradeAvg = (grades[0] + grades[1] + grades[2]) / grades.length;
        
        System.out.println("Score average: " + gradeAvg);
        keyboard.close();
    }
}