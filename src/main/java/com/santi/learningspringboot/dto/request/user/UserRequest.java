package com.santi.learningspringboot.dto.request.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @Nullable
    private Long dni;

    public UserRequest() {
    }

    public UserRequest(String username, String password, String email, @Nullable Long dni) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Nullable
    public Long getDni() {
        return dni;
    }

    public void setDni(@Nullable Long dni) {
        this.dni = dni;
    }
}
