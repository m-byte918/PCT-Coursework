// Name: Christian Rodriguez
// Date: 02/12/2020
// Desc: In-class Exercise #3 (part 1), working with inheritance, overriding and overloading

public class InheritanceExample {
    public static void main(String[] args) {
        Student student = new Student(
            "Bagingi", 
            "Lesbian Dance Theory", 
            "Senior", 
            "Harvard University",
            46,
            666, 
            "Australian",
            4.1f
        );
        Human human = new Human(5.11f, "Ralphwaldo", "American", 2, 14);
        Superhero superhero = new Superhero(7.0f, 136, 435, "Spaghetti Man", 7);
        
        Mammal mammal = new Mammal();
        mammal.setAge(85);
        mammal.setWeight(2000);
        
        System.out.println(student.toString()   + '\n');
        System.out.println(human.toString()     + '\n');
        System.out.println(superhero.toString() + '\n');
        System.out.println(mammal.toString());
    }
}
