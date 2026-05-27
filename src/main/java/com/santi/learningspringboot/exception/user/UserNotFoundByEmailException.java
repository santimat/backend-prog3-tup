package com.santi.learningspringboot.exception.user;

public class UserNotFoundByEmailException extends RuntimeException {
    public UserNotFoundByEmailException(String email) {
        super("User with email " + email + " not found");
    }
}
