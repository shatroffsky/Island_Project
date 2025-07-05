package model;

import map.Cell;

public abstract class Predator extends Animal {
    public Predator(int weight, int maxCountInCell, int speed, int saturation, Cell cell) {
        super(weight, maxCountInCell, speed, saturation, cell);
    }
}
