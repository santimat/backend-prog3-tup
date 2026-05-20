package com.santi.learningspringboot.dto.response.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @Nullable
    private Long dni;

    public UserResponse() {
    }

    public UserResponse(Long id, String username, String email, @Nullable Long dni) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
