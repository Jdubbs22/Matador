package edu.depaul.cdm.se.matador.controller;


import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class InstructorApi {


    private InstructorService instructorSv;

    public InstructorApi(InstructorService instructorSv) {
        this.instructorSv = instructorSv;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> list = this.instructorSv.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
