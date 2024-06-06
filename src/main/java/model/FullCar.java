package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullCar {
    private int id;
    private String name;
    private String maker;
    private Motor motor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullCar fullCar = (FullCar) o;
        return id == fullCar.id && Objects.equals(name, fullCar.name) && Objects.equals(maker, fullCar.maker) && motor == fullCar.motor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maker, motor);
    }
}
