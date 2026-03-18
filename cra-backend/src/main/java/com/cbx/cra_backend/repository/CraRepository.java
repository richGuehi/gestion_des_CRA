package com.cbx.cra_backend.repository;

import com.cbx.cra_backend.entity.Cra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CraRepository extends JpaRepository<Cra, Long> {

    // verifier si un collab a deja un CRA pour un mois/année
    Optional<Cra> findByCollaborateurIdAndMoisAndAnnee(Long collaborateurId, int mois, int annee);
}
