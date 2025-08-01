package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Boa extends Animal {

    public Boa(Cell cell) {
        super(15, 30, 1, 3.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of(
                "Fox", 15,
                "Rabbit", 20,
                "Mouse", 40,
                "Duck", 10
        );
    }
}
