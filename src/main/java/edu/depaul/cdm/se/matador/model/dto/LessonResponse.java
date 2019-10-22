package edu.depaul.cdm.se.matador.model.dto;

import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.model.Lesson;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LessonResponse {

    private  Long id;
    private Date startTime;
    private Date endTime;
    private String lessonStatus;
    private Set<String> members;
    private Instructor instructor;

    public LessonResponse(){}

    public LessonResponse(Lesson lesson){
        this.id = lesson.getId();
        this.instructor = lesson.getInstructor();
        this.startTime = lesson.getStartTime();
        this.endTime = lesson.getEndTime();
        this.members = new HashSet<>();

    }

}
