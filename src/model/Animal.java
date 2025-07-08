package model;

import map.Cell;
import java.util.concurrent.ThreadLocalRandom;
import map.Island;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public abstract class Animal {

    protected double weight;
    protected int maxCountInCell;
    protected int speed;
    protected double foodNeed;
    protected Cell currentCell;
    private double hunger = 0;

    public Animal(double weight, int maxCountInCell, int speed, double foodNeed, Cell cell) {
        this.weight = weight;
        this.maxCountInCell = maxCountInCell;
        this.speed = speed;
        this.foodNeed = foodNeed;
        this.currentCell = cell;
    }


    public void eat() {
        Map<String, Integer> eats = this.getEats();
        double foodNeed = this.getFoodNeed();

        double currentSaturation = 0;
        Cell cell = getCurrentCell();

        for (String foodName : eats.keySet()) {
            if (currentSaturation >= foodNeed) break;

            int chance = eats.get(foodName);

            if ("Plant".equals(foodName)) {
                Iterator<Plant> plantIterator = cell.getPlants().iterator();
                while (plantIterator.hasNext() && currentSaturation < foodNeed) {
                    Plant plant = plantIterator.next();
                    if (ThreadLocalRandom.current().nextDouble(100) <= chance) {
                        currentSaturation += plant.getWeight();

                        System.out.printf("%s у клітинці (%d, %d) зʼїв рослину%n",
                                this.getClass().getSimpleName(),
                                cell.getX(), cell.getY());

                        plantIterator.remove();
                        cell.removePlant(plant);
                    }
                }
            } else {
                Iterator<Animal> animalIterator = cell.getAnimals().iterator();
                while (animalIterator.hasNext() && currentSaturation < foodNeed) {
                    Animal prey = animalIterator.next();
                    if (prey.getClass().getSimpleName().equals(foodName)) {
                        if (Math.random() * 100 <= chance) {
                            currentSaturation += prey.getWeight();

                            System.out.printf("%s у клітинці (%d, %d) зʼїв %s%n",
                                    this.getClass().getSimpleName(),
                                    cell.getX(), cell.getY(),
                                    prey.getClass().getSimpleName());

                            animalIterator.remove();
                            cell.removeAnimal(prey);
                        }
                    }
                }
            }
        }

        if (currentSaturation >= foodNeed) {
            hunger = 0;
        } else {
            hunger += (foodNeed - currentSaturation);
            if (hunger > foodNeed * 3) {
                cell.removeAnimal(this);
            }
        }
    }

    public void multiply() {
        List<Animal> sameSpecies = currentCell.getAnimals().stream()
                .filter(a -> a.getClass() == this.getClass())
                .toList();

        if (sameSpecies.size() < 2) {
            return;
        }

        long countInCell = sameSpecies.size();
        if (countInCell >= this.maxCountInCell) {
            return;
        }

        try {
            Animal newAnimal = this.getClass()
                    .getConstructor(Cell.class)
                    .newInstance(currentCell);

            currentCell.addAnimal(newAnimal);

            System.out.printf("%s у клітинці (%d, %d) розмножився%n",
                    this.getClass().getSimpleName(),
                    currentCell.getX(), currentCell.getY());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void move(Island island) {
        int maxStep = this.speed;

        int currentX = currentCell.getX();
        int currentY = currentCell.getY();

        for (int attempt = 0; attempt < 5; attempt++) {
            int dx = 0, dy = 0;
            int direction = ThreadLocalRandom.current().nextInt(4);
            int step = ThreadLocalRandom.current().nextInt(1, maxStep + 1);

            switch (direction) {
                case 0 -> dy = -step;
                case 1 -> dy = step;
                case 2 -> dx = -step;
                case 3 -> dx = step;
            }

            int newX = currentX + dx;
            int newY = currentY + dy;

            Cell newCell = island.getCell(newX, newY);

            if (newCell != null) {
                currentCell.removeAnimal(this);
                newCell.addAnimal(this);
                this.currentCell = newCell;
                System.out.printf("%s перемістився з (%d, %d) у (%d, %d)%n",
                        this.getClass().getSimpleName(), currentX, currentY, newX, newY);
                return;
            }
        }

        System.out.printf("%s залишився на місці (%d, %d)%n",
                this.getClass().getSimpleName(), currentX, currentY);
    }

    public abstract Map<String, Integer> getEats();

    public double getWeight() {
        return weight;
    }

    public int getMaxCountInCell() {
        return maxCountInCell;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFoodNeed() {
        return foodNeed;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public double getHunger() {
        return hunger;
    }
}
