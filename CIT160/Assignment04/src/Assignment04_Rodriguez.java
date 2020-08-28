// Name: Christian Rodriguez
// Date: 11/07/2019
// Desc: Programming assignment #4, review of classes and objects

public class Assignment04_Rodriguez {
    public static void main(String[] args) {
        Coin coin = new Coin();
        
        System.out.println("The initial side facing up is " + coin.getSideUp() + "\n");
        
        int headsAmount = 0;
        int tailsAmount = 0;
        for (int i = 0; i < 20; ++i) {
            coin.toss();
            if (coin.getSideUp() == "heads") {
                ++headsAmount;
                System.out.println("The side facing up heads!");
            } else {
                ++tailsAmount;
                System.out.println("The side facing up tails!");
            }
        }
        System.out.println("\nAmount of times coin landed on heads: " + headsAmount);
        System.out.println(  "Amount of times coin landed on tails: " + tailsAmount);
    }
}
