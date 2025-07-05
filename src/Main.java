import map.Cell;
import map.Island;
import model.Animal;
import model.animals.Rabbit;
import model.animals.Wolf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Island island = new Island(5, 5);
        List<Animal> allAnimals = new ArrayList<>();

        // 1. Створюємо кілька вовків
        for (int i = 0; i < 3; i++) {
            int x = ThreadLocalRandom.current().nextInt(5);
            int y = ThreadLocalRandom.current().nextInt(5);
            Cell cell = island.getCell(x, y);
            Animal wolf = new Wolf(cell);
            cell.addAnimal(wolf);
            allAnimals.add(wolf);
        }

        // 2. Створюємо кілька кроликів
        for (int i = 0; i < 10; i++) {
            int x = ThreadLocalRandom.current().nextInt(5);
            int y = ThreadLocalRandom.current().nextInt(5);
            Cell cell = island.getCell(x, y);
            Animal rabbit = new Rabbit(cell);
            cell.addAnimal(rabbit);
            allAnimals.add(rabbit);
        }

        // 3. Симуляція на 20 кроків
        for (int tick = 1; tick <= 20; tick++) {
            System.out.println("=== КРОК #" + tick + " ===");

            List<Animal> currentAnimals = new ArrayList<>(allAnimals); // копія для безпечного ітератора
            for (Animal animal : currentAnimals) {
                // Якщо тварина померла — пропускаємо
                if (!animal.getCurrentCell().getAnimals().contains(animal)) continue;

                animal.eat();
                animal.move(island);
            }

            // Видаляємо мертвих
            allAnimals.removeIf(animal -> !animal.getCurrentCell().getAnimals().contains(animal));

            // Вивід кількості
            long wolves = allAnimals.stream().filter(a -> a instanceof Wolf).count();
            long rabbits = allAnimals.stream().filter(a -> a instanceof Rabbit).count();
            System.out.println("Вовків: " + wolves + ", Кроликів: " + rabbits);

            Thread.sleep(500); // трішки затримки між кроками
        }

        System.out.println("=== КІНЕЦЬ СИМУЛЯЦІЇ ===");
    }
}
