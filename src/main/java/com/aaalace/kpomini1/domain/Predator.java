package com.aaalace.kpomini1.domain;

public abstract class Predator extends Animal {
    public Predator(String name, String type, Integer food) {
        super(name, type, food);
    }

    @Override
    public String toString() {
        return String.format(
            "< Predator: { id: %s, name: '%s', type: '%s', food: %d } >",
            super.getInventoryNumber(),
            super.name,
            super.type,
            super.getFoodAmount()
        );
    }
}