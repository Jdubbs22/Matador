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
/**
 *  using JPA format (from book)
 * @author durfm
 */

@Entity
@Getter @Setter
@NoArgsConstructor
public class Instructor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instructorId;
    private String instrName;
    private String imageUrl;
    @Column(columnDefinition = "TEXT")
    private String description;

    // TODO: OneToOne with Member
    @OneToOne(fetch = FetchType.EAGER)
    private User user;

  /*  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "instr_id",referencedColumnName = "instr_id")
    private List<Session> sessions;
*/
}//end Instructor class
