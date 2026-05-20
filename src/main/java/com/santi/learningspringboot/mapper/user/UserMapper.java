package com.santi.learningspringboot.mapper.user;

import com.santi.learningspringboot.dto.request.user.UserRequest;
import com.santi.learningspringboot.dto.response.user.UserResponse;
import com.santi.learningspringboot.model.user.User;

public class UserMapper {
    public static User toEntity(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setDni(request.getDni());
        return user;
    }

    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setDni(user.getDni());
        return response;
    }
}
