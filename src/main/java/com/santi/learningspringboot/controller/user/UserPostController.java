package com.santi.learningspringboot.controller.user;

import com.santi.learningspringboot.dto.request.user.UserRequest;
import com.santi.learningspringboot.dto.response.user.UserResponse;
import com.santi.learningspringboot.mapper.user.UserMapper;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.service.user.UserCreatorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserPostController {
    private final UserCreatorService userCreatorService;

    public UserPostController(UserCreatorService userCreatorService) {
        this.userCreatorService = userCreatorService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest request) {
        User newUser = userCreatorService.create(request);
        UserResponse response = UserMapper.toResponse(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
