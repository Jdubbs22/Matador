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
import java.util.Set;

/**
 *
 * @author durfm
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   //private Long memberId;
  //  private Long instructorId;

    //@Temporal(TemporalType.TIME)
    @Column(nullable = false, updatable = true)
    private Date startTime;

    //@Temporal(TemporalType.)
    @Column(nullable = false, updatable = true)
    private Date endTime;
    private String status; //change to enum
    //todo: how to impliment enum below?
 //   private LessonStatus lessonStatus;
    private String description;
    //private String location;
//    private Instant startingTime;
//    private Instant endingTime;
    @ManyToMany
    @JoinColumn(name = "member_id")
    private Set<Member> members;



   @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
   @JoinColumn(name = "instructor_id")
   private Instructor instructor;
}//end class
