package com.santi.learningspringboot.controller.movement;

import com.santi.learningspringboot.dto.request.movement.MovementRequest;
import com.santi.learningspringboot.dto.response.movement.MovementResponse;
import com.santi.learningspringboot.mapper.movement.MovementMapper;
import com.santi.learningspringboot.model.movement.Movement;
import com.santi.learningspringboot.service.movement.MovementCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movements")
public class MovementPostController {
    private final MovementCreatorService movementCreatorService;

    public MovementPostController(MovementCreatorService movementCreatorService) {
        this.movementCreatorService = movementCreatorService;
    }

    @PostMapping()
    public ResponseEntity<MovementResponse> create(@RequestBody MovementRequest request) {
        Movement createdMovement = movementCreatorService.create(request);
        MovementResponse response = MovementMapper.toResponse(createdMovement);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
