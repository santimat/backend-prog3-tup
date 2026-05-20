package com.santi.learningspringboot.service.movement;

import com.santi.learningspringboot.exception.movement.MovementNotFoundException;
import com.santi.learningspringboot.model.movement.Movement;
import com.santi.learningspringboot.repository.movement.JPAMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementFinderService {
    private final JPAMovementRepository movementRepository;

    public MovementFinderService(JPAMovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Movement findById(Long id) {
        return movementRepository.findById(id).orElseThrow(() -> new MovementNotFoundException(id));
    }
}
