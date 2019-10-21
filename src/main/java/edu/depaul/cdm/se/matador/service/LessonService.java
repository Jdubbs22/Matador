package edu.depaul.cdm.se.matador.service;

import edu.depaul.cdm.se.matador.model.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findByInstructorId(Long instructorId);
    List<Lesson> findByMemberId(Long memberId);

}
