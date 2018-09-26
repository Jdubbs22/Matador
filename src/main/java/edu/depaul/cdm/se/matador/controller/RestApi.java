package edu.depaul.cdm.se.matador.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class RestApi {

    @GetMapping("/member")
    public HttpEntity<?> getOneMember() {


        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
