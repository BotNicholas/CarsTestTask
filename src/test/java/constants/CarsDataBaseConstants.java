package constants;

import model.Car;

import java.util.List;

public class CarsDataBaseConstants {
    public static final Car car1 = new Car(1, "Supra", "Toyota", 1);
    public static final Car car2 = new Car(2, "M3", "BMW",2);
    public static final Car car3 = new Car(3, "Logan", "Dacia",3);
    public static final Car car4 = new Car(4, "Maclaren", "Mercedes",4);
    public static final Car car5 = new Car(5, "370z", "Nissan",5);
    public static final Car car6 = new Car(6, "Prius", "Toyota",6);

    public static final List<Car> cars = List.of(car1,
                                                 car2,
                                                 car3,
                                                 car4,
                                                 car5,
                                                 car6);
}
