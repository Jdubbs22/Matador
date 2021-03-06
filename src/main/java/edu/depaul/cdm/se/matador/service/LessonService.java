package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Lesson;
import edu.depaul.cdm.se.matador.model.client.LessonRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LessonService {
    List<Lesson> findByInstructorId(Long instructorId);
    List<Lesson> findByMemberId(Long memberId);
    Optional<Lesson> OptfindByMemberId(Long memberId);
    Lesson findByLessonID(Long lessonID);
    //Lesson create(Lesson lesson);
    Lesson create(Long memberId, LessonRequest request) throws Exception;
    List<Lesson> findByInstructorIdBetweendates(Long instructorId, Date startDate, Date endDate);
    //^^^ todo: does instructor id need to be of type instructor?
}
