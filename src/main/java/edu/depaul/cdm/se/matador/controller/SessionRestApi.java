package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.model.Session;
import edu.depaul.cdm.se.matador.repository.InstructorRepository;
import edu.depaul.cdm.se.matador.repository.MemberRepository;
import edu.depaul.cdm.se.matador.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sessions")
public class SessionRestApi {

    @Autowired
    private SessionRepository sessionRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private InstructorRepository instrRepo;

    @GetMapping("")
    public HttpEntity<?> getAll() {
        return new ResponseEntity<>(this.sessionRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public HttpEntity<?> createSession(@RequestBody Session session) {
        return new ResponseEntity<>(this.sessionRepo.save(session), HttpStatus.OK);
    }

    /**
     * This method ....
     * @param sessionId
     * @param memberId
     * @return
     */
    @GetMapping("/assignMember")
    public HttpEntity<?> assignMember(@RequestParam("sessionId") Long sessionId,
                                      @RequestParam("memberId") Long memberId) {

            Session session = this.sessionRepo.findOneById(sessionId);
            Member member = this.memberRepo.findOneById(memberId);
            session.setMember(member);

            return new ResponseEntity<>(this.sessionRepo.save(session), HttpStatus.OK);


    }//end httpentity

    @GetMapping("/deleteMember")
    public HttpEntity<?> deleteMember(@RequestParam("sessionId") Long sessionId) {
        Session session = this.sessionRepo.findOneById(sessionId);
        Member member = null;
        session.setMember(member);

        return new ResponseEntity<>(this.sessionRepo.save(session), HttpStatus.OK);

    }//end httpEnt

}//end class
