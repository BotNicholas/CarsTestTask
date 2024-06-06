package db;

import jakarta.enterprise.context.Dependent;
import model.Motor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class MotorDataBase {
    private final List<Motor> motors = new ArrayList<>();

    public MotorDataBase() {
        motors.add(new Motor(1, "V8", 300));
        motors.add(new Motor(2, "V8", 310));
        motors.add(new Motor(3, "V666", 666));
        motors.add(new Motor(4, "V6", 300));
        motors.add(new Motor(5, "V12", 500));
        motors.add(new Motor(6, "IDK", 200));
    }

    public List<Motor> selectAllFromMotors() {
        return motors.stream().map(this::getMotorCopy).collect(Collectors.toList());
    }

    private Motor getMotorCopy(Motor motor) {
        Motor motorCopy = new Motor();
        motorCopy.setId(motor.getId());
        motorCopy.setModel(motor.getModel());
        motorCopy.setHp(motor.getHp());

        return motorCopy;
    }
}
