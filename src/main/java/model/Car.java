package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String name;
    private String maker;
    private Integer motorId;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(name, car.name) && Objects.equals(maker, car.maker) && Objects.equals(motorId, car.motorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maker, motorId);
    }
}
