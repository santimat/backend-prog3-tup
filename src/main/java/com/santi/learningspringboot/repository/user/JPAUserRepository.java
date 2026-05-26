package com.santi.learningspringboot.repository.user;

import com.santi.learningspringboot.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAUserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(value = "SELECT * FROM users where email=:email", nativeQuery = true)
        // use Optional<> because User may not exist
    Optional<User> findByEmail(@Param("email") String email);
}
