package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructor")
public class InstructorRestApi {

    @Autowired
    private InstructorRepository instrRepo;



}//end class
