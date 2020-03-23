package UserJPA.Controllers;

import UserJPA.Entities.PlaceE;
import UserJPA.Entities.SessionE;
import UserJPA.Entities.UserE;
import UserJPA.Repositories.PlaceRepository;
import UserJPA.Repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/places")
@Component
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;

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
    @GetMapping(path="/select/{id}")
    public boolean selectPlace(@PathVariable long id) {
        PlaceE place = getPlace(id);
        if(place.getStatus() == 0){
            place.setStatus(1);
            placeRepository.save(place);
            return true;
        }
        return false;
    }
}
