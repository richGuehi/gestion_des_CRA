package com.cbx.cra_backend.repository;

import com.cbx.cra_backend.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCollaborateurId(Long collaborateurId);
}
