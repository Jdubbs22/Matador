package edu.depaul.cdm.se.matador.controller;


import edu.depaul.cdm.se.matador.model.Lesson;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.model.client.LessonRequest;
import edu.depaul.cdm.se.matador.model.client.LessonResponse;
import edu.depaul.cdm.se.matador.service.LessonService;
import edu.depaul.cdm.se.matador.service.MemberService;
import edu.depaul.cdm.se.matador.service.dao.LessonMemberDao;
import edu.depaul.cdm.se.matador.service.impl.LessonMemberServiceImpl;
import edu.depaul.cdm.se.matador.service.repository.LessonMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class LessonMemberApi {

    private LessonMemberService lessonMemberService;
    private LessonMemberDao lessonMemberDao;
    private LessonService lessonService;
    private MemberService memberService;
    private LessonMemberServiceImpl lessonMemberServiceimp;

    public LessonMemberApi(LessonMemberService lessonMemberService,
                           LessonMemberDao lessonMemberDao,
                           LessonMemberServiceImpl lessonMemberServiceimp) {
        this.lessonMemberService = lessonMemberService;
        this.lessonMemberDao = lessonMemberDao;
        this.lessonMemberServiceimp = lessonMemberServiceimp;
    }//end constructor

    @PostMapping("/lessonMember/{lessonID, memberID}")//was put
    public ResponseEntity<LessonResponse> addMemberToLesson(@PathVariable("lessonID") Long lessonID,
                                                            @PathVariable("memberID") Long memberId,
                                                            @RequestBody LessonRequest request){
      //  LessonMemberDao lesson = this.lessonMemberDao.addMemberIdToLessonID(memberId,lessonID) ;
        Lesson lesson = this.lessonService.findByLessonID(lessonID);
       Optional<Member> member = this.memberService.findUserById(memberId);
        if(lesson != null && member.isPresent()){
        //    MemberResponse memberResponse = new MemberResponse(member);
            LessonResponse lessonResponse = new LessonResponse(lesson);
            System.out.println("check to see if addMememberToLesson works");
            lessonMemberServiceimp.addMemberIdToLessonID(lessonID,memberId);
            return new ResponseEntity<>(lessonResponse, HttpStatus.ACCEPTED);

        }//end if
        else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "NO lesson for Id: " + lessonID);
            // return ResponseEntity.notFound().build();
        }
      //  return null;
    }
}//end class
        // can I use this???
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