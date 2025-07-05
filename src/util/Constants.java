package util;

import java.util.*;

public class Constants {

    public static final Map<String, Map<String, Object>> ANIMALS = new HashMap<>();

    static {
        ANIMALS.put("Wolf", Map.of(
                "type", "predator",
                "weight", 50.0,
                "maxCount", 30,
                "speed", 3,
                "foodNeed", 8.0,
                "eats", Map.of(
                        "Horse", 10, "Deer", 15, "Rabbit", 60, "Mouse", 80,
                        "Goat", 60, "Sheep", 70, "Boar", 15, "Buffalo", 10, "Duck", 40
                )
        ));

        ANIMALS.put("Boa", Map.of(
                "type", "predator",
                "weight", 15.0,
                "maxCount", 30,
                "speed", 1,
                "foodNeed", 3.0,
                "eats", Map.of(
                        "Fox", 15, "Rabbit", 20, "Mouse", 40, "Duck", 10
                )
        ));

        ANIMALS.put("Fox", Map.of(
                "type", "predator",
                "weight", 8.0,
                "maxCount", 30,
                "speed", 2,
                "foodNeed", 2.0,
                "eats", Map.of(
                        "Rabbit", 70, "Mouse", 90, "Duck", 60, "Caterpillar", 40
                )
        ));

        ANIMALS.put("Bear", Map.of(
                "type", "predator",
                "weight", 500.0,
                "maxCount", 5,
                "speed", 2,
                "foodNeed", 80.0,
                "eats", Map.of(
                        "Boa", 80, "Horse", 40, "Deer", 80, "Rabbit", 80, "Mouse", 90,
                        "Goat", 70, "Sheep", 70, "Boar", 50, "Buffalo", 20, "Duck", 10
                )
        ));

        ANIMALS.put("Eagle", Map.of(
                "type", "predator",
                "weight", 6.0,
                "maxCount", 20,
                "speed", 3,
                "foodNeed", 1.0,
                "eats", Map.of(
                        "Fox", 10, "Rabbit", 90, "Mouse", 90, "Duck", 80
                )
        ));

        ANIMALS.put("Horse", Map.of(
                "type", "herbivore",
                "weight", 400.0,
                "maxCount", 20,
                "speed", 4,
                "foodNeed", 60.0,
                "eats", Map.of("Plant", 100)
        ));

        ANIMALS.put("Deer", Map.of(
                "type", "herbivore",
                "weight", 300.0,
                "maxCount", 20,
                "speed", 4,
                "foodNeed", 50.0,
                "eats", Map.of("Plant", 100)
        ));

        ANIMALS.put("Rabbit", Map.of(
                "type", "herbivore",
                "weight", 2.0,
                "maxCount", 150,
                "speed", 2,
                "foodNeed", 0.45,
                "eats", Map.of("Plant", 100)
        ));

        ANIMALS.put("Mouse", Map.of(
                "type", "herbivore",
                "weight", 0.05,
                "maxCount", 500,
                "speed", 1,
                "foodNeed", 0.01,
                "eats", Map.of("Plant", 100, "Caterpillar", 90)
        ));

        ANIMALS.put("Goat", Map.of(
                "type", "herbivore",
                "weight", 60.0,
                "maxCount", 140,
                "speed", 3,
                "foodNeed", 10.0,
                "eats", Map.of("Plant", 100)
        ));

        ANIMALS.put("Sheep", Map.of(
                "type", "herbivore",
                "weight", 70.0,
                "maxCount", 140,
                "speed", 3,
                "foodNeed", 15.0,
                "eats", Map.of("Plant", 100)
        ));

        ANIMALS.put("Boar", Map.of(
                "type", "herbivore",
                "weight", 400.0,
                "maxCount", 50,
                "speed", 2,
                "foodNeed", 50.0,
                "eats", Map.of("Plant", 100, "Mouse", 50, "Caterpillar", 90)
        ));

        ANIMALS.put("Buffalo", Map.of(
                "type", "herbivore",
                "weight", 700.0,
                "maxCount", 10,
                "speed", 3,
                "foodNeed", 100.0,
                "eats", Map.of("Plant", 100)
        ));

        ANIMALS.put("Duck", Map.of(
                "type", "herbivore",
                "weight", 1.0,
                "maxCount", 200,
                "speed", 4,
                "foodNeed", 0.15,
                "eats", Map.of("Plant", 100, "Caterpillar", 90)
        ));

        ANIMALS.put("Caterpillar", Map.of(
                "type", "herbivore",
                "weight", 0.01,
                "maxCount", 1000,
                "speed", 0,
                "foodNeed", 0.0,
                "eats", Map.of("Plant", 100)
        ));

        ANIMALS.put("Plant", Map.of(
                "type", "plant",
                "weight", 1.0,
                "maxCount", 200,
                "speed", 0,
                "foodNeed", 0.0,
                "eats", Map.of()
        ));
    }

}

