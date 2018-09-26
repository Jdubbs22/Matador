package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class RestApi {
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("/members")
    public HttpEntity<?> getAllMembers() {


        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
