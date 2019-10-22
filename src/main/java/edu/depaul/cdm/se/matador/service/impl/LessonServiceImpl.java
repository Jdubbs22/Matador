package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Lesson;
import edu.depaul.cdm.se.matador.service.LessonService;
import edu.depaul.cdm.se.matador.service.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonRepository lessonRepository;

    @Override
    public List<Lesson> findByInstructorId(Long instructorId) {
       List<Lesson> lessons= lessonRepository.findByInstructorId(instructorId);
        return lessons;

    }

    @Override
    public List<Lesson> findByMemberId(Long memberId) {
        return null;
    }

    @Override
    public Optional<Lesson> OptfindByMemberId(Long memberId) {
        return Optional.empty();
    }

//    @Override
//    public Optional<Lesson> OptfindByMemberId(Long memberId) {
//        return Optional.empty();
//    }

    // @Override
    public Optional<Lesson> findAllByMember(Long memberID) {
        return Optional.empty();
    }
}
