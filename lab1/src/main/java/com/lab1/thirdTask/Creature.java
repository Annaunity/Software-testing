package com.lab1.thirdTask;

import java.util.Objects;

public abstract class Creature {
    public static final String NO_DREAM_TEXT = "don't have dream";
    private String name;
    private Dream dream;

    public Creature(String name, Dream dream) {
        this.name = name;
        this.dream = dream;
    }
    public void startDreaming() {
        System.out.println("Dreaming about " + dream.getDescription());
    };

    public void dreamComeTrue() {
        setDream(new Dream(NO_DREAM_TEXT));
    }

    public Dream getDream() {
        return dream;
    }

    public String getName() {
        return name;
    }

    public void setDream(Dream dream) {
        this.dream = dream;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return Objects.equals(name, creature.name) && Objects.equals(dream, creature.dream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dream);
    }
}
