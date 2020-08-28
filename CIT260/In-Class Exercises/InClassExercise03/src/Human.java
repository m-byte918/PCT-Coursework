// Name: Christian Rodriguez
// Date: 02/12/2020
// Desc: In-class Exercise #3 (part 1), working with inheritance, overriding and overloading

public class Human extends Mammal {
    protected float  _height      = 0.0f;
    protected String _name        = "";
    protected String _nationality = "";
    
    // Constructors
    public Human() {
    }
    public Human(float height, String name, String nationality, int age, int weight) {
        super(age, weight);
        _height      = height;
        _name        = name;
        _nationality = nationality;
    }
    
    // Setters
    public void setHeight(float height) {
        _height = height;
    }
    public void setName(String name) {
        _name = name;
    }
    public void setNationality(String nationality) {
        _nationality = nationality;
    }
    
    // Getters
    public float getHeight() {
        return _height;
    }
    public String getName() {
        return _name;
    }
    public String getNationality() {
        return _nationality;
    }
    
    // Overrides
    @Override
    public String toString() {
        return "Human:\n"
                + "\tHeight: " + _height + "\n"
                + "\tName: " + _name + "\n"
                + "\tNationality: " + _nationality + "\n"
                + "\tAge: " + super._age + "\n"
                + "\tWeight: " + super._weight;
    }
}
