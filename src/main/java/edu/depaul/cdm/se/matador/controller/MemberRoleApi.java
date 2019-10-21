package edu.depaul.cdm.se.matador.controller;

import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.model.dto.MemberResponse;
import edu.depaul.cdm.se.matador.model.dto.RoleRequest;
import edu.depaul.cdm.se.matador.service.MemberRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1")
public class MemberRoleApi {

    private MemberRoleService memberRoleService;

    public MemberRoleApi(MemberRoleService memberRoleService) {
        this.memberRoleService = memberRoleService;
    }

    @PutMapping("/userRole/{userId}")
    public ResponseEntity<MemberResponse> addRole(@PathVariable("userId") Long userId,
                                                  @RequestBody RoleRequest request) {
        System.out.println("test string");

        Member member = this.memberRoleService.addRole(userId, request.getRole());

        // TODO: what if the same role is entered twice?

//        try{
        if (member != null) {
            MemberResponse memberResponse = new MemberResponse(member);
            //HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(memberResponse, HttpStatus.ACCEPTED);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "NO user for Id: " + userId);
            // return ResponseEntity.notFound().build();
        }



//        catch (Exception e){
//
//                throw new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, "Improper Role or User ID", e);
//        }//end catch
//        UserResponse userResponse = new UserResponse(user);
//        return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
    }//end add role
}
