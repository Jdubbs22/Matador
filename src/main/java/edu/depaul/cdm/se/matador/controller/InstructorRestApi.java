//package edu.depaul.cdm.se.matador.controller;
//
//import edu.depaul.cdm.se.matador.model.Instructor;
//import edu.depaul.cdm.se.matador.service.repository.InstructorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/instructors")
//public class InstructorRestApi {
//
//    @Autowired
//    private InstructorRepository instrRepo;
//
//    @GetMapping("")
//    public HttpEntity<?> getInstructors() {
//        List<Instructor> instructorList = this.instrRepo.findAll();
//        return  new ResponseEntity<>(instructorList, HttpStatus.OK);
//    }//end method
//
//    @GetMapping("/{id}")
//    public HttpEntity<?> getInstructor(@PathVariable("id") Long id) {
//        Instructor instructor = this.instrRepo.findInstructorByInstrId(id);
//        return  new ResponseEntity<>(instructor, HttpStatus.OK);
//<<<<<<< HEAD
//    }//end method
//
//=======
//    }
///*
//The usage of HttpEntity is an alternative to using the two parameter:
//@RequestHeader HttpHeaders and @RequestBody String/backing type
//
//HttpEntity can be used to return response as well. The additional advantage in this case,
//when comparing with @ResponseBody is, it can include the headers in the response as well.
//from: https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/http-entity.html
// */
//>>>>>>> 50899101515fbbe49e14012c3886c038c970e1d9
//
//}//end class
