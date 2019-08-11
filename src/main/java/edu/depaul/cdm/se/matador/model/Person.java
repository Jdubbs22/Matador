package edu.depaul.cdm.se.matador.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Role> roles;
}
