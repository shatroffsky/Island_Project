package model;

import map.Cell;

public abstract class Predator extends Animal {
    public Predator(int weight, int maxCountInCell, int speed, double foodNeed, Cell cell) {
        super(weight, maxCountInCell, speed, foodNeed, cell);
    }
}
