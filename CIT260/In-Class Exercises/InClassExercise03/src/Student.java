// Name: Christian Rodriguez
// Date: 02/12/2020
// Desc: In-class Exercise #3 (part 1), working with inheritance, overriding and overloading

public class Student extends Human {
    private String _schoolName  = "";
    private String _major       = "";
    private String _yearOfStudy = "";
    
    // Constructors
    public Student(String name, String major, String yearOfStudy, String school, int age, int weight, String nationality, float height) {
        super(height, name, nationality, age, weight);
        _schoolName  = school;
        _major       = major;
        _yearOfStudy = yearOfStudy;
    }
    
    // Setters
    public void setSchoolName(String schoolName) {
        _schoolName = schoolName;
    }
    public void setMajor(String major) {
        _major = major;
    }
    public void setYearOfStudy(String yearOfStudy) {
        _yearOfStudy = yearOfStudy;
    }
    
    // Getters
    public String getSchoolName() {
        return _schoolName;
    }
    public String getMajor() {
        return _major;
    }
    public String getYearOfStudy() {
        return _yearOfStudy;
    }
    
    // Overrides
    @Override
    public String toString() {
        return "Student:\n"
                + "\tName: " + super._name + "\n"
                + "\tMajor: " + _major + "\n"
                + "\tYear of Study: " + _yearOfStudy + "\n"
                + "\tSchool: " + _schoolName + "\n"
                + "\tNationality: " + _nationality;
    }
}
