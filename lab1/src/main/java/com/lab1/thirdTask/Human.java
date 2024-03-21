package com.lab1.thirdTask;

import java.util.Objects;

public class Human extends Creature {
    private Item itemOnHand;
    private Backpack backpack;
    private int blinkCounter;

    public Human(String name, Dream dream) {
        super(name, dream);
        backpack = new Backpack(4);
    }

    public void blink() {
        blinkCounter++;
        System.out.println(getName() + " blinking now");
    }

    public boolean takeItemFromBackpack(int id) {
        if (itemOnHand == null) {
            itemOnHand = backpack.getFromBackpack(id);
            return true;
        }
        return false;
    }

    public void addItemToBackpack(Item item) {
        if (item.equals(itemOnHand)) {
            itemOnHand = null;
        }
        backpack.addToBackpack(item);
    }

    public Item getItemOnHand() {
        return itemOnHand;
    }

    public void setItemOnHand(Item itemOnHand) {
        this.itemOnHand = itemOnHand;
    }

    public int getBlinkCounter() {
        return blinkCounter;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return blinkCounter == human.blinkCounter && Objects.equals(itemOnHand, human.itemOnHand) && Objects.equals(backpack, human.backpack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemOnHand, backpack, blinkCounter);
    }
}
