/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.matador.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *  using JPA format (from book)
 * @author durfm
 */

@Entity
@Getter @Setter
@NoArgsConstructor
public class Instructor implements Serializable{
    @Id
    private Long instructorId;
    private Date startDate;
   // private String name;
    private String imageUrl;
//    private  String first_name;
//    private String last_name;
//test to see if new branch added (if in github)

    @Column(columnDefinition = "TEXT")
    private String description;

    // TODO: OneToOne with Member
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(
            name = "memberId", unique = true, nullable = false, updatable = false
    )
    private Member member;


  /*  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "instr_id",referencedColumnName = "instr_id")
    private List<Session> sessions;
*/
}//end Instructor class
