package com.santi.learningspringboot.controller.movement;

import com.santi.learningspringboot.dto.response.movement.MovementResponse;
import com.santi.learningspringboot.mapper.movement.MovementMapper;
import com.santi.learningspringboot.service.movement.MovementSearcherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movements")
public class MovementsGetController {
    private final MovementSearcherService movementSearcherService;

    public MovementsGetController(MovementSearcherService movementSearcherService) {
        this.movementSearcherService = movementSearcherService;
    }

    @GetMapping()
    public ResponseEntity<Page<MovementResponse>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MovementResponse> movementsPerPage = movementSearcherService.getAll(pageable).map(MovementMapper::toResponse);
        return ResponseEntity.ok(movementsPerPage);
    }
}
