package edu.depaul.cdm.se.matador.repository;

import edu.depaul.cdm.se.matador.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findOneById(Long id);

    List<Session> findAll();

}
