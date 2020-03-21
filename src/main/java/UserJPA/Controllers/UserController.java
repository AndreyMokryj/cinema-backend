package UserJPA.Controllers;

import UserJPA.Entities.UserE;
import UserJPA.Entities.UserVO;
import UserJPA.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/users")
@Component
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping(path = "/getByUN/{username}")
    public UserE retrieveUser(@PathVariable String username) {
        try {
            Optional<UserE> user = userRepository.findByUN(username);
            return user.get();
        }
        catch (Exception ex){
            return null;
        }
    }

    @GetMapping(path="/")
    public @ResponseBody
    Iterable<UserE> getAll() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
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

    @PostMapping("/")
    public boolean createUser(@RequestBody UserVO userVO) {
        UserE user = UserE.fromVO(userVO);
        UserE savedUser;
        if (retrieveUser(user.getUsername()) == null) {
            savedUser = userRepository.save(user);
            return true;
        }
        return false;
    }

    @PostMapping("/check/")
    public boolean checkUser(@RequestBody UserVO userVO) {
        UserE user = UserE.fromVO(userVO);
        UserE savedUser;
        try {
            savedUser = retrieveUser(user.getUsername());
            return savedUser.getPassword().equals(user.getPassword());
        }
        catch (Exception e) {
            return false;
        }

    }

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
