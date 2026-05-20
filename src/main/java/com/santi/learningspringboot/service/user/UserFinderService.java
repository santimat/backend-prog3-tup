package com.santi.learningspringboot.service.user;

import com.santi.learningspringboot.exception.user.UserNotFoundException;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.repository.user.JPAUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFinderService {
    private final JPAUserRepository userRepository;

    public UserFinderService(JPAUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
