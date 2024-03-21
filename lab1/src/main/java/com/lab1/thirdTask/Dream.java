package com.lab1.thirdTask;

import java.util.Objects;

public class Dream {
    public Dream(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dream dream = (Dream) o;
        return Objects.equals(description, dream.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
