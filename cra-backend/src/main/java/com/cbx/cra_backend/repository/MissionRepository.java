package com.cbx.cra_backend.repository;

import com.cbx.cra_backend.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
