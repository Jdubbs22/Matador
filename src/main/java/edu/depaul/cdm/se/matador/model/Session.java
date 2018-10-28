/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se.matador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 *
 * @author durfm
 */


@Data
@Entity
public class Session implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   //private Long memberId;
  //  private Long instructorId;
    private String date_time;
//    private Instant startingTime;
//    private Instant endingTime;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


   @ManyToOne
   @JoinColumn(name = "instructor_id", unique = false)
   private Instructor instructor;
}//end class
