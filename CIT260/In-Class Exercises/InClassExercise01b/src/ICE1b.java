// Name: Christian Rodriguez
// Date: 01/27/2020
// Desc: In class exercise #1b, working with ArrayLists

import java.util.ArrayList;

public class ICE1b {
    public static void displayInventory(ArrayList<Car> carList) {
        System.out.println("There are currently " + carList.size() + " cars on hand:\n");
        for (int i = 0; i < carList.size(); ++i) {
            Car car = carList.get(i);
            System.out.printf("%d.  %d %s %s\n", i + 1, car.getYear(), car.getMake(), car.getModel());
        }
        System.out.println(); // Padding
    }
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<Car>();

        carList.add(new Car("Chevrolet", "Corvette", 1957)); 
        carList.add(new Car("Pierce", "Silver Arrow", 1933)); 
        carList.add(new Car("Jaguar", "xk120", 1948)); 
        carList.add(new Car("Ford", "Thunderbird", 1957)); 
        carList.add(new Car("Pontiac", "Firebird Trans Am", 1978)); 
        carList.add(new Car("Chevrolet", "Camaro", 1969)); 
        carList.add(new Car("DeLorean", "DMC 12", 1981)); 
        carList.add(new Car("Tesla", "Model X", 2019)); 
        carList.add(new Car("Cadillac", "Eldorado", 1959)); 
        
        displayInventory(carList); // Display initial list
    
        carList.remove(7); // Remove 2019 Tesla Model X

        displayInventory(carList); // Display updated list
    }
}
