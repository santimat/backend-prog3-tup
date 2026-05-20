package com.santi.learningspringboot.repository.user;

import com.santi.learningspringboot.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
