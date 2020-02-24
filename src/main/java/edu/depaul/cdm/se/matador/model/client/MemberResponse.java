package edu.depaul.cdm.se.matador.model.client;

import edu.depaul.cdm.se.matador.model.Role;
import edu.depaul.cdm.se.matador.model.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MemberResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private Set<String> roles;  //was role instead of string

    public MemberResponse() {}

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.phoneNumber= member.getPhoneNumber();
        this.roles = new HashSet<>(); // new TreeSet();
        for (Role r: member.getRoles()) {
            roles.add(r.getRoleName());
        }
        //this.roles = user.getRoles();
        // for each Role in user.getRoles()
        // add Roles.getRoleName into this.roles


    }


}
