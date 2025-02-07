package com.aaalace.kpomini1.domain;

import java.util.UUID;

public abstract class Animal implements IAlive, IInventory {
    private final UUID id; // same as inventory number
    public final String name;
    public final String type;
    private final Integer food;

    public Animal(String name, String type, Integer food) {
        this.name = name;
        this.type = type;
        this.food = food;
        this.id = UUID.randomUUID();
    }

    @Override
    public Integer getFoodAmount() {
        return food;
    }

    @Override
    public UUID getInventoryNumber() {
        return id;
    }
}
