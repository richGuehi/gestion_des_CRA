package repository;

import entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
