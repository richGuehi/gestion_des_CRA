package com.cbx.cra_backend.repository;

import com.cbx.cra_backend.entity.CraDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CraDayRepository extends JpaRepository<CraDay, Long> {

    // tous les jours rattaché a un CRA
    List<CraDay> findByCraId(Long craId);
}
