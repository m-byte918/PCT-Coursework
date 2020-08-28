// Name: Christian Rodriguez
// Date: 02/19/2020
// Desc: In-class exercise #4, working with interfaces and abstract classes

public abstract class Animal {
    // Attributes
    protected int legs = 0;
    
    // Constructors
    protected Animal(int legs) {
        this.legs = legs;
    }
    
    // Abstractions
    public abstract void walk();
    
    // Other methods
    public abstract void eat();
}
