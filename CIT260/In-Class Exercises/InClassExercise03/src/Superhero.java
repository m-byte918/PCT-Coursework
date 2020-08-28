// Name: Christian Rodriguez
// Date: 02/12/2020
// Desc: In-class Exercise #3 (part 1), working with inheritance, overriding and overloading

public class Superhero extends Human {
    private int    _agility       = 0;
    
    // Constructors
    public Superhero(float height, int weight, int age, String superHeroName, int agility) {
        super(height, superHeroName, "", age, weight);
        _agility = agility;
    }
    
    // Setters
    public void setAgility(int agility) {
        _agility = agility;
    }
    
    // Getters
    public int getAgility() {
        return _agility;
    }
    
    // Overrides
    @Override
    public String toString() {
        return "Superhero:\n"
                + "\tSuperhero name: " + _name + "\n"
                + "\tAgility: " + _agility + "\n"
                + "\tHeight: " + super._height;
    }
    @Override
    public void setName(String name) {
        super.setName(name + " " + super.getName());
    }
}
