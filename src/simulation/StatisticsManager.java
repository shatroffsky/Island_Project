package simulation;

import map.Cell;
import map.Island;
import model.Animal;
import model.Plant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsManager {

    public void printStatistics(Island island) {
        Map<String, Integer> animalCountMap = new HashMap<>();
        int plantCount = 0;

        for (Cell[] row : island.getCells()) {
            for (Cell cell : row) {
                List<Animal> animals = cell.getAnimals();
                List<Plant> plants = cell.getPlants();

                plantCount += plants.size();

                for (Animal animal : animals) {
                    String type = animal.getClass().getSimpleName();
                    animalCountMap.merge(type, 1, Integer::sum);
                }
            }
        }

        System.out.println("\n===== 📊 СТАТИСТИКА ОСТРОВА =====");
        System.out.println("🌿 Рослин: " + plantCount);
        System.out.println("🐾 Тварини:");

        animalCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.printf("  %-12s: %d%n", entry.getKey(), entry.getValue()));

        System.out.println("=================================\n");
    }
}
