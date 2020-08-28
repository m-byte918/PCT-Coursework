// Name: Christian Rodriguez
// Date: 11/07/2019
// Desc: Coin class part of programming assignment #4, review of classes and objects

import java.util.concurrent.ThreadLocalRandom; // true randomness

public class Coin {
    private String sideUp;
    
    public Coin() {
        toss();
    }
    public void toss() {
        sideUp = ThreadLocalRandom.current().nextInt(0, 1+1) == 0 ? "heads" : "tails";
    }
    public String getSideUp() {
        return sideUp;
    }
}
