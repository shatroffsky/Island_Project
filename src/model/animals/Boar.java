package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Boar extends Animal {

    public Boar(Cell cell) {
        super(400, 50, 2, 50.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of(
                "Plant", 100,
                "Mouse", 50,
                "Caterpillar", 90
        );
    }
}
