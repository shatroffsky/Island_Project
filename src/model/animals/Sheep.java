package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Sheep extends Animal {

    public Sheep(Cell cell) {
        super(70, 140, 3, 15.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of("Plant", 100);
    }
}
