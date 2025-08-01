package model;

import map.Cell;

public class Plant {

    protected int weight = 1;
    protected int maxCountInCell = 200;
    protected Cell currentCell;

    public Plant(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxCountInCell() {
        return maxCountInCell;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }
}
