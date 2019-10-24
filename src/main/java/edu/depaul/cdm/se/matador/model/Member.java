package edu.depaul.cdm.se.matador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter @Setter

public class Member {

// For Jpa
    public Member() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "member_role",
            joinColumns = @JoinColumn(name = "MEMBER_ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ROLE", nullable = false)
    )
    private Set<Role> roles = new HashSet<>();
}

