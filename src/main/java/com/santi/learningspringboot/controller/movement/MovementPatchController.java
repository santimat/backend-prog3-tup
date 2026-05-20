package com.santi.learningspringboot.controller.movement;

import com.santi.learningspringboot.dto.request.movement.MovementUpdatable;
import com.santi.learningspringboot.dto.response.movement.MovementResponse;
import com.santi.learningspringboot.mapper.movement.MovementMapper;
import com.santi.learningspringboot.model.movement.Movement;
import com.santi.learningspringboot.service.movement.MovementUpdaterPartiallyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movements")
public class MovementPatchController {
    private final MovementUpdaterPartiallyService movementUpdaterPartiallyService;

    public MovementPatchController(MovementUpdaterPartiallyService movementUpdaterPartiallyService) {
        this.movementUpdaterPartiallyService = movementUpdaterPartiallyService;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovementResponse> updatePartially(@RequestBody MovementUpdatable movementUpdatable, @PathVariable Long id) {
        Movement updatedMovement = movementUpdaterPartiallyService.update(movementUpdatable, id);
        MovementResponse response = MovementMapper.toResponse(updatedMovement);
        return ResponseEntity.ok(response);
    }
}
