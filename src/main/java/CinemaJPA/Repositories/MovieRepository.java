package CinemaJPA.Repositories;

import CinemaJPA.Entities.MovieE;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieE, Long> { }
