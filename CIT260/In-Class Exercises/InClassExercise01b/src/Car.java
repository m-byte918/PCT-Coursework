// Name: Christian Rodriguez
// Date: 01/27/2020
// Desc: In class exercise #1b, working with ArrayLists

public class Car {
    int    year  = 0;
    String make  = "";
    String model = "";
    
    // Constructors
    public Car() {
    }
    public Car(String _make, String _model, int _year) {
        make  = _make;
        model = _model;
        year  = _year;
    }
    
    // Setters
    public void setYear(int _year) {
        year = _year;
    }
    public void setMake(String _make) {
        make = _make;
    }
    public void setModel(String _model) {
        model = _model;
    }
    
    // Getters
    public int getYear() {
        return year;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
}
