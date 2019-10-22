package edu.depaul.cdm.se.matador.service.repository;

import edu.depaul.cdm.se.matador.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    @Override
    Optional<Member> findById(Long aLong);

//    @Override
//    Optional<Lesson> findAllLessons(Long id);
}
