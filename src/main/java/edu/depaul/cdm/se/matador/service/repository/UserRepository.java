package edu.depaul.cdm.se.matador.service.repository;

import edu.depaul.cdm.se.matador.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
