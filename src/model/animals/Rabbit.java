package model.animals;

import map.Cell;
import model.Herbivore;

public class Rabbit extends Herbivore {

    public Rabbit(Cell cell) {
        super(2, 150, 2, 0.45, cell);
    }

    public String getTypeName() {
        return "Rabbit";
    }

}
