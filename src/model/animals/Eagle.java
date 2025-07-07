package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Eagle extends Animal {

    public Eagle(Cell cell) {
        super(6, 20, 3, 1.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of(
                "Fox", 10,
                "Rabbit", 90,
                "Mouse", 90,
                "Duck", 80
        );
    }
}
