package services;

import db.MotorDataBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import model.Motor;

import java.util.List;

@ApplicationScoped
public class SomeExternalMotorService {
    @Inject
    private MotorDataBase dataBase;

    public List<Motor> findAll() {
        return dataBase.selectAllFromMotors();
    }

    public Motor findById(Integer id) {
        return findAll().stream().filter(motor -> motor.getId() == id).findFirst().orElse(null);
    }
}
