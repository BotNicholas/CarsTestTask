package services;

import constants.CarsDataBaseConstants;
import constants.FullCarDataBAseConstants;
import constants.MotorsDataBaseConstants;
import db.CarDataBase;
import model.FullCar;
import model.Motor;
import org.jboss.logging.annotations.Message;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @Mock
    private CarDataBase carDataBase;
    @Mock
    private SomeExternalMotorService externalService;
    @InjectMocks
    private CarsService service;

    @BeforeAll
    public static void init() {
        System.out.println("CarServiceTest tests started:");
    }

    @Test
    @DisplayName("\tCarService findAll method test")
    public void findAllTest() {
        Mockito.when(carDataBase.selectAllFromCars()).thenReturn(CarsDataBaseConstants.cars);

        Mockito.when(externalService.findById(1)).thenReturn(MotorsDataBaseConstants.motor1);
        Mockito.when(externalService.findById(2)).thenReturn(MotorsDataBaseConstants.motor2);
        Mockito.when(externalService.findById(3)).thenReturn(MotorsDataBaseConstants.motor3);
        Mockito.when(externalService.findById(4)).thenReturn(MotorsDataBaseConstants.motor4);
        Mockito.when(externalService.findById(5)).thenReturn(MotorsDataBaseConstants.motor5);
        Mockito.when(externalService.findById(6)).thenReturn(MotorsDataBaseConstants.motor6);

        List<FullCar> expected = FullCarDataBAseConstants.cars;
        List<FullCar> actual = service.findAll();

        Assertions.assertEquals(expected, actual);

        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    @DisplayName("\tCarService findById method with id=1 test")
    public void findById() {
        Mockito.when(carDataBase.selectAllFromCars()).thenReturn(CarsDataBaseConstants.cars);
        Mockito.when(externalService.findById(1)).thenReturn(MotorsDataBaseConstants.motor1);

        FullCar expected = FullCarDataBAseConstants.car1;
        FullCar actual = service.findById(1);

        Assertions.assertEquals(expected, actual);

        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }
}
