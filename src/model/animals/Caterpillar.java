package model.animals;

import model.Animal;
import map.Island;
import map.Cell;

import java.util.Map;

public class Caterpillar extends Animal {

    public Caterpillar(Cell cell) {
        super(0.01, 1000, 0, 0.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of("Plant", 100);
    }

    public void move(Island island) {
    }

}
