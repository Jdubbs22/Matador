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
import javax.persistence.ManyToOne;

/**
 *
 * @author durfm
 */
@Entity
public class Session implements Serializable{
    @ManyToOne
    private Instructor instructor;
    @ManyToOne
    private Members members;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long activId;
    private long memberId;
    private long InstrId;
    private String dateTime;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public long getActivId() {
        return activId;
    }

    public void setActivId(long activId) {
        this.activId = activId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getInstrId() {
        return InstrId;
    }

    public void setInstrId(long InstrId) {
        this.InstrId = InstrId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    
}//end class
