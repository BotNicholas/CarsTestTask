package services;

import constants.MotorsDataBaseConstants;
import db.MotorDataBase;
import model.Motor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SomeExternalMotorServiceTest {
    @Mock
    private MotorDataBase motorDataBase;
    @InjectMocks
    private SomeExternalMotorService someExternalMotorService;

    @BeforeAll
    public static void init() {
        System.out.println("SomeExternalMotorServiceTest tests started:");
    }

    @Test
    @DisplayName("\tSomeExternalMotorService findAll method test")
    public void findAllTest() {
        Mockito.when(motorDataBase.selectAllFromMotors()).thenReturn(MotorsDataBaseConstants.motors);

        List<Motor> expected = MotorsDataBaseConstants.motors;
        List<Motor> actual = someExternalMotorService.findAll();

        Assertions.assertEquals(expected, actual);

        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    @DisplayName("\tSomeExternalMotorService findBiId method with id=1 test")
    public void findById() {
        Mockito.when(motorDataBase.selectAllFromMotors()).thenReturn(MotorsDataBaseConstants.motors);

        Motor expected = MotorsDataBaseConstants.motor1;
        Motor actual = someExternalMotorService.findById(1);

        Assertions.assertEquals(expected, actual);

        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }
}
