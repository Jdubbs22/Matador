package edu.depaul.cdm.se.matador.service.impl;

import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.model.Lesson;
import edu.depaul.cdm.se.matador.model.client.LessonRequest;
import edu.depaul.cdm.se.matador.model.client.LessonTime;
import edu.depaul.cdm.se.matador.service.InstructorService;
import edu.depaul.cdm.se.matador.service.LessonService;
import edu.depaul.cdm.se.matador.service.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    InstructorService instructorService;
    @Autowired
    LessonTime lessonTime;
    @Autowired
    private EntityManager manager;
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

    @Override
    public Lesson findByLessonID(Long lessonID) {  //todo: did I fix this correctly???
        System.out.println("test to see if findByLessonId is called =============================================");
        Lesson lesson = lessonRepository.findByLessonID(lessonID);
        System.out.println("test to see if this prints below lessonRepository");
        return lesson;
    }

    //todo: fix createLesson
    // TODO: verify that startTime and endTime in lessonRequest is legal
    @Override
    public Lesson create(Long memberId, LessonRequest request) throws Exception {
        // find Instructor with memberId,
      Optional<Instructor> instr = instructorService.findInstructorById(memberId);
        //  then create Lesson with given info from lessonRequest
        Lesson lesson = new Lesson();
        lesson.setInstructor(instr.get());
        lesson.setDescription(request.getDescription());
        lesson.setStartTime(request.getStartTime());
        lesson.setEndTime(request.getEndTime());
        lesson.setStatus("OPEN");

        LessonTime.checkIfStartTimeIsFirst(lesson.getStartTime(),lesson.getEndTime());
      //  LessonTime lessonTime = new LessonTime();
        lessonTime.checkOverlapBetweenLessons(lesson.getEndTime(),lesson.getStartTime(),lesson.getInstructor());

        // persist into DB -> go via LessonRepository
        return lessonRepository.save(lesson);

    }

    @Override
    public List<Lesson> findByInstructorIdBetweendates(Long instructorId, Date startDate, Date endDate) {
       DateFormat formater = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        String startStr = String.format("'%s'", formater.format(startDate));
        String endStr = String.format("'%s'", formater.format(endDate));
        Query query = this.manager.createNativeQuery(
                "select * "+
                        " from lesson "+
                        " where start_time >= "+ startStr+
                        " and end_time <= "+endStr+
                        "and instructor_id = "+ instructorId
        );
        List result = query.getResultList();
        return result;
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
