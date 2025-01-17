package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FullCarDataBAseConstants;
import constants.MotorsDataBaseConstants;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import model.FullCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.CarsService;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class CarsResourceTest {
    @InjectMock
    CarsService service;
    @Inject
    ObjectMapper mapper;

    @BeforeAll
    public static void init() {
        System.out.println("CarResourceTest tests started:");
    }

    @Test
    @DisplayName("\tCarsResource find all with the same resource test")
    public void getFullTestForAllTheSame() throws JsonProcessingException {
        Mockito.when(service.findAll()).thenReturn(FullCarDataBAseConstants.cars);

        String expected = mapper.writeValueAsString(FullCarDataBAseConstants.cars);

        String actual = given().get("/cars")
                .getBody().asString();

        Assertions.assertEquals(expected, actual);

        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    @DisplayName("\tCarsResource find all with different resource test")
    public void getFullTestForAllDifferent() throws JsonProcessingException {
        List<FullCar> cars2 = List.of(new FullCar(1, "Supra123", "Toyota123", MotorsDataBaseConstants.motor2),
                new FullCar(2, "M3123", "BMW13", MotorsDataBaseConstants.motor3),
                new FullCar(3, "Logan13", "Dacia13", MotorsDataBaseConstants.motor4));

        Mockito.when(service.findAll()).thenReturn(FullCarDataBAseConstants.cars).thenReturn(cars2);

        String expected = mapper.writeValueAsString(FullCarDataBAseConstants.cars);
        String actual = given().get("/cars").getBody().asString();

        Assertions.assertEquals(expected, actual);

        expected = mapper.writeValueAsString(cars2);
        actual = given().get("/cars").getBody().asString();

        Assertions.assertEquals(expected, actual);

        System.out.printf("Expected: %s\nActual: %s\n", expected, actual);
    }

    @Test
    @DisplayName("\tCarsResource find by id resource test")
    public void getByIdTest() {
        Mockito.when(service.findById(1)).thenReturn(FullCarDataBAseConstants.car1);

        given().get("/cars/1").then().statusCode(200).body("id", is(FullCarDataBAseConstants.car1.getId()));

        System.out.printf("Service returned %s", FullCarDataBAseConstants.car1);
    }

    @Test
    @DisplayName("\tCarsResource find by id with exception resource test")
    public void getByIdNotFoundTest() {
        Mockito.when(service.findById(999)).thenThrow(RuntimeException.class);

        given().get("/cars/999").then().statusCode(500);

        System.out.println("Car with id 999 was not found!\nServer thrown Exception.\nStatus code = 500");
    }
}
