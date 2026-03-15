package repository;

import entity.Mission;
import org.springframework.data.repository.CrudRepository;

public interface MissionRepository extends CrudRepository<Mission, Long> {
}
