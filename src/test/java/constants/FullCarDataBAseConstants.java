package constants;

import model.Car;
import model.FullCar;

import java.util.List;

public class FullCarDataBAseConstants {
    public static final FullCar car1 = new FullCar(1, "Supra", "Toyota", MotorsDataBaseConstants.motor1);
    public static final FullCar car2 = new FullCar(2, "M3", "BMW",MotorsDataBaseConstants.motor2);
    public static final FullCar car3 = new FullCar(3, "Logan", "Dacia",MotorsDataBaseConstants.motor3);
    public static final FullCar car4 = new FullCar(4, "Maclaren", "Mercedes",MotorsDataBaseConstants.motor4);
    public static final FullCar car5 = new FullCar(5, "370z", "Nissan",MotorsDataBaseConstants.motor5);
    public static final FullCar car6 = new FullCar(6, "Prius", "Toyota",MotorsDataBaseConstants.motor6);

    public static final List<FullCar> cars = List.of(car1,
                                                     car2,
                                                     car3,
                                                     car4,
                                                     car5,
                                                     car6);
}
