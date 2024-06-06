package db;

import jakarta.enterprise.context.Dependent;
import model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class CarDataBase {
    private List<Car> cars = new ArrayList<>();
    public CarDataBase() {
        cars.add(new Car(1, "Supra", "Toyota", 1));
        cars.add(new Car(2, "M3", "BMW",2));
        cars.add(new Car(3, "Logan", "Dacia",3));
        cars.add(new Car(4, "Maclaren", "Mercedes",4));
        cars.add(new Car(5, "370z", "Nissan",5));
        cars.add(new Car(6, "Prius", "Toyota",6));
    }

    public List<Car> selectAllFromCars(){
        return cars.stream().map(this::getCarCopy).collect(Collectors.toList());
    }

    private Car getCarCopy(Car car) {
        Car carCopy = new Car();
        carCopy.setId(car.getId());
        carCopy.setName(car.getName());
        carCopy.setMaker(car.getMaker());
        carCopy.setMotorId(car.getMotorId());

        return carCopy;
    }
}
