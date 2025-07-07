package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Deer extends Animal {

    public Deer(Cell cell) {
        super(300, 20, 4, 50.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of("Plant", 100);
    }
}
