package CinemaJPA.Controllers;

import CinemaJPA.Entities.MovieE;
import CinemaJPA.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/movies")
@Component
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @CrossOrigin(origins = "*")
    @GetMapping(path="/")
    public @ResponseBody
    Iterable<MovieE> getAll() {
        // This returns a JSON or XML with the users
        return movieRepository.findAll();
    }
}
