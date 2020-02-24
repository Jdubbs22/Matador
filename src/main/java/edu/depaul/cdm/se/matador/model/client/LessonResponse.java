package edu.depaul.cdm.se.matador.model.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.depaul.cdm.se.matador.model.Instructor;
import edu.depaul.cdm.se.matador.model.Lesson;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter  //do I need these ?
@Setter
public class LessonResponse {

    private  Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date endTime;
    private String lessonStatus;
    private Set<String> members;
    private Instructor instructor;
    private String description;

    public LessonResponse(){}

    public LessonResponse(Lesson lesson){
        this.id = lesson.getId();
        this.instructor = lesson.getInstructor();
        this.startTime = lesson.getStartTime();
        this.endTime = lesson.getEndTime();
        this.members = new HashSet<>();
        this.description = lesson.getDescription();
    }

}
