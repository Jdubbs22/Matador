package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InstructorServiceImpl implements  InstructorService {

    private InstructorRepository instrRepo;
    @Autowired
    public InstructorServiceImpl(InstructorRepository instrRepo){
        this.instrRepo = instrRepo;
    }


    @Override
    public Instructor create(Instructor instructor) {
        return null;
    }

    @Override
    public Instructor readById(Long id) {
        return null;
    }

    @Override
    public Boolean update(Instructor instructor) {
        return null;
    }

    @Override
    public Boolean delete(Instructor instructor) {
        return null;
    }
}
