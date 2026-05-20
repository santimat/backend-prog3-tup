package com.santi.learningspringboot.model.user;

import jakarta.persistence.*;
import jakarta.annotation.Nullable;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = true)
    private Long dni;

    public User() {
    }

    public User(Long id, String username, String password, String email, @Nullable Long dni) {
        this.id = id;
        this.username = username;
        this.password = password;
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
