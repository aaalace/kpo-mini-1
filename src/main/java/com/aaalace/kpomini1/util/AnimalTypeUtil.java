package com.aaalace.kpomini1.util;

import java.util.List;

public class AnimalTypeUtil {
    static final List<String> herbivoreAnimalTypes = List.of("rabbit");
    static final List<String> predatorAnimalTypes = List.of("tiger");

    public static boolean containsAnimalType(String type) {
        return herbivoreAnimalTypes.contains(type) || predatorAnimalTypes.contains(type);
    }

    public static boolean containsHerbivoreAnimalType(String type) {
        return herbivoreAnimalTypes.contains(type);
    }
}
