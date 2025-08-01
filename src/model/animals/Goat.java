package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Goat extends Animal {

    public Goat(Cell cell) {
        super(60, 140, 3, 10.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of("Plant", 100);
    }
}
