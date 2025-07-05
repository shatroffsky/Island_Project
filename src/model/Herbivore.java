package model;

import map.Cell;

public abstract class Herbivore extends Animal {

    public Herbivore(int weight, int maxCountInCell, int speed, double foodNeed, Cell cell) {
        super(weight, maxCountInCell, speed, foodNeed, cell);
    }
}
