package com.santi.learningspringboot.service.auth;

public class UserNotFoundByEmailException extends RuntimeException {
    public UserNotFoundByEmailException(String email) {
        super("User with email " + email + " not found");
    }
}
