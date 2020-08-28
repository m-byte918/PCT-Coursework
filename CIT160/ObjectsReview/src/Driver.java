// Name: Christian Rodriguez
// Date: 09/26/2019
// Desc: Review user defined classes and UML

public class Driver {
    public static void main(String[] args) {
        System.out.println("/********** Default Constructor **********/");

        CashRegister register = new CashRegister();
        System.out.println("Cash on hand: " + register.getCashOnHand());
        register.acceptAmount(25);
        System.out.println("Cash on hand (after acceptAmount(25)): " + register.getCashOnHand());
        
        System.out.println("\n/********** Overloaded Constructor **********/");

        register = new CashRegister(50);
        System.out.println("Cash on hand: " + register.getCashOnHand());
        register.acceptAmount(25);
        System.out.println("Cash on hand (after acceptAmount(25)): " + register.getCashOnHand());
    }
}
