// Name: Christian Rodriguez
// Date: 02/19/2020
// Desc: In-class exercise #4, working with interfaces and abstract classes

public class TestAnimals {
    public static void main(String[] args) {
        // Declarations
        Fish   d = new Fish();
        Cat    c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Lion();
        Pet    p = new Cat();
        
        // Fish d
        System.out.println("My fish's name is " + d.getName());
        d.setName("Shredder");
        System.out.println("Now my fish's name is " + d.getName());
        d.eat();
        d.play();
        d.walk();
        System.out.println();
        
        // Cat c
        System.out.println("This cat's name is " + c.getName());
        c.setName("McFlenders");
        System.out.println("Now this cat's name is " + c.getName());
        c.eat();
        c.play();
        c.walk();
        System.out.println();
        
        // Animal a
        System.out.println("This fish does not have a name");
        a.eat();
        a.walk();
        System.out.println();
        
        // Animal e
        System.out.println("This lion does not have a name");
        e.eat();
        e.walk();
        System.out.println();
        
        // Pet p
        System.out.println("My pet cat's name is " + p.getName());
        p.setName("Bagingi");
        System.out.println("Now my pet cat's name is " + p.getName());
        p.play();
        
        /*
        7. Now let’s say we want to add a new method to Pets. 
            a. Should we do this?
                It's up to the person.
            b. What is going to happen if we do?
                You will have to override the method in each class that implements the interface.
            c. How can we get around any issue?
                By overriding that method in each class that implements the interface.
        */
    }
}
