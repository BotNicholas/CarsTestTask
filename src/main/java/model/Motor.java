package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motor {
    private Integer id;
    private String model;
    private Integer hp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motor motor = (Motor) o;
        return Objects.equals(id, motor.id) && Objects.equals(model, motor.model) && Objects.equals(hp, motor.hp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, hp);
    }
}
