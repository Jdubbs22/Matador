package edu.depaul.cdm.se.matador.model.dto;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private Set<String> roles;  //was role instead of string

    public UserResponse() {}

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNumber= user.getPhoneNumber();
        this.roles = new HashSet<>(); // new TreeSet();
        for (Role r: user.getRoles()) {
            roles.add(r.getRoleName());
        }
        //this.roles = user.getRoles();
        // for each Role in user.getRoles()
        // add Roles.getRoleName into this.roles


    }


}
