package CinemaJPA.Controllers;

import CinemaJPA.Entities.OrderE;
import CinemaJPA.Entities.PlaceE;
import CinemaJPA.Entities.UserE;
import CinemaJPA.Repositories.OrderRepository;
import CinemaJPA.Repositories.PlaceRepository;
import CinemaJPA.Repositories.UserRepository;
import CinemaJPA.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/orders")
@Component
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    private UserE retrieveUser(String username) {
        try {
            Optional<UserE> user = userRepository.findByUN(username);
            return user.get();
        }
        catch (Exception ex){
            return null;
        }
    }

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
    Iterable<OrderE> getAll() {
        return orderRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/user/{user}")
    public @ResponseBody
    Iterable<OrderE> getByUN(@PathVariable String user) {
        // This returns a JSON or XML with the users
        return orderRepository.findByUN(user);
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path="/book/")
    public boolean bookPlaces(@RequestBody OrderVO orderVO) {
        OrderE order = OrderE.fromVO(orderVO);
        if (retrieveUser(orderVO.getUsername()) == null){
            return false;
        }

        for (Long id : orderVO.getPlaceIds()) {
            PlaceE placeE = getPlace(id);
            if (placeE.getStatus() != 2) {
                placeE.setStatus(2);
                placeRepository.save(placeE);
            }
            else {
                return false;
            }
        }
        orderRepository.save(order);

        for (Long id : orderVO.getPlaceIds()) {
            PlaceE placeE = getPlace(id);
            placeE.setUsername(orderVO.getUsername());
            placeRepository.save(placeE);
        }
        return true;
    }
}
