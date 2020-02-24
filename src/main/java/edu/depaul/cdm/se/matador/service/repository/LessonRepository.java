package edu.depaul.cdm.se.matador.service.repository;

import edu.depaul.cdm.se.matador.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    //Lesson findOneById(Long id);

    List<Lesson> findAll();
    //List<Session> findByInstructor();
    //@Query("select s from Session s where s.instructor.instrId = :instructId and s.member = null")
    //List<Session> findOpenSessions(@Param("instructId") Long instrId);

    @Query("select s from Lesson s where s.instructor.instructorId = :instructorId")
    List<Lesson> findByInstructorId(@Param("instructorId") Long instructorId);

    @Query("select s from Lesson s where s.id = :lessonId")
    Lesson findByLessonID(@Param("lessonId") Long lessonID);

//    @Query(name = "select s from Lesson s where s.instructor.instructorId = :instructorId",
//            nativeQuery = true)
//    List<Lesson> findByInstructorId(@Param("instructorId") Long instructorId);


            //toDo: fix this sql Query
  //     @Query("select s from Lesson s where s.memberId=:memberId")
//        @Query("select * from lesson where memberId =1")
//       List<Lesson> findbyMemberId(@Param("memberId") long memberId);
    }
