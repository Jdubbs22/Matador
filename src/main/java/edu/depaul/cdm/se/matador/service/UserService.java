package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.User;

import java.util.Optional;

// TODO change to MemberService
// all functions  names must change
public interface UserService {
    /**
     * Create new User
     * @param user
     * @return newly created user
     */
    User create(User user);

    /**
     * find the user by userId
     * @param id
     * @return found user
     */
    Optional<User> findUserById(Long id);
}
