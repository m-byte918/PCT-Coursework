// Name: Christian Rodriguez
// Date: 09/26/2019
// Desc: In class exercise #6, creating UML diagrams and converting them to code

public class Widgets {
    String color = "";
    String shape = "";
    int  minutes = 0;

    Widgets(String widgetColor, String widgetShape, int productionTimeMinutes) {
        color   = widgetColor;
        shape   = widgetShape;
        minutes = productionTimeMinutes;
    }
    /***** Setters *****/
    public void setColor(String newColor) {
        color = newColor;
    }
    public void setShape(String newShape) {
        shape = newShape;
    }
    public void setMinutes(int productionTimeMinutes) {
        minutes = productionTimeMinutes;
    }
    /***** Getters *****/
    public String getColor() {
        return color;
    }
    public String getShape() {
        return shape;
    }
    public int getMinutes() {
        return minutes;
    }
    /***** Other methods *****/
    public int numDays(int amountOrdered) {
        double totalMinutes  = minutes * amountOrdered;
        double totalHours    = totalMinutes / 60;
        double totalWorkDays = totalHours / 16;
        return (int)Math.ceil(totalWorkDays);
    }
}
