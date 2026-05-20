package com.santi.learningspringboot.service.movement;

import com.santi.learningspringboot.repository.movement.JPAMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementDeleterService {
    private final JPAMovementRepository movementRepository;
    private final MovementFinderService movementFinderService;

    public MovementDeleterService(JPAMovementRepository movementRepository, MovementFinderService movementFinderService) {
        this.movementRepository = movementRepository;
        this.movementFinderService = movementFinderService;
    }

    public void deleteById(Long id) {
        movementFinderService.findById(id);
        movementRepository.deleteById(id);
    }
}
