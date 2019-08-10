package edu.depaul.cdm.se.matador.controller;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.repository.MemberRepository;
import java.util.List;

import edu.depaul.cdm.se.matador.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberRestApi {




    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public HttpEntity<?> getAllMembers() {

        List<Member> memberList = this.memberService.getAll();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }//end method

    @PostMapping("/members")
    public HttpEntity<?> createMembers(@RequestBody Member member) {
        Member member1 = this.memberService.create(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }//end method

    @PutMapping("/members")
    public HttpEntity<?> updateMembers() {


        return new ResponseEntity<>(null, HttpStatus.OK);
    }//end method

    /*  not sure if this is correct???
    @PutMapping("/members")
    public HttpEntity<?> updateMembers(@RequestBody Member member) {
          Member member1 = this.memberService.update(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
     */

    @DeleteMapping("/members")
    public HttpEntity<?> deleteMembers() {


        return new ResponseEntity<>(null, HttpStatus.OK);
    }//end method
}//end class
