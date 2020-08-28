// Name: Christian Rodriguez
// Date: 02/19/2020
// Desc: In-class exercise #4, working with interfaces and abstract classes

public class Lion extends Animal {
    private static final int LEGS = 4;

    // Constructors
    public Lion() {
        super(LEGS);
    }
    
    // Overrides from Animal
    @Override
    public void eat() {
        System.out.println("The lion eats the human flesh");
    }
    @Override
    public void walk() {
        System.out.println("The lion walks on " + super.legs + " legs");
    }
}
