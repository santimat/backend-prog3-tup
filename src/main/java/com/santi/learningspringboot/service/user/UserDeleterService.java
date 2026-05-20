package com.santi.learningspringboot.service.user;

import com.santi.learningspringboot.repository.user.JPAUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDeleterService {
    private final JPAUserRepository userRepository;
    private final UserFinderService userFinderService;

    public UserDeleterService(JPAUserRepository userRepository, UserFinderService userFinderService) {
        this.userRepository = userRepository;
        this.userFinderService = userFinderService;
    }

    public void deleteById(Long id) {
        userFinderService.findById(id);
        userRepository.deleteById(id);
    }
}
