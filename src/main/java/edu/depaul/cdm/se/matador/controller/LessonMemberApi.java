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
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private LessonService lessonService;
    @Autowired
    private MemberService memberService;
    private LessonMemberServiceImpl lessonMemberServiceimp;

    public LessonMemberApi(LessonMemberService lessonMemberService,
                           LessonMemberDao lessonMemberDao,
                           LessonMemberServiceImpl lessonMemberServiceimp,
                           LessonService lessonService) {
        this.lessonMemberService = lessonMemberService;
        this.lessonMemberDao = lessonMemberDao;
        this.lessonMemberServiceimp = lessonMemberServiceimp;
        this.lessonService = lessonService;
    }//end constructor

    @PostMapping("/lessonMember/{lessonID}/{memberID}")//was put
    public ResponseEntity<LessonResponse> addMemberToLesson(@PathVariable("lessonID") Long lessonID,
                                                            @PathVariable("memberID") Long memberId,
                                                            @RequestBody LessonRequest request) //remove bracket to impliment below
    //  ,@PathVariable("lessonID, memberID") Long lessonID,Long memberId)
    {
        //  LessonMemberDao lesson = this.lessonMemberDao.addMemberIdToLessonID(memberId,lessonID) ;
        Lesson lesson = this.lessonService.findByLessonID(lessonID);    //lessonID);
        Optional<Member> member = this.memberService.findUserById(memberId);//   memberId);

        if (lesson != null && member.isPresent()) {
            //    MemberResponse memberResponse = new MemberResponse(member);
            //    System.out.println("check to see if addMememberToLesson works");
            lessonMemberServiceimp.addMemberIdToLessonID(lessonID, memberId);
            LessonResponse lessonResponse = new LessonResponse(lesson);
            return new ResponseEntity<>(lessonResponse, HttpStatus.ACCEPTED);
        }//end if
        else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "NO lesson for Id: " + lessonID);  //lessonID);

        }//end else

    }//end method

    @PostMapping("/removeMember/{lessonID}/{memberID}")//was put
    public ResponseEntity<LessonResponse> removeMemberFromLesson(@PathVariable("lessonID") Long lessonID,
                                                            @PathVariable("memberID") Long memberId,
                                                            @RequestBody LessonRequest request) //remove bracket to impliment below
    //  ,@PathVariable("lessonID, memberID") Long lessonID,Long memberId)
    {
        //  LessonMemberDao lesson = this.lessonMemberDao.addMemberIdToLessonID(memberId,lessonID) ;
        Lesson lesson = this.lessonService.findByLessonID(lessonID);    //lessonID);
        Optional<Member> member = this.memberService.findUserById(memberId);//   memberId);

        if (lesson != null && member.isPresent()) {
            //    MemberResponse memberResponse = new MemberResponse(member);
            //    System.out.println("check to see if addMememberToLesson works");
            lessonMemberServiceimp.addMemberIdToLessonID(lessonID, memberId);
            LessonResponse lessonResponse = new LessonResponse(lesson);
            return new ResponseEntity<>(lessonResponse, HttpStatus.ACCEPTED);
        }//end if
        else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "NO lesson for Id: " + lessonID);  //lessonID);

        }//end else

    }//end method
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