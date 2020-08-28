// Name: Christian Rodriguez
// Date: 09/19/2019
// Purpose: Learn how to create classes and objects (in class exercise #5)

public class MyMathClass {
    int numOne;
    int numTwo;
    public MyMathClass() {
        numOne = 0;
        numTwo = 0;
    }
    public void setNumOne(int newNumOne) {
        numOne = newNumOne;
    }
    public void setNumTwo(int newNumTwo) {
        numTwo = newNumTwo;
    }
    public int getNumOne() {
        return numOne;
    }
    public int getNumTwo() {
        return numTwo;
    }
    public void add() {
        System.out.println("The sum of numOne and numTwo is: " + (numOne + numTwo));
    }
    public void subtract() {
        System.out.println("The difference of numOne and numTwo is: " + (numOne - numTwo));
    }
    public int multiply() {
        return numOne * numTwo;
    }
}
