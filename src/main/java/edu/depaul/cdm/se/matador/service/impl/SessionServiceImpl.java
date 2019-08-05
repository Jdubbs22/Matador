package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Session;
import edu.depaul.cdm.se.matador.dao.repository.SessionRepository;
import edu.depaul.cdm.se.matador.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    private SessionRepository sessionRepo;
    @Autowired
    public SessionServiceImpl (SessionRepository sessionRepo){ this.sessionRepo = sessionRepo;}


    @Override
    public Session create(Session session) {
        if (session == null) {
            throw new IllegalArgumentException("Session must not be null");
        }//end if
        if (session.getId() != null) {
            Session s = this.sessionRepo.findOneById(session.getId());
            if (s != null) {
                throw new IllegalStateException("The session already exists in the DB");
            }//end internal if
            else {
                return this.sessionRepo.save(session);
            }//end else
        }//end if
            else{
                return this.sessionRepo.save(session);
        }//end if
    }//end create

    @Override
    public Session readById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }//end if


        return  this.sessionRepo.findOneById(id);
    }

    @Override
    public Boolean update(Session session) {
        return null;
    }

    @Override
    public Boolean delete(Session session) {
        return null;
    }

    @Override
    public List<Session> getAll() {
        return sessionRepo.findAll();
    }

    @Override
    public List<Session> findByMemberId(Long id) {
        return sessionRepo.findByMemberId(id);
    }

    @Override
    public List<Session> findByInstructorId() {
        return sessionRepo.findAll();
    }

    @Override
    public List<Session> findOpenSession(Long instructorId) {
        return this.sessionRepo.findOpenSessions(instructorId);
    }
}//end class

