package model.animals;

import map.Cell;
import model.Predator;

public class Wolf extends Predator {

    public Wolf(Cell cell) {
        super(50, 30, 3, 8, cell);
    }

    public String getTypeName() {
        return "Wolf";
    }
}
