package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Member;

import java.util.Optional;

// TODO change to MemberService
// all functions  names must change
public interface MemberService {
    /**
     * Create new User
     * @param member
     * @return newly created user
     */
    Member create(Member member);

    /**
     * find the user by userId
     * @param id
     * @return found user
     */
    Optional<Member> findUserById(Long id);
}
