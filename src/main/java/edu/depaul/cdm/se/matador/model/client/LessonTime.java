package edu.depaul.cdm.se.matador.model.client;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;

public class LessonTime {

    @Autowired
    private EntityManager manager;

   public static void checkIfStartTimeIsFirst(Date startTime, Date endTime) throws Exception {
   //    Query query = this.manager.createNativeQuery();
        if(startTime.compareTo(endTime)==1){
            throw new Exception("Start time comes after end time");
        }
    }//end method

//TODO: why is the entity manager null?
  //@Transactional      //do I need this???
public  void checkOverlapBetweenLessons( Date endLessonTime, Date startLessonTime) throws Exception {
    //^^^above was static but changed for the this. below
  //  Query duplicateQuery = this.manager.createNativeQuery()
   // EntityManager manager1;
    Query query = this.manager.createNativeQuery("select id\n" +
            "from lesson\n" +
            "where start_time >= "+startLessonTime+" and end_timee <= "+endLessonTime+"; ");
    if(query.getFirstResult() >=1 ){
        throw new Exception("Above time intersects with another lesson");
    }
}


/*
select id
from lesson
where start_time >= inputstart_time and  end_timee <= inputend_time;

//if this returns this should throw an error  else store new lesson
 */

}//end class
