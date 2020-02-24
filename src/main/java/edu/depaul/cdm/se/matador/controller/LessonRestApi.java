package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.Lesson;
import edu.depaul.cdm.se.matador.model.client.LessonRequest;
import edu.depaul.cdm.se.matador.model.client.LessonResponse;
import edu.depaul.cdm.se.matador.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class LessonRestApi {

    @Autowired
    RestTemplate restTemplate;

    //TODO: is this exception/check for lesson time sufficient?
    @Autowired
    private LessonService lessonService;

    @PostMapping("/lessons")  //creates lesson
    public ResponseEntity<LessonResponse> createUser(
            @RequestHeader("memberId") Long memberId,
            @RequestBody LessonRequest lessonRequest) throws Exception {

        Lesson createdLesson = this.lessonService.create(memberId, lessonRequest);
        LessonResponse response = new LessonResponse(createdLesson);

// TODO: fix this
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }//end /lessons post


    @GetMapping("/lessons")
    public ResponseEntity<List<LessonResponse>> getAll(@RequestParam("instructorId") Long instructorId) {
        List<Lesson> lessons = this.lessonService.findByInstructorId(instructorId);

        List<LessonResponse> response = lessons.stream()
                .map(lesson -> {
                    //lesson.setInstructor(null);
                    return new LessonResponse(lesson);
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }//end /lessons get
    @GetMapping("/lessons/{memberId}")
    public ResponseEntity<LessonResponse> findLessonByMemberId(@PathVariable("memberId")Long memberId){
        Optional<Lesson> lessonOption = this.lessonService.OptfindByMemberId(memberId);
        if(lessonOption.isPresent()){
           Lesson lesson = lessonOption.get();
            LessonResponse response = new LessonResponse(lesson);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }//end get lessons/memberId

    @GetMapping("/instructorLessons/{instructorId}")
    public HttpEntity<?> findByInstructorId(@PathVariable  ("instructorId") Long instId){
        List<Lesson> sessionList=this.lessonService.findByInstructorId(instId);
        return new ResponseEntity<>(sessionList,HttpStatus.OK);
    }//end get instructorLesons/instrId

    @GetMapping("/lessonsBetween")
    public HttpEntity<?> findLessonsBetweenTimeStampt(@RequestParam ("instructorId") Long instrId,
                                                @RequestParam("from") Long from,
                                                @RequestParam("to") Long to){

        Date startD = Date.from(Instant.ofEpochSecond(from));
        Date endD = Date.from(Instant.ofEpochSecond(to));
        List<Lesson> sessionsList = this.lessonService.findByInstructorIdBetweendates(instrId,startD,endD);
        return new ResponseEntity<>(sessionsList,HttpStatus.OK);
    }//end get /lessonsbetween

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
