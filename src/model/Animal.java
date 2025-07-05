package model;

import map.Cell;
import util.Constants;
import java.util.concurrent.ThreadLocalRandom;
import map.Island;
import java.util.Iterator;
import java.util.Map;

public abstract class Animal {

    protected int weight;
    protected int maxCountInCell;
    protected int speed;
    protected double foodNeed;
    protected Cell currentCell;
    private double hunger = 0;

    public Animal(int weight, int maxCountInCell, int speed, double foodNeed, Cell cell) {
        this.weight = weight;
        this.maxCountInCell = maxCountInCell;
        this.speed = speed;
        this.foodNeed = foodNeed;
        this.currentCell = cell;
    }

    public void eat() {
        Map<String, Object> animalData = Constants.ANIMALS.get(this.getClass().getSimpleName());
        if (animalData == null) return;

        Map<String, Integer> eats = (Map<String, Integer>) animalData.get("eats");
        double foodNeed = (double) animalData.get("foodNeed");

        double currentSaturation = 0;

        Cell cell = getCurrentCell();

        // Перебираємо всі можливі види їжі
        for (String foodName : eats.keySet()) {
            if (currentSaturation >= foodNeed) break;  // якщо наситився - вихід

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

        // Логіка голоду і смерті
        if (currentSaturation >= foodNeed) {
            hunger = 0;  // ситий
        } else {
            hunger += (foodNeed - currentSaturation); // накопичуємо голод
            if (hunger > foodNeed * 3) {
                // тварина помирає
                cell.removeAnimal(this);
                // тут можна додати додаткову логіку смерті, якщо треба
            }
        }
    }


    public void multiply(){

    }

    public void move(Island island) {
        int maxStep = this.speed;

        int currentX = currentCell.getX();
        int currentY = currentCell.getY();

        for (int attempt = 0; attempt < 5; attempt++) { // 5 спроб знайти валідну клітинку
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
                return; // успішне переміщення, вихід з методу
            }
        }

        // Якщо не знайшли куди рухатись — тварина залишається на місці
        System.out.printf("%s залишився на місці (%d, %d)%n",
                this.getClass().getSimpleName(), currentX, currentY);
    }


    public int getWeight() {
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
