package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.User;
import edu.depaul.cdm.se.matador.model.dto.RoleRequest;
import edu.depaul.cdm.se.matador.model.dto.UserResponse;
import edu.depaul.cdm.se.matador.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class UsersApi {

    private UserService userService;

    public UsersApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody User user) {
        User cratedUser = this.userService.create(user);
        UserResponse response = new UserResponse(user);

         // convert User --> UserResponse
        //also tried cratedUser.toString()
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> createUser(@PathVariable("userId") Long userId) {

        Optional<User> userOption = this.userService.findUserById(userId);
        if (userOption.isPresent()) {
            return ResponseEntity.ok(userOption.get());
           // return new ResponseEntity<User>(userOption.get(), HttpStatus.OK);
        }
       // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{userId}")  //this is in userRoleApi...is this needed twice?
    public ResponseEntity<User> userRole(@RequestBody RoleRequest request,@PathVariable("userId") Long id){
        return null;
    }
}
