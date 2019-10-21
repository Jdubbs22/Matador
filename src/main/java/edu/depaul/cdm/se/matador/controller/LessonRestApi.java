package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.Lesson;
import edu.depaul.cdm.se.matador.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class LessonRestApi {



    // TODO: create lesson service, inject here
    @Autowired
    private LessonService lessonService;


    @GetMapping("/lessons")
    public ResponseEntity<List<Lesson>> getAll(@RequestParam("instructorId") Long instructorId) {
        List<Lesson> lessons = this.lessonService.findByInstructorId(instructorId);

        List<Lesson> response = lessons.stream()
                .map(lesson -> {
                    //lesson.setInstructor(null);
                    return lesson;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(lessons, HttpStatus.OK);

    }

//    @PostMapping("")
//    public HttpEntity<?> createSession(@RequestBody Session session) {
//        return new ResponseEntity<>(this.sessionRepo.save(session), HttpStatus.OK);
//    }
//
//    @GetMapping("/sessions")
//    public HttpEntity<?> getAllSessions() {
//
//        List<Session> sessionList = this.sessionService.getAll();
//        return new ResponseEntity<>(sessionList, HttpStatus.OK);
//    }
//
//    @GetMapping("/instructorSession")
//       public  HttpEntity<?> findByInstructorId(){
//        List<Session> sessionList=this.sessionService.findByInstructorId();
//        return new ResponseEntity<>(sessionList,HttpStatus.OK);
//    }
//
//
//    @GetMapping("/memberSession")  // this is not working...why?
//  //  public HttpEntity<?> findByInventoryIdIn(List<Long> sessionList){
//      //  List<Session> sessionList = this.sessionService.getAll();
//        public HttpEntity<?> findBymemberId(@RequestParam("memberId") Long memberId){
//
//
//        List<Session> sessionList = this.sessionService.findByMemberId(memberId);
//        return new ResponseEntity<>(sessionList, HttpStatus.OK);
//       // return null;
//    }
//
//    @GetMapping("/openSession")
//    public HttpEntity<?> getOpenSession(@RequestParam("instructId") Long instructorId){
//        return new ResponseEntity<>(this.sessionService.findOpenSession(instructorId), HttpStatus.OK);
//    }
//
//
//    /**
//     * This method ....
//     * @param sessionId
//     * @param memberId
//     * @return
//     */
//    @GetMapping("/assignMember")
//    public HttpEntity<?> assignMember(@RequestParam("sessionId") Long sessionId,
//                                      @RequestParam("memberId") Long memberId) {
//
//            Session session = this.sessionRepo.findOneById(sessionId);
//            Member member = this.memberRepo.findOneById(memberId);
//            session.setMember(member);
//
//            return new ResponseEntity<>(this.sessionRepo.save(session), HttpStatus.OK);
//
//
//    }//end httpentity
//
//    @PutMapping("/deleteMember")
//    public HttpEntity<?> deleteMember(@RequestParam("sessionId") Long sessionId) {
//        Session session = this.sessionRepo.findOneById(sessionId);
//        Member member = null;
//        session.setMember(member);
//
//        return new ResponseEntity<>(this.sessionRepo.save(session), HttpStatus.OK);
//
//    }//end httpEnt

}//end class
