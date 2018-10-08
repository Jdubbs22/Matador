package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Member;

import java.util.List;

public interface MemberService {
    /**
     * creates a new member and saves to DB
     * @param member
     * @return  returns the member which was saved into the DB
     * in case of failure return null
     */
    Member create(Member member);

    /**
     * reads info from the DB
     * @param id
     * @return
     */
    Member readById(Long id);

    /**
     * @param member
     * @return returning true if successfully updated false if not
     */
    Boolean update(Member member);

    /**
     *
     * @param member
     * @return returns true if successfully deleted false if not
     */
    Boolean delete(Member member);

    List<Member> getAll();


}
