package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.User;

public interface UserRoleService {
    /**
     * Add roleName to userId
     * @param userId
     * @param roleName
     * @return updated User
     */
    User addRole(Long userId, String roleName);
}
