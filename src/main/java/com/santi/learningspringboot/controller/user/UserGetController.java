package com.santi.learningspringboot.controller.user;

import com.santi.learningspringboot.dto.response.user.UserResponse;
import com.santi.learningspringboot.mapper.user.UserMapper;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.service.user.UserFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGetController {
    private final UserFinderService userFinderService;

    public UserGetController(UserFinderService userFinderService) {
        this.userFinderService = userFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        User userFounded = userFinderService.findById(id);
        UserResponse response = UserMapper.toResponse(userFounded);
        return ResponseEntity.ok(response);
    }
}
