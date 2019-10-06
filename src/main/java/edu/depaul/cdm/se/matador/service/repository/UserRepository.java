package edu.depaul.cdm.se.matador.service.repository;

import edu.depaul.cdm.se.matador.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// TODO:  change to MemberRepository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);
}
