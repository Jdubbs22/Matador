package edu.depaul.cdm.se.matador.controller;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.repository.MemberRepository;
import java.util.List;
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
public class RestApi {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public HttpEntity<?> getAllMembers() {

        List<Member> memberList = this.memberRepository.findAll();

        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @PostMapping("/members")
    public HttpEntity<?> createMembers(@RequestBody Member member) {

        this.memberRepository.save(member);

        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("message", "new member was saved");
        return new ResponseEntity<>(node, HttpStatus.OK);
    }

    @PutMapping("/members")
    public HttpEntity<?> updateMembers() {


        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/members")
    public HttpEntity<?> deleteMembers() {


        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
