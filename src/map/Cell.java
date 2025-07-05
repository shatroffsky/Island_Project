package map;

import model.Animal;
import model.Plant;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final int x;
    private final int y;

    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Додати тварину
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Видалити тварину
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    // Додати рослину
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    // Видалити рослину
    public void removePlant(Plant plant) {
        plants.remove(plant);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}
