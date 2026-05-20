package com.santi.learningspringboot.service.movement;

import com.santi.learningspringboot.dto.request.movement.MovementRequest;
import com.santi.learningspringboot.mapper.movement.MovementMapper;
import com.santi.learningspringboot.model.movement.Movement;
import com.santi.learningspringboot.repository.movement.JPAMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementCreatorService {
    private final JPAMovementRepository movementRepository;

    public MovementCreatorService(JPAMovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Movement create(MovementRequest request) {
        Movement newMovement = MovementMapper.toEntity(request);
        return movementRepository.save(newMovement);
    }
}
