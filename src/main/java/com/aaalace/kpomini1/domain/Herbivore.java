package com.aaalace.kpomini1.domain;

public abstract class Herbivore extends Animal {
    private final Double kindness;

    public Herbivore(String name, String type, Integer food, Double kindness) {
        super(name, type, food);
        this.kindness = kindness;
    }

    public boolean isFriendly() {
        return this.kindness > 0.5;
    }

    public String toString() {
        return String.format(
            "< Herbivore { id: %s, name: '%s', type: '%s', food: %d, kindness: %.2f } >",
            super.getInventoryNumber(),
            super.name,
            super.type,
            super.getFoodAmount(),
            this.kindness
        );
    }
}
