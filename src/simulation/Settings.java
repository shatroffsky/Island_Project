package simulation;

import map.Cell;
import model.Animal;
import model.animals.*;
import model.Plant;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Settings {

    private static final Map<Class<? extends Animal>, Integer> animalSpawnChances = new LinkedHashMap<>();

    static {
        animalSpawnChances.put(Wolf.class, 5);
        animalSpawnChances.put(Bear.class, 3);
        animalSpawnChances.put(Fox.class, 5);
        animalSpawnChances.put(Eagle.class, 4);
        animalSpawnChances.put(Boa.class, 2);

        animalSpawnChances.put(Horse.class, 8);
        animalSpawnChances.put(Deer.class, 10);
        animalSpawnChances.put(Rabbit.class, 15);
        animalSpawnChances.put(Mouse.class, 10);
        animalSpawnChances.put(Goat.class, 10);
        animalSpawnChances.put(Sheep.class, 10);
        animalSpawnChances.put(Boar.class, 5);
        animalSpawnChances.put(Buffalo.class, 3);
        animalSpawnChances.put(Duck.class, 10);
        animalSpawnChances.put(Caterpillar.class, 10);
    }

    public Map<Class<? extends Animal>, Integer> getAnimalSpawnChances() {
        return animalSpawnChances;
    }

    public int getPlantSpawnMin() {
        return 1;
    }

    public int getPlantSpawnMax() {
        return 200;
    }

    public Animal createAnimal(Class<? extends Animal> clazz, Cell cell) {
        try {
            return clazz.getConstructor(Cell.class).newInstance(cell);
        } catch (Exception e) {
            throw new RuntimeException("Не вдалося створити тварину: " + clazz.getSimpleName(), e);
        }
    }

    public Plant createPlant(Cell cell) {
        return new Plant(cell);
    }

    public boolean shouldSpawn(int chancePercent) {
        return ThreadLocalRandom.current().nextInt(100) < chancePercent;
    }
}
