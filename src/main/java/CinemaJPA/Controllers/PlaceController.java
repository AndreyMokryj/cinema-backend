package CinemaJPA.Controllers;

import CinemaJPA.Entities.PlaceE;
import CinemaJPA.Repositories.OrderRepository;
import CinemaJPA.Repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/places")
@Component
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private OrderRepository orderRepository;

    private PlaceE getPlace(long id) {
        try {
            Optional<PlaceE> place = placeRepository.findById(id);
            return place.get();
        }
        catch (Exception ex){
            return null;
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/")
    public @ResponseBody
    Iterable<PlaceE> getAll() {
        return placeRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/sid/{sid}")
    public @ResponseBody
    Iterable<PlaceE> getBySID(@PathVariable long sid) {
        // This returns a JSON or XML with the users
        return placeRepository.findBySID(sid);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/select/{id}/user/{user}")
    public boolean selectPlace(@PathVariable long id, @PathVariable String user) {
        PlaceE place = getPlace(id);
        if(place.getStatus() == 0){
            place.setStatus(1);
            place.setUserName(user);
            placeRepository.save(place);
            return true;
        }
        return false;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/unselect/{id}")
    public void unselectPlace(@PathVariable long id) {
        PlaceE place = getPlace(id);
        place.setStatus(0);
        place.setUserName(null);
        placeRepository.save(place);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/unbook/")
    public void unbookPlaces(@RequestBody Iterable<Long> ids) {
        for (Long id : ids) {
            PlaceE placeE = getPlace(id);
            placeE.setStatus(0);
            placeRepository.save(placeE);
        }
    }
}
