// Name: Christian Rodriguez
// Date: 02/12/2020
// Desc: In-class Exercise #3 (part 1), working with inheritance, overriding and overloading

public class Mammal {
    protected int _age    = 0;
    protected int _weight = 0;
    
    // Constructors
    public Mammal() {
    }
    public Mammal(int age, int weight) {
        _age = age;
        _weight = weight;
    }
    
    // Setters
    public void setAge(int age) {
        _age = age;
    }
    public void setWeight(int weight) {
        _weight = weight;
    }
    
    // Getters
    public int getAge() {
        return _age;
    }
    public int getWeight() {
        return _weight;
    }
    
    // Overrides
    @Override
    public String toString() {
        return "The age of this mammal is " + _age + " and weight is " + _weight + "lbs";
    }
}
