package com.santi.learningspringboot.controller.movement;

import com.santi.learningspringboot.dto.response.movement.MovementResponse;
import com.santi.learningspringboot.mapper.movement.MovementMapper;
import com.santi.learningspringboot.model.movement.Movement;
import com.santi.learningspringboot.service.movement.MovementFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movements")
public class MovementGetController {
    private final MovementFinderService movementFinderService;

    public MovementGetController(MovementFinderService movementFinderService) {
        this.movementFinderService = movementFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementResponse> findById(@PathVariable Long id) {
        Movement foundedMovement = movementFinderService.findById(id);
        MovementResponse response = MovementMapper.toResponse(foundedMovement);
        return ResponseEntity.ok(response);
    }
}
