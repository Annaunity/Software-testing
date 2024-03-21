package com.lab1.thirdTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Location {
    private String name;
    private List<Creature> creatureList;
    private List<Item> itemsList;


    public Location(String name, List<Creature> creatureList, List<Item> itemsList) {
        this.name = name;
        this.creatureList = creatureList;
        this.itemsList = itemsList;
        if (creatureList == null) {
            this.creatureList = new ArrayList<>();
        }
        if (itemsList == null) {
            this.itemsList = new ArrayList<>();
        }
    }

    public String getName() {
        return name;
    }

    public List<Creature> getCreatureList() {
        return creatureList;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatureList(List<Creature> creatureList) {
        this.creatureList = creatureList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public void addCreature(Creature creature) {
        creatureList.add(creature);
    }

    public void addItem(Item item) {
        itemsList.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && Objects.equals(creatureList, location.creatureList) && Objects.equals(itemsList, location.itemsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creatureList, itemsList);
    }
}
