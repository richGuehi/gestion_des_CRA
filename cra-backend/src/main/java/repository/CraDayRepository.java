package repository;

import entity.CraDay;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CraDayRepository extends CrudRepository<CraDay, Long> {

    // tous les jours rattaché a un CRA
    List<CraDay> findByCraId(Long craId);
}
