package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Instructor;

public interface InstructorService {

    Instructor create(Instructor instructor);

    Instructor readById(Long id);

    Boolean update(Instructor instructor);

    Boolean delete(Instructor instructor);

}
