package edu.depaul.cdm.se.matador.dao.repository;

import edu.depaul.cdm.se.matador.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findOneById(Long id);

    List<Session> findAll();
  //  List<Session> findByInstructor();
    @Query("select s from Session s where s.instructor.instrId = :instructId and s.member = null")
    List<Session> findOpenSessions(@Param("instructId") Long instrId);

    @Query("select s from Session s where s.member.id = :memberId")
    List<Session> findByMemberId(@Param("memberId")Long memberId);
}
//test line