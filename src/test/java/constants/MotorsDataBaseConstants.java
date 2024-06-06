package constants;

import model.Motor;

import java.util.List;

public class MotorsDataBaseConstants {
    public static final Motor motor1 = new Motor(1, "V8", 300);
    public static final Motor motor2 = new Motor(2, "V8", 310);
    public static final Motor motor3 = new Motor(3, "V666", 666);
    public static final Motor motor4 = new Motor(4, "V6", 300);
    public static final Motor motor5 = new Motor(5, "V12", 500);
    public static final Motor motor6 = new Motor(6, "IDK", 200);

    public static final List<Motor> motors = List.of(motor1,
                                                     motor2,
                                                     motor3,
                                                     motor4,
                                                     motor5,
                                                     motor6);

}
