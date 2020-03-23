package UserJPA.Controllers;

import UserJPA.Entities.MovieE;
import UserJPA.Entities.UserE;
import UserJPA.Repositories.MovieRepository;
import UserJPA.Repositories.UserRepository;
import UserJPA.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
