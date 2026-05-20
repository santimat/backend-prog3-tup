package com.santi.learningspringboot.dto.request.user;

import jakarta.annotation.Nullable;

public class UserUpdatable {

    @Nullable
    private String username;
    @Nullable
    private String password;
    @Nullable
    private String email;
    @Nullable
    private Long dni;

    public UserUpdatable() {
    }

    public UserUpdatable(@Nullable String username, @Nullable String password, @Nullable String email, @Nullable Long dni) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dni = dni;
    }


    @Nullable
    public String getUsername() {
        return username;
    }

    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
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
