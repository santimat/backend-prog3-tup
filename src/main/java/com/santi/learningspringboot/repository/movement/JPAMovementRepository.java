package com.santi.learningspringboot.repository.movement;

import com.santi.learningspringboot.model.movement.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAMovementRepository extends JpaRepository<Movement, Long>, JpaSpecificationExecutor<Movement> {
}
