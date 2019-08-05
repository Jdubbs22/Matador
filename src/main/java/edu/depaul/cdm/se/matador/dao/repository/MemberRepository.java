package edu.depaul.cdm.se.matador.dao.repository;

import edu.depaul.cdm.se.matador.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository <Member, Long> {

    List<Member> findAll();

    Member findOneById(Long id);
}
