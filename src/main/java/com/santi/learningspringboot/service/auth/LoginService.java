package com.santi.learningspringboot.service.auth;

import com.santi.learningspringboot.dto.request.auth.LoginRequest;
import com.santi.learningspringboot.dto.response.auth.LoginResponse;
import com.santi.learningspringboot.exception.auth.WrongPasswordException;
import com.santi.learningspringboot.model.user.User;
import com.santi.learningspringboot.repository.user.JPAUserRepository;
import com.santi.learningspringboot.service.jwt.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final JPAUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginService(JPAUserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        String requestEmail = request.getEmail();
        User user = userRepository.findByEmail(requestEmail)
                .orElseThrow(() -> new UserNotFoundByEmailException(requestEmail));

        // check if both are equal
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new WrongPasswordException();
        }
        String token = jwtService.generateToken(requestEmail);
        return new LoginResponse(token);
    }
}
