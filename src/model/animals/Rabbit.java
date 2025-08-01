package model.animals;

import map.Cell;
import model.Herbivore;

import java.util.Map;

public class Rabbit extends Herbivore {

    public Rabbit(Cell cell) {
        super(2, 150, 2, 0.45, cell); // вага, макс в клітинці, швидкість, потреба в їжі
    }

    @Override
    public Map<String, Integer> getEats() {
        return Map.of("Plant", 100);
    }
}
