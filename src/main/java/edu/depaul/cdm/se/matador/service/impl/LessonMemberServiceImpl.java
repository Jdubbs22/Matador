package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Lesson;
import edu.depaul.cdm.se.matador.model.Member;
import edu.depaul.cdm.se.matador.service.dao.LessonMemberDao;
import edu.depaul.cdm.se.matador.service.repository.LessonMemberService;
import edu.depaul.cdm.se.matador.service.repository.LessonRepository;
import edu.depaul.cdm.se.matador.service.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LessonMemberServiceImpl implements LessonMemberService {
   private LessonMemberDao lessonMemberDao;
   private LessonRepository lessonRepository;
   private MemberRepository memberRepository;


    public LessonMemberServiceImpl(LessonMemberDao lessonMemberDao,
                                   LessonRepository lessonRepository,
                                   MemberRepository memberRepository) {
        this.lessonMemberDao = lessonMemberDao;
        this.lessonRepository = lessonRepository;
        this.memberRepository = memberRepository;
    }//end constructor

    @Override
    public int addMemberIdToLessonID(Long lessonID, Long membersID) {
  //      System.out.println("test to see if addMemberIdToLessonId is called");
       Optional<Member> memberOptional = this.memberRepository.findById(membersID);
        if (!memberOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("The member ID %s doesn't exist", membersID));
        }//end if

        Optional<Lesson> lessonOptional = this.lessonRepository.findById(lessonID);
        if (!lessonOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("The lesson ID %s doesn't exist", lessonID));
        }//end if

        int updated = this.lessonMemberDao.addMemberIdToLessonID(membersID,lessonID);
        return updated;
    }//end method



}//end class
