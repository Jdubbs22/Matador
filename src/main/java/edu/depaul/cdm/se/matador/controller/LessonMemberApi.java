package edu.depaul.cdm.se.matador.controller;


import edu.depaul.cdm.se.matador.model.Lesson;
import edu.depaul.cdm.se.matador.model.client.LessonRequest;
import edu.depaul.cdm.se.matador.model.client.LessonResponse;
import edu.depaul.cdm.se.matador.service.LessonService;
import edu.depaul.cdm.se.matador.service.dao.LessonMemberDao;
import edu.depaul.cdm.se.matador.service.repository.LessonMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1")
public class LessonMemberApi {

    private LessonMemberService lessonMemberService;
    private LessonMemberDao lessonMemberDao;
    private LessonService lessonService;

    public LessonMemberApi(LessonMemberService lessonMemberService, LessonMemberDao lessonMemberDao) {
        this.lessonMemberService = lessonMemberService;
        this.lessonMemberDao = lessonMemberDao;
    }//end constructor

    @PutMapping("/lessonMember/{lessonID, memberID}")
    public ResponseEntity<LessonResponse> addMemberToLesson(@PathVariable("lessonID") Long lessonID,
                                                            @PathVariable("memberID") Long memberId,
                                                            @RequestBody LessonRequest request){
      //  LessonMemberDao lesson = this.lessonMemberDao.addMemberIdToLessonID(memberId,lessonID) ;
        Lesson lesson = this.lessonService.findByLessonID(lessonID);

        if(lesson != null){
            LessonResponse lessonResponse = new LessonResponse(lesson);
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
