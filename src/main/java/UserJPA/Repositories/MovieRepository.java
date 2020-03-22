package UserJPA.Repositories;

import UserJPA.Entities.MovieE;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieE, Long> { }
