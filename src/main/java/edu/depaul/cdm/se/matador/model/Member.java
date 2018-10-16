/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.matador.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *  JPA  
 * @author durfm
 */
@Data
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)  // not sure if this is needed ask to clarify when used

public class Member implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String username;

    @JsonIgnore
    private String password;

//    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",referencedColumnName = "id")
    private List<Session> sessions;

    @JsonIgnore
    public List<Session> getSessions() {
        return this.sessions;
    }
    public Member() {
    }


}//end class
