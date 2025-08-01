package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Fox extends Animal {

    public Fox(Cell cell) {
        super(8, 30, 2, 2.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of(
                "Rabbit", 70,
                "Mouse", 90,
                "Duck", 60,
                "Caterpillar", 40
        );
    }
}
