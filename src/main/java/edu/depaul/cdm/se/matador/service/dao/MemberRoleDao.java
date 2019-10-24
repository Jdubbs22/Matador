package edu.depaul.cdm.se.matador.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

@Component
public class MemberRoleDao {
    @Autowired
    private EntityManager manager;

    @Transactional
    public int addRole(Long userId, String role) {
        String value = String.format("(%s, '%s')",userId, role);
        Query query = this.manager.createNativeQuery("insert into member_role(member_id, role) values " + value);
        query.setFlushMode(FlushModeType.COMMIT);
        // TODO: how to force this transaction to commit before returning 
        return query.executeUpdate();
//        if(role== "INSTRUCTOR"){  //this doesn't work, just trying stuff to understand
//
//            Query query2 = this.manager.createNativeQuery("insert into instructor(instructor_id, member_id) value(1, 1)");
//
//            query.setFlushMode(FlushModeType.COMMIT);
//        }
    }


}

/*
a data access object (DAO) is an object that provides an abstract interface to some type of database
 or other persistence mechanism. By mapping application calls to the persistence layer,
 the DAO provides some specific data operations without exposing details of the database.

 I did this because the role was a specific metric that is common to all (admin,trainer,user)
 but doesn't have the same characteristics of said users
 */