package repository;

import entity.Cra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CraRepository extends JpaRepository<Cra, Long> {

    // verifier si un collab a deja un CRA pour un mois/année
    Optional<Cra> findByCollaborateurIdAndMoisAndAnnee(Long collaborateurId, int mois, int annee);
}
