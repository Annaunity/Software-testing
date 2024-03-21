package com.lab1.thirdTask;

public class Item {
    private String name;
    private Creature creatureInItem;


    public Item(String name) {
        this.name = name;
        this.creatureInItem = null;
    }
    public Item(String name, Creature creatureInItem) {
        this.name = name;
        this.creatureInItem = creatureInItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Creature getCreatureInItem() {
        return creatureInItem;
    }
}
