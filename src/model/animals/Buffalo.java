package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Buffalo extends Animal {

    public Buffalo(Cell cell) {
        super(700, 10, 3, 100.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of("Plant", 100);
    }
}
