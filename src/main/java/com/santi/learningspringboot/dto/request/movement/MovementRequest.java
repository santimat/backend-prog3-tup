package com.santi.learningspringboot.dto.request.movement;

import jakarta.validation.constraints.NotNull;

public class MovementRequest {
    @NotNull
    private String name;
    @NotNull
    private String description;

    public MovementRequest() {
    }

    public MovementRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
