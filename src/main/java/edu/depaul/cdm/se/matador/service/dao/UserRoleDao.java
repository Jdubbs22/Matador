package edu.depaul.cdm.se.matador.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

@Component
public class UserRoleDao {
    @Autowired
    private EntityManager manager;

    @Transactional
    public int addRole(Long userId, String role) {
        String value = String.format("(%s, '%s')",userId, role);
        Query query = this.manager.createNativeQuery("insert into user_role(user_id, role) values " + value);
        query.setFlushMode(FlushModeType.COMMIT);
        // TODO: how to force this transaction to commit before returning 
        return query.executeUpdate();
    }
}

/*
a data access object (DAO) is an object that provides an abstract interface to some type of database
 or other persistence mechanism. By mapping application calls to the persistence layer,
 the DAO provides some specific data operations without exposing details of the database.

 I did this because the role was a specific metric that is common to all (admin,trainer,user)
 but doesn't have the same characteristics of said users
 */