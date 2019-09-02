package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.User;

public interface UserService {
    /**
     * Create new User
     * @param user
     * @return newly created user
     */
    User create(User user);
}
