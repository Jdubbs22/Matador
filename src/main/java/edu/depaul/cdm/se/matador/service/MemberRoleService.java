package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Member;

// TODO: change MemberRoleService
public interface MemberRoleService {
    /**
     * Add roleName to userId
     * @param userId
     * @param roleName
     * @return updated User
     */
    Member addRole(Long userId, String roleName);
}
