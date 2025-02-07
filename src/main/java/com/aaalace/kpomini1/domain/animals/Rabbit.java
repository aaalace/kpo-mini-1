package com.aaalace.kpomini1.domain.animals;

import com.aaalace.kpomini1.domain.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit(String name, Integer food, Double kindness) {
        super(name, "rabbit", food, kindness);
    }
}
