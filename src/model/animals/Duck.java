package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Duck extends Animal {

    public Duck(Cell cell) {
        super(1, 200, 4, 0.15, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of(
                "Plant", 100,
                "Caterpillar", 90
        );
    }
}
