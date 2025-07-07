package model.animals;

import map.Cell;
import model.Predator;

import java.util.Map;

public class Wolf extends Predator {

    public Wolf(Cell cell) {
        super(50, 30, 3, 8.0, cell);
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of(
                "Horse", 10,
                "Deer", 15,
                "Rabbit", 60,
                "Mouse", 80,
                "Goat", 60,
                "Sheep", 70,
                "Boar", 15,
                "Buffalo", 10,
                "Duck", 40
        );
    }
}
