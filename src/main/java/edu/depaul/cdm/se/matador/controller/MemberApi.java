package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.model.client.MemberResponse;
import edu.depaul.cdm.se.matador.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class MemberApi {

    private MemberService memberService;

    public MemberApi(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/users")
    public ResponseEntity<MemberResponse> createUser(@RequestBody Member member) {
        Member cratedMember = this.memberService.create(member);
        MemberResponse response = new MemberResponse(member);

         // convert User --> UserResponse
        //also tried cratedUser.toString()
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<MemberResponse> createUser(@PathVariable("userId") Long userId) {

        Optional<Member> userOption = this.memberService.findUserById(userId);
        if (userOption.isPresent()) {
            Member member =  userOption.get();
            MemberResponse response = new MemberResponse(member);
            return ResponseEntity.ok(response);
           // return new ResponseEntity<User>(userOption.get(), HttpStatus.OK);
        }
       // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         return ResponseEntity.notFound().build();
    }

//    @PutMapping("/users/role/{userId}")  //this is in userRoleApi...is this needed twice?
//    public ResponseEntity<User> userRole(@RequestBody RoleRequest request,@PathVariable("userId") Long id){
//        return null;
//    }
}
