package com.santi.learningspringboot.controller.user;

import com.santi.learningspringboot.dto.response.user.UserResponse;
import com.santi.learningspringboot.mapper.user.UserMapper;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.service.user.UserSearcherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersGetController {
    private final UserSearcherService userSearcherService;

    public UsersGetController(UserSearcherService userSearcherService) {
        this.userSearcherService = userSearcherService;
    }

    @GetMapping()
    public ResponseEntity<Page<UserResponse>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> usersPerPage = userSearcherService.getAll(pageable);
        return ResponseEntity.ok(usersPerPage.map(UserMapper::toResponse));
    }
}
