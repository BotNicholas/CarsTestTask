package db;

import constants.MotorsDataBaseConstants;
import model.Motor;
import org.junit.jupiter.api.*;

import java.util.List;

public class MotorDataBaseTest {
    private MotorDataBase db;

    @BeforeAll
    public static void init() {
        System.out.println("MotorDataBaseTest tests started:");
    }

    @BeforeEach
    public void recreateDb() throws Exception {
        db = new MotorDataBase();
    }

    @Test
    @DisplayName("\tNotorDataBase all motors select test...")
    public void selectAllFromMotorsTest() {
        List<Motor> expected = MotorsDataBaseConstants.motors;

        List<Motor> actual = db.selectAllFromMotors();

        Assertions.assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }
}
