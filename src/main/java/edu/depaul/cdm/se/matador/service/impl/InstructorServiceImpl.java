package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.model.dto.InstructorResponse;
import edu.depaul.cdm.se.matador.service.InstructorService;
import edu.depaul.cdm.se.matador.service.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instrRepo;

    public InstructorServiceImpl(InstructorRepository instrRepo){
        this.instrRepo = instrRepo;
    }

    @Override
    public List<InstructorResponse> getAllInstResp() {
        return null;
    }

    @Override
    public List<Instructor> getAll() {
        return this.instrRepo.findAll();
    }

    @Override
    public Instructor create(Member member) {
        Instructor instructor = new Instructor();
        instructor.setMember(member);
        instructor.setInstructorId(member.getId());
        instructor.setStartDate(new Date());
        return instrRepo.save(instructor);
    }

    @Override
    public Optional<Instructor> findInstructorById(Long id) {
        return this.instrRepo.findByInstructorId(id);
    }

    @Override
    public Instructor updateInstructor(Long id, String description) {

        return null;
    }



}
