package edu.depaul.cdm.se.matador.model.client;

import edu.depaul.cdm.se.matador.model.Instructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InstructorResponse {

    private long instructorId;
    private Date startDate;
    private String name;
    private String imageUrl;



    public InstructorResponse(){}

    public InstructorResponse(Instructor instructor){
        this.instructorId = instructor.getInstructorId();
        this.name = instructor.getMember().getFirstName()
                +" "+instructor.getMember().getLastName();
        this.startDate=instructor.getStartDate();
        this.imageUrl = instructor.getImageUrl();


    }
}//end class
