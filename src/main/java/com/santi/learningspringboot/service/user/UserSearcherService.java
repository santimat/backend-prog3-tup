package com.santi.learningspringboot.service.user;

import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.repository.user.JPAUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserSearcherService {
    private final JPAUserRepository userRepository;

    public UserSearcherService(JPAUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
