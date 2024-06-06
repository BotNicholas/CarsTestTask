package resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FullCarDataBAseConstants;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.CarsService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class CarsResourceTestWithSpy {
    @InjectSpy
    private CarsService carsService;
    @Inject
    private ObjectMapper mapper;

    @BeforeAll
    public static void init() {
        System.out.println("CarsResourceTestWithSpy tests started:");
    }

    @Test
    @DisplayName("\tCarsResource find all with real data with spy resource test")
    public void findAllTest() {
        given().get("cars/").then().statusCode(200).body("size()", is(6));

        Mockito.verify(carsService, Mockito.times(1)).findAll();

        System.out.println("Service returned real data!\nCarsService.findAll method was called 1 time!");
    }

    @Test
    @DisplayName("\tCarsResource find all with stubbing with spy resource test")
    public void findAllWithStubbingTest() throws JsonProcessingException {
        Mockito.doReturn(FullCarDataBAseConstants.cars).when(carsService).findAll();

        String expected = mapper.writeValueAsString(FullCarDataBAseConstants.cars);
        String actual = given().get("/cars").getBody().asString();

        Assertions.assertEquals(expected, actual);
        Mockito.verify(carsService, Mockito.times(1)).findAll();

        System.out.printf("Service returned: %s\nExpected: %s\nCarsService.findAll method was called 1 time!", expected, actual);
    }
}
