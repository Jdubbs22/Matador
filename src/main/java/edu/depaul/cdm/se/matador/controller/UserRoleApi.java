package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.User;
import edu.depaul.cdm.se.matador.model.dto.RoleRequest;
import edu.depaul.cdm.se.matador.model.dto.UserResponse;
import edu.depaul.cdm.se.matador.service.UserRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserRoleApi {

    private UserRoleService userRoleService;

    public UserRoleApi(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PutMapping("/userRole/{userId}")
    public ResponseEntity<UserResponse> addRole(@PathVariable("userId") Long userId,
                                                @RequestBody RoleRequest request) {
        User user = this.userRoleService.addRole(userId, request.getRole());
        // TODO: what if user does exist?
        // TODO: what if user is null?
        // TODO: What if the role is illegal? Role doesn't exist
        UserResponse userResponse = new UserResponse(user);
        //HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
    }
}
