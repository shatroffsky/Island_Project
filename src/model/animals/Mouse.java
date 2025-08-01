package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Mouse extends Animal {

    public Mouse(Cell cell) {
        super(0.05, 500, 1, 0.01, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of(
                "Plant", 100,
                "Caterpillar", 90
        );
    }
}
