package edu.depaul.cdm.se.matador.controller;


import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.model.dto.InstructorResponse;
import edu.depaul.cdm.se.matador.service.InstructorService;
import edu.depaul.cdm.se.matador.service.impl.InstructorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class InstructorApi {


    private InstructorService instructorSv;
    private InstructorServiceImpl instrSvImp;
    public InstructorApi(InstructorService instructorSv) { //do I need to add InstructorServiceImpl instrSvImp?
        this.instructorSv = instructorSv;
        //this.instrSvImp
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<InstructorResponse>> getAllInstructors( ) {

        List<Instructor> list = this.instructorSv.getAll();
        List<InstructorResponse> responseList = new ArrayList<>(list.size());
        // copy each element from list to responseList
        for (Instructor i:list) {
           InstructorResponse response = new InstructorResponse();
           response.setName(i.getMember().getFirstName()+" "+i.getMember().getLastName());
           response.setImageUrl(i.getImageUrl());
           response.setInstructorId(i.getInstructorId());
           response.setStartDate(i.getStartDate());
           responseList.add(response);
        }

        return new ResponseEntity(responseList, HttpStatus.OK);
    }

    @GetMapping("instructors/{instructorId}")
    public ResponseEntity<InstructorResponse> findInstructor(@PathVariable("instructorId")Long instuctorId){
        Optional<Instructor> instrOption = this.instructorSv.findInstructorById(instuctorId);
        if(instrOption.isPresent()){
            Instructor instructor = instrOption.get();
            InstructorResponse response = new InstructorResponse(instructor);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }


}
