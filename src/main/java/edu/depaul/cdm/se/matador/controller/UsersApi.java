package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.User;
import edu.depaul.cdm.se.matador.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UsersApi {

    private UserService userService;

    public UsersApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User cratedUser = this.userService.create(user);
        return new ResponseEntity<>(cratedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> createUser(@PathVariable("userId") Long userId) {


        return null;
    }
}
