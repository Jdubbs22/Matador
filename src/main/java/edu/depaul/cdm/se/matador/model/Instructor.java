/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.matador.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
/**
 *  using JPA format (from book)
 * @author durfm
 */
@Data
@Entity
public class Instructor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long instrId;
    private String instrName;
    private String imageUrl;
    private String description;
  /*  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "instr_id",referencedColumnName = "instr_id")
    private List<Session> sessions;
*/
}//end class
