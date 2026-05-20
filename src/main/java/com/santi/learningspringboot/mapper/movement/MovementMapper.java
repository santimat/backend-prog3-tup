package com.santi.learningspringboot.mapper.movement;

import com.santi.learningspringboot.dto.request.movement.MovementRequest;
import com.santi.learningspringboot.dto.response.movement.MovementResponse;
import com.santi.learningspringboot.model.movement.Movement;

public class MovementMapper {
    public static Movement toEntity(MovementRequest request) {
        Movement movement = new Movement();
        movement.setName(request.getName());
        movement.setDescription(request.getDescription());
        return movement;
    }

    public static MovementResponse toResponse(Movement movement) {
        return new MovementResponse(movement.getId(), movement.getName(), movement.getDescription());
    }
}
