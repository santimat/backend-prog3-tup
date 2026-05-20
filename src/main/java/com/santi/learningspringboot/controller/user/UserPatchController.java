package com.santi.learningspringboot.controller.user;

import com.santi.learningspringboot.dto.request.user.UserUpdatable;
import com.santi.learningspringboot.dto.response.user.UserResponse;
import com.santi.learningspringboot.mapper.user.UserMapper;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.service.user.UserUpdaterPartiallyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserPatchController {
    private final UserUpdaterPartiallyService userUpdaterPartiallyService;

    public UserPatchController(UserUpdaterPartiallyService userUpdaterPartiallyService) {
        this.userUpdaterPartiallyService = userUpdaterPartiallyService;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updatePartially(@RequestBody @Valid UserUpdatable request, @PathVariable Long id) {
        User updatedUser = userUpdaterPartiallyService.update(request, id);
        UserResponse response = UserMapper.toResponse(updatedUser);
        return ResponseEntity.ok(response);
    }
}
