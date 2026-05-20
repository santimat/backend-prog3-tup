package com.santi.learningspringboot.exception.movement;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(Long id) {
        super("Movement with id " + id + " not found");
    }
}
