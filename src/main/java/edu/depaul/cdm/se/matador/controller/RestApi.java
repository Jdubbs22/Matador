package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestApi {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public HttpEntity<?> getAllMembers() {

        List<Member> memberList = this.memberRepository.findAll();

        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }
}
