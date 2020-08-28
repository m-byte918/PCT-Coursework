// Name: Christian Rodriguez
// Date: 10/31/2019
// Desc: In class exercise #9, reading and writing to files

import java.io.*;
import java.util.Scanner;

public class Ice09_Rodriguez {
    public static void main(String[] args) throws IOException {
        // Read starting balance from Balance.txt
        File balanceReader  = new File("Balance.txt");
        Scanner balanceFile = new Scanner(balanceReader);
        
        // Assuming Balance.txt contains at least one value (500.00) and that no
        // error checking should be done (unless instructions specify otherwise)
        float balance = balanceFile.nextFloat();
        System.out.printf("The starting balance is $%.2f\n", balance);
        
        // Open Deposits.txt for reading
        float   depositTotal  = 0.0f;
        File    depositReader = new File("Deposits.txt");
        Scanner depositsFile  = new Scanner(depositReader);

        // Add deposits to depositTotal until there are no more floats
        while (depositsFile.hasNextFloat())
            depositTotal += depositsFile.nextFloat();
        
        balance += depositTotal; // Add all deposits to balance
        depositsFile.close();    // depositsFile is no longer needed
        
        // Open Withdrawals.txt for reading
        File withdrawalReader   = new File("Withdrawals.txt");
        Scanner withdrawalsFile = new Scanner(withdrawalReader);
        
        // Subtract withdrawals from balance until there are no more floats
        while (withdrawalsFile.hasNextFloat())
            balance -= withdrawalsFile.nextFloat();
        
        withdrawalsFile.close(); // withdrawalsFile is no longer needed
        
        // Correct floating point rounding error and print it
        balance = Math.round(balance * 100.0f) / 100.0f;
        System.out.printf("The ending balance is $%.2f\n", balance);
        
        // Assuming starting value in Balance.txt must be overwritten with
        // new value of balance (unless instructions specify otherwise)
        PrintWriter writer = new PrintWriter(balanceReader);
        writer.print(balance);
        
        // balanceFile and writer are no longer needed, i'm not sure which
        // close() will close the file first so I will just close both lol
        balanceFile.close();
        writer.close();
    }
}
