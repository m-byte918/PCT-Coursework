// Name: Christian Rodriguez
// Date: 02/19/2020
// Desc: In-class exercise #4, working with interfaces and abstract classes

public class Fish extends Animal implements Pet {
    private String name = null;
    private static final int LEGS = 0;
    
    // Constructors
    public Fish() {
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
        System.out.println("The fish plays with literally nothing");
    }

    // Overrides from Animal
    @Override
    public void walk() {
        System.out.println("The fish cannot walk because it has " + super.legs + " legs");
    }
    @Override
    public void eat() {
        System.out.println("The fish eats the fish children");
    }
}
