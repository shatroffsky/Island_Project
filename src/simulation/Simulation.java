package simulation;

import map.Island;
import map.Cell;
import model.Animal;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Simulation {

    private final Island island;
    private final Settings settings;

    public Simulation(int width, int height) {
        this.island = new Island(width, height);
        this.settings = new Settings();

        initialize();
    }

    private void initialize() {
        for (Cell[] row : island.getCells()) {
            for (Cell cell : row) {
                populateCellWithAnimals(cell);
                populateCellWithPlants(cell);
            }
        }
    }

    private void populateCellWithAnimals(Cell cell) {
        for (Map.Entry<Class<? extends Animal>, Integer> entry : settings.getAnimalSpawnChances().entrySet()) {
            Class<? extends Animal> clazz = entry.getKey();
            int chance = entry.getValue();

            if (settings.shouldSpawn(chance)) {
                Animal tempAnimal = settings.createAnimal(clazz, cell);
                int maxCount = tempAnimal.getMaxCountInCell();

                int count = ThreadLocalRandom.current().nextInt(1, Math.max(2, maxCount / 10 + 1));

                for (int i = 0; i < count; i++) {
                    Animal animal = settings.createAnimal(clazz, cell);
                    cell.addAnimal(animal);
                }
            }
        }
    }

    private void populateCellWithPlants(Cell cell) {
        int count = ThreadLocalRandom.current().nextInt(
                settings.getPlantSpawnMin(),
                settings.getPlantSpawnMax() + 1
        );
        for (int i = 0; i < count; i++) {
            cell.addPlant(settings.createPlant(cell));
        }
    }

    public Island getIsland() {
        return island;
    }
}
