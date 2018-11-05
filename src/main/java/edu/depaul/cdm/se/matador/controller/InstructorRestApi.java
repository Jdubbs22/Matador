package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorRestApi {

    @Autowired
    private InstructorRepository instrRepo;

    @GetMapping("")
    public HttpEntity<?> getInstructors() {
        List<Instructor> instructorList = this.instrRepo.findAll();
        return  new ResponseEntity<>(instructorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getInstructor(@PathVariable("id") Long id) {
        Instructor instructor = this.instrRepo.findInstructorByInstrId(id);
        return  new ResponseEntity<>(instructor, HttpStatus.OK);
    }


}//end class
