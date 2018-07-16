package com.thoughtworks.tdd;

import java.util.UUID;

public class Receipt {
    private UUID uuid;

    public Receipt(){

    }

    public Receipt(UUID uuid){
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
