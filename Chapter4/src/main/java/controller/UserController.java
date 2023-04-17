package controller;

import com.challenge4.Chapter4.model.Userss;
import com.challenge4.Chapter4.services.UserService;
import com.challenge4.Chapter4.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private static final Map<String, Object> mapParams = new HashMap<String, Object>();
    private static final String SUCCESS_MSG = "Successfully retrieved data!";
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user")
    public ResponseEntity<Object> findAllOrByArgument(
            @RequestParam(value = "username", required = false) String username
    ){
        Userss userssList = null;
        if(username != null){
            userssList = userService.findByusername(username);
        }
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK, userssList);
    }
    @PostMapping("/user")
    public ResponseEntity<Object> save(@RequestBody Userss userss){
        userService.save(userss);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK, userss);
    }
    @PutMapping("/user")
    public ResponseEntity<Object> update(@RequestBody Userss userss){
        userService.update(userss);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK, userss);
    }
    @DeleteMapping("User")
    public ResponseEntity<Object> delete(@PathVariable String username){
        userService.delete(username);
        return ResponseHandler.generateResponse(SUCCESS_MSG, HttpStatus.OK, username);
    }
}
