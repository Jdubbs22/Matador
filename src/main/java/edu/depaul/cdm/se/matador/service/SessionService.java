package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Session;

public interface SessionService {

    Session create(Session session);

    Session readById(Long id);

    Boolean update(Session session);

    Boolean delete(Session session);
}
