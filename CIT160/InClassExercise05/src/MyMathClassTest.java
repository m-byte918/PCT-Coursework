// Name: Christian Rodriguez
// Date: 9/17/2019
// Desc: In Class Exercise #5, working with objects and classes (epicly)

public class MyMathClassTest {
    public static void main(String[] args) {
        MyMathClass obj1 = new MyMathClass();
        System.out.println(obj1.getNumOne());
        System.out.println(obj1.getNumTwo());
        obj1.setNumOne(5);
        obj1.setNumTwo(10);
        System.out.println(obj1.getNumOne());
        System.out.println(obj1.getNumTwo());
        
        MyMathClass obj2 = new MyMathClass();
        obj2.setNumOne(9);
        obj2.setNumTwo(3);
        System.out.println(obj2.getNumOne());
        System.out.println(obj2.getNumTwo());
        
        obj1.add();
        obj2.subtract();
        int product = obj1.multiply();
        System.out.println("The product is: " + product);
    }
}
