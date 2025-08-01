package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Horse extends Animal {

    public Horse(Cell cell) {
        super(400, 20, 4, 60.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of("Plant", 100);
    }
}
