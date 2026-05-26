package com.santi.learningspringboot.service.user;

import com.santi.learningspringboot.dto.request.user.UserUpdatable;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.repository.user.JPAUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserUpdaterPartiallyService {

    private final JPAUserRepository userRepository;
    private final UserFinderService userFinderService;
    private final PasswordEncoder passwordEncoder;

    public UserUpdaterPartiallyService(JPAUserRepository userRepository, UserFinderService userFinderService,
                                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userFinderService = userFinderService;
        this.passwordEncoder = passwordEncoder;
    }

    public User update(UserUpdatable request, Long id) {
        User existingUser = userFinderService.findById(id);

        if (request.getUsername() != null) existingUser.setUsername(request.getUsername());
        if (request.getEmail() != null) existingUser.setEmail(request.getEmail());
        if (request.getPassword() != null) {
            String hashedPassword = passwordEncoder.encode(request.getPassword());
            existingUser.setPassword(hashedPassword);
        }
        if (request.getDni() != null) existingUser.setDni(request.getDni());
        return userRepository.save(existingUser);
    }

}
