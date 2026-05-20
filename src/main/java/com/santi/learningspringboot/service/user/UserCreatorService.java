package com.santi.learningspringboot.service.user;

import com.santi.learningspringboot.dto.request.user.UserRequest;
import com.santi.learningspringboot.mapper.user.UserMapper;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.repository.user.JPAUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreatorService {
    private final JPAUserRepository userRepository;

    public UserCreatorService(JPAUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserRequest request) {

        User newUser = UserMapper.toEntity(request);
        return userRepository.save(newUser);
    }
}
