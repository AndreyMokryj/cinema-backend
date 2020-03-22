package UserJPA.Controllers;

import UserJPA.Entities.PlaceE;
import UserJPA.Entities.SessionE;
import UserJPA.Repositories.PlaceRepository;
import UserJPA.Repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/places")
@Component
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;

//    @Autowired
//    private SessionRepository sessionRepository;

//    @GetMapping(path = "/getByUN/{username}")
//    public UserE retrieveUser(String username) {
//        try {
//            Optional<UserE> user = userRepository.findByUN(username);
//            return user.get();
//        }
//        catch (Exception ex){
//            return null;
//        }
//    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/")
    public @ResponseBody
    Iterable<PlaceE> getAll() {
//        Iterable<SessionE> sessions = sessionRepository.findAll();
//        List<SessionE> sessionEList = (List<SessionE>) sessions;
//        List<PlaceE> placees = new ArrayList<>();
//        for (SessionE session : sessionEList){
//            for (int row = 1; row <= 10; row++){
//                for (int column = 1; column <= 20; column++){
//                    PlaceE place = new PlaceE();
//                    place.setSessionId(session.getId());
//                    place.setRow(row);
//                    place.setColumn(column);
//
//                    placeRepository.save(place);
//                }
//            }
//        }
        return placeRepository.findAll();
    }

//    @GetMapping("/{id}")
//    public UserE retrieveUser(@PathVariable long id) {
//        try {
//            Optional<UserE> userE = userRepository.findById(id);
//            return userE.get();
//        }
//        catch (NoSuchElementException ex){
////            throw new ItemNotFoundException("User with id=" + id + " doesn't exist");
//        }
//        return null;
//    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable long id) {
//        try {
//            userRepository.deleteById(id);
//
//        }
//        catch (org.springframework.dao.EmptyResultDataAccessException ex){
////            ow new ItemNotFoundException("Region with id=" + id + " doesn't exist");
//        }
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateUser(@RequestBody UserVO userVO, @PathVariable Long id) {
//        try {
//            Optional<UserE> userOptional = userRepository.findById(id);
//
//            if (userOptional.get() == null) ;
//
//            UserE user = UserE.fromVO(userVO);
////            user.setId(id);
//            userRepository.save(user);
//
////            userRepository.deleteRoles(user.getUsername());
////            roleRepository.save(new Role(user.getUsername(), "ROLE_USER"));
////            if(userVO.getIsadmin())
////                roleRepository.save(new Role(user.getUsername(), "ROLE_ADMIN"));
//            String message = "User updated: " + user.toLog();
//
////            writeLog(message);
//            return ResponseEntity.noContent().build();
//        }
//        catch (NoSuchElementException ex){
////            String message = "User with id = " + id + " does not exist";
////            writeLog(message);
////            throw new ItemNotFoundException("User with id=" + id + " doesn't exist");
//        }
//        return null;
//    }
}
