package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.service.InstructorService;
import edu.depaul.cdm.se.matador.service.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instrRepo;

    public InstructorServiceImpl(InstructorRepository instrRepo){
        this.instrRepo = instrRepo;
    }
    @Override
    public List<Instructor> getAll() {
        return this.instrRepo.findAll();
    }
}
