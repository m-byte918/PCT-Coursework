// Name: Christian Rodriguez
// Date: 02/19/2020
// Desc: In-class exercise #4, working with interfaces and abstract classes

public class Dog extends Animal implements Pet {
    private String name = null;
    private static final int LEGS = 4;
    
    // Constructors
    public Dog() {
        super(LEGS);
        name = "";
    }
    
    // Overrides from Pet
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void play() {
        
    }
    // Overrides from Animal
    @Override
    public void walk() {
        
    }
    @Override
    public void eat() {
        System.out.println("Dog eated da doggofoode");
    }
}
