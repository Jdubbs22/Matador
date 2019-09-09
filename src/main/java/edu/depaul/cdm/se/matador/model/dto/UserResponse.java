package edu.depaul.cdm.se.matador.model.dto;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private Set<Role> roles;

    public UserResponse() {}
    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNumber= user.getPhoneNumber();
        this.roles = user.getRoles();
    }


}
