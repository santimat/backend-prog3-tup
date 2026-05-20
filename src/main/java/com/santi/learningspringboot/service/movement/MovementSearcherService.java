package com.santi.learningspringboot.service.movement;

import com.santi.learningspringboot.model.movement.Movement;
import com.santi.learningspringboot.repository.movement.JPAMovementRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovementSearcherService {
    private final JPAMovementRepository movementRepository;

    public MovementSearcherService(JPAMovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Page<Movement> getAll(Pageable pageable) {
        return movementRepository.findAll(pageable);
    }
}
