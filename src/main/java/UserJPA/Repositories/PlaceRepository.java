package UserJPA.Repositories;

import UserJPA.Entities.PlaceE;
import UserJPA.Entities.SessionE;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

public interface PlaceRepository extends CrudRepository<PlaceE, Long> {
    @Query("SELECT p FROM places p where p.sessionId = :idd")
    @Transactional
    public Iterable<PlaceE> findBySID(@PathVariable Long idd);
}
