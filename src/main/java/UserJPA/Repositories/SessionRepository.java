package UserJPA.Repositories;

import UserJPA.Entities.SessionE;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<SessionE, Long> { }
