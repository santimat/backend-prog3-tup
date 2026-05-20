package com.santi.learningspringboot.service.movement;

import com.santi.learningspringboot.dto.request.movement.MovementUpdatable;
import com.santi.learningspringboot.model.movement.Movement;
import com.santi.learningspringboot.repository.movement.JPAMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementUpdaterPartiallyService {
    private final JPAMovementRepository movementRepository;
    private final MovementFinderService movementFinderService;

    public MovementUpdaterPartiallyService(JPAMovementRepository movementRepository, MovementFinderService movementFinderService) {
        this.movementRepository = movementRepository;
        this.movementFinderService = movementFinderService;
    }

    public Movement update(MovementUpdatable movementUpdatable, Long id) {
        Movement foundedMovement = movementFinderService.findById(id);
        if (movementUpdatable.getName() != null) foundedMovement.setName(movementUpdatable.getName());
        if (movementUpdatable.getDescription() != null)
            foundedMovement.setDescription(movementUpdatable.getDescription());
        return movementRepository.save(foundedMovement);
    }
}
