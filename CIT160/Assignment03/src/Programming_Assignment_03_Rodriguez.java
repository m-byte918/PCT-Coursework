// Christian Rodriguez
// 10/25/2019
// Programming assignment #3, working with lööps

import java.util.concurrent.ThreadLocalRandom; // true randomness

public class Programming_Assignment_03_Rodriguez {
    public static int rand1To13() {
        return ThreadLocalRandom.current().nextInt(1, 13 + 1);
    }
    public static void main(String[] args) {
        System.out.println("Get ready for a game of WAR!");
        int play = 1;
        int p1CardAmount = 26;
        int p2CardAmount = 26;
        int warCardAmount = 0;
        
        while (p1CardAmount > 0 && p2CardAmount > 0) {
            // Regular play
            int p1CardScore = rand1To13();
            int p2CardScore = rand1To13();
    
            System.out.printf("Play %d -- Player one: %d Player two: %d\n", play++, p1CardScore, p2CardScore);

            if (p1CardScore > p2CardScore) {
                System.out.println("Player one wins");
                ++p1CardAmount;
                --p2CardAmount;
                // Player one won the war, they now gain all cards placed in previous
                // turns that resulted in war and player two loses the same amount of cards
                if (warCardAmount > 0) {
                    p1CardAmount += warCardAmount;
                    p2CardAmount -= warCardAmount;
                    warCardAmount = 0;
                }
            } else if (p1CardScore < p2CardScore) {
                System.out.println("Player two wins");
                --p1CardAmount;
                ++p2CardAmount;
                // Player two won the war, they now gain all cards placed in previous
                // turns that resulted in war and player one loses the same amount of cards
                if (warCardAmount > 0) {
                    p1CardAmount -= warCardAmount;
                    p2CardAmount += warCardAmount;
                    warCardAmount = 0;
                }
            } else {
                // War! Each player draws cards and places them into a pile 
                // until the scores of the latest drawn cards do not match
                System.out.println("War!");
                warCardAmount += 2;
            }
            // Amount of cards cannot be less than 0
            p1CardAmount = Math.max(0, p1CardAmount);
            p2CardAmount = Math.max(0, p2CardAmount);
            System.out.printf("Scores -- Player one: %d Player two: %d\n\n", p1CardAmount, p2CardAmount);
        }
        System.out.println("******** Player " + (p1CardAmount == 0 ? 2 : 1) + " Wins ********");
    }
}
