package edu.depaul.cdm.se.matador.model.client;

import edu.depaul.cdm.se.matador.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LessonTime {

    @Autowired
    private EntityManager manager;
    private Date endLessonTime;
    private Date startLessonTime;
    private Instructor id;

    public static void checkIfStartTimeIsFirst(Date startTime, Date endTime) throws Exception {
   //    Query query = this.manager.createNativeQuery();
        if(startTime.compareTo(endTime) >= 0){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Start time comes after end time or start time is the same as end time");
        }
    }//end method

//TODO: why is the entity manager null?
 // @Transactional      //do I need this???
public void checkOverlapBetweenLessons(Date endLessonTime, Date startLessonTime, Instructor instructor) throws Exception {
//    this.endLessonTime = endLessonTime;  //not sure if this is needed
//    this.startLessonTime = startLessonTime;
//    this.id = id;
    //^^^above was static but changed for the this. below
  //  Query duplicateQuery = this.manager.createNativeQuery()

    DateFormat formater = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");


    String startStr = String.format("'%s'", formater.format(startLessonTime));
    String endStr = String.format("'%s'", formater.format(endLessonTime));

    Query query = manager.createNativeQuery("select *" +  //).createNativeQuery  //was this.manager
            " from lesson " +
            "where start_time <= " + startStr + " and end_time >= "+ startStr +
            " or " +
            " start_time <= " + endStr + " and end_time >= "+ endStr +
            " or " +
            " start_time >= " + startStr + " and end_time <= "+ endStr +

            " and instructor_id = "+ instructor.getInstructorId() );


//    Query query = manager.createNativeQuery("select *" +  //).createNativeQuery  //was this.manager
//            " from lesson " +
//            "where start_time >= " + startStr + " and end_time <= "+ startStr +
//            " or " +
//            " start_time >= " + startStr + " and end_time <= "+ startStr +
//            " and instructor_id = "+ instructor.getInstructorId() );


//    Query query = manager.createQuery("select s" +  //).createNativeQuery  //was this.manager
//            " from Lesson s " +
//            "where start_time >= " + startStr + " and end_time <= "+ endStr +
//            " and instructor_id = "+ instructor.getInstructorId());

    List result = query.getResultList();

    if(result.size() >=1 ){ //.getFirstResult()
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Above time intersects with another lesson");
    }
}


/*
select id
from lesson
where start_time >= inputstart_time and  end_timee <= inputend_time;

//if this returns this should throw an error  else store new lesson
 */

}//end class
