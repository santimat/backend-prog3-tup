package com.santi.learningspringboot.controller.movement;

import com.santi.learningspringboot.service.movement.MovementDeleterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movements")
public class MovementDeleteController {
    private final MovementDeleterService movementDeleterService;

    public MovementDeleteController(MovementDeleterService movementDeleterService) {
        this.movementDeleterService = movementDeleterService;
    }

    public ResponseEntity<String> deleteById(Long id) {
        movementDeleterService.deleteById(id);
        return ResponseEntity.ok("Movement with id " + id + " deleted successfully.");
    }
}
