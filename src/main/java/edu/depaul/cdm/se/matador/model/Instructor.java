/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.matador.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    

}//end class
