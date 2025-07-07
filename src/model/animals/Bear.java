package model.animals;

import model.Animal;
import map.Cell;

import java.util.Map;

public class Bear extends Animal {

    public Bear(Cell cell) {
        super(500, 5, 2, 80.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of(
                "Boa", 80,
                "Horse", 40,
                "Deer", 80,
                "Rabbit", 80,
                "Mouse", 90,
                "Goat", 70,
                "Sheep", 70,
                "Boar", 50,
                "Buffalo", 20,
                "Duck", 10
        );
    }
}
