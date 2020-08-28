// Name: Christian Rodriguez
// Date: 09/26/2019
// Desc: Review user defined classes and UML

public class CashRegister {
    int cashOnHand = 0;
    
    CashRegister() {
        cashOnHand = 500;
    }
    CashRegister(int cashAmount) {
        cashOnHand = cashAmount < 0 ? 500 : cashAmount;
    }
    int getCashOnHand() {
        return cashOnHand;
    }
    void acceptAmount(int amount) {
        cashOnHand += amount;
    }
}
