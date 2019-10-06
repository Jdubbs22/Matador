package edu.depaul.cdm.se.matador.service.repository;

import edu.depaul.cdm.se.matador.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {

    Instructor findByInstructorId(Long id);
}
