package edu.depaul.cdm.se.matador.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
public class UserRoleDao {
    @Autowired
    private EntityManager manager;

    @Transactional
    public int addRole(Long userId, String role) {
        String value = String.format("(%s, '%s')",userId, role);
        Query query = this.manager.createNativeQuery("insert into user_role(user_id, role) values " + value);
        return query.executeUpdate();
    }
}
