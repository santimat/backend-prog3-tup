package com.santi.learningspringboot.dto.request.movement;

import jakarta.annotation.Nullable;

public class MovementUpdatable {
    @Nullable
    private String name;
    @Nullable
    private String description;

    public MovementUpdatable() {
    }

    public MovementUpdatable(@Nullable String name, @Nullable String description) {
        this.name = name;
        this.description = description;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
}
