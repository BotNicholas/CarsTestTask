package db;

import constants.CarsDataBaseConstants;
import model.Car;
import org.junit.jupiter.api.*;

import java.util.List;

public class CatDataBaseTest {
    private CarDataBase db;

    @BeforeAll
    public static void init() {
        System.out.println("CarDataBaseTest tests started:");
    }

    @BeforeEach
    public void recreateDb() throws Exception {
        db = new CarDataBase();
    }

    @Test
    @DisplayName("\tCarDataBAse all cars select test...")
    public void selectAllFromCarsTest() {
        List<Car> expected = CarsDataBaseConstants.cars;

        List<Car> actual = db.selectAllFromCars();

        Assertions.assertEquals(expected, actual);
        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }
}
