package simulation;

import map.Cell;
import map.Island;
import model.Animal;

import java.util.List;
import java.util.concurrent.*;

public class LifeCycleManager {

    private final Island island;
    private final ExecutorService executor;
    private final ScheduledExecutorService scheduler;
    private final Settings settings = new Settings();

    public LifeCycleManager(Simulation simulation) {
        this.island = simulation.getIsland();
        int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
        this.executor = Executors.newFixedThreadPool(THREAD_COUNT);
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void start() {
        int CYCLE_INTERVAL_SECONDS = 2;
        scheduler.scheduleAtFixedRate(this::runCycle, 0, CYCLE_INTERVAL_SECONDS, TimeUnit.SECONDS);
    }

    private void runCycle() {
        Cell[][] cells = island.getCells();
        List<Callable<Void>> tasks = new CopyOnWriteArrayList<>();

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                tasks.add(() -> {
                    processCell(cell);
                    return null;
                });
            }
        }

        try {
            executor.invokeAll(tasks);
            new StatisticsManager().printStatistics(island);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Цикл був перерваний: " + e.getMessage());
        }
    }

    private void processCell(Cell cell) {
        List<Animal> animals;
        synchronized (cell) {
            animals = List.copyOf(cell.getAnimals());
        }

        for (Animal animal : animals) {
            animal.eat();
            animal.multiply();
            animal.move(island);
        }

        int maxPlantsPerCell = 200;
        int currentPlantCount;

        synchronized (cell) {
            currentPlantCount = cell.getPlants().size();
            if (currentPlantCount < maxPlantsPerCell) {
                int plantsToAdd = ThreadLocalRandom.current().nextInt(0, 5);
                for (int i = 0; i < plantsToAdd; i++) {
                    cell.addPlant(settings.createPlant(cell));
                }
            }
        }
    }

    public void shutdown() {
        scheduler.shutdown();
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
