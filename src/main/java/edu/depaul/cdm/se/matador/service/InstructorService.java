package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.model.dto.InstructorResponse;

import java.util.List;
import java.util.Optional;

public interface InstructorService {

    List <InstructorResponse> getAllInstResp();
    List<Instructor> getAll();

    Instructor create(Member member);
   Optional<Instructor> findInstructorById(Long id);

    Instructor updateInstructor(Long id, String description);
}
