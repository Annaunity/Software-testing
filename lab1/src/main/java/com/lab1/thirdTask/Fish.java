package com.lab1.thirdTask;

import java.util.Objects;

public class Fish extends Creature {
    private String color = "";
    public Fish(String name, Dream dream, String color) {
        super(name, dream);
        this.color = color;
    }

    public void changeColor(String newColor) {
        this.color = newColor;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return Objects.equals(color, fish.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
