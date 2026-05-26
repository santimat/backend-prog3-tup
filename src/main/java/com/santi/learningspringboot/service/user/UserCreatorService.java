package com.santi.learningspringboot.service.user;

import com.santi.learningspringboot.dto.request.user.UserRequest;
import com.santi.learningspringboot.mapper.user.UserMapper;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.repository.user.JPAUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCreatorService {
    private final JPAUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserCreatorService(JPAUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(UserRequest request) {
        User newUser = UserMapper.toEntity(request);
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        newUser.setPassword(hashedPassword);
        return userRepository.save(newUser);
    }
}
