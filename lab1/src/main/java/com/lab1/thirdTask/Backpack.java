package com.lab1.thirdTask;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int capacity;

    private final List<Item> items = new ArrayList<>();


    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addToBackpack(Item itemToAdd) {
        if (capacity > 0) {
            items.add(itemToAdd);
            capacity--;
            return;
        }

        throw new BackpackIsFullException("backpack is full");
    }

    public Item getFromBackpack(int id) {
        if (id <= 0 || id > items.size()) {
            return null;
        }
        capacity++;
        var item = items.get(id - 1);
        items.remove(item);
        return item;
    }
}
