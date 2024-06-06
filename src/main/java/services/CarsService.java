package services;

import db.CarDataBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Car;
import model.FullCar;

import java.util.List;

@ApplicationScoped
public class CarsService {
    @Inject
    private CarDataBase db;
    @Inject
    private SomeExternalMotorService externalService;

    public List<FullCar> findAll() {
        List<Car> cars = db.selectAllFromCars();
        return cars.stream().map(this::getFullCar).toList();
    }

    public FullCar findById(int id) {
        Car simpleCar = db.selectAllFromCars().stream().filter(car -> car.getId() == id).findFirst().orElse(null);
        return getFullCar(simpleCar);
    }

    private FullCar getFullCar(Car car) {
        if (car != null) {
            FullCar fullCar = new FullCar(car.getId(), car.getName(), car.getMaker(), externalService.findById(car.getMotorId()));
            return fullCar;
        } else {
            return null;
        }
    }
}
