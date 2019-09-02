package edu.depaul.cdm.se.matador.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
public class Role {

// For Jpa
    public Role() {
    }

    @Id
    private String roleName;

    @Column(unique = true)
    private Long priority;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.DETACH,
    fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }

}


