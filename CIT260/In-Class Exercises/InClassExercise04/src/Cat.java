// Name: Christian Rodriguez
// Date: 02/19/2020
// Desc: In-class exercise #4, working with interfaces and abstract classes

public class Cat extends Animal implements Pet {
    private String name = null;
    private static final int LEGS = 4;
    
    // Constructors
    public Cat(String name) {
        super(LEGS);
        this.name = name;
    }
    public Cat() {
        this("");
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
        System.out.println("The cat plays with a ball of yarn");
    }
    
    // Overrides from Animal 
    @Override
    public void eat() {
        System.out.println("The cat eats a dead bird");
    }
    @Override
    public void walk() {
        System.out.println("The cat walks on " + super.legs + " legs");
    }
}
