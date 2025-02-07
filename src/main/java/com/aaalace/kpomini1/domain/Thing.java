package com.aaalace.kpomini1.domain;

import java.util.UUID;

public abstract class Thing implements IInventory {
    private final UUID id; // same as inventory number

    protected Thing() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getInventoryNumber() {
        return id;
    }
}
