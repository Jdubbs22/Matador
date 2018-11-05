package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Session;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionService {

    Session create(Session session);

    Session readById(Long id);

    Boolean update(Session session);

    Boolean delete(Session session);

    public List<Session> getAll();

    @Query("select id,date_time,instructor_id from session where member_id = ?1")
    List<Session> findByMemberId(Long id);

    @Query("select id,date_time from session where instrId = 30")
    List<Session> findByInstructorId();  //Long id if not hard coded like above

    List<Session> findOpenSession(Long instructorId);
}
