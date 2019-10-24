package edu.depaul.cdm.se.matador.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

@Component
public class LessonMemberDao {
    @Autowired
    private EntityManager manager;

    @Transactional
    public int addMemberIdToLessonID( Long lessonID,Long membersID){
        String value = String.format("(%s, '%s')", lessonID,membersID);
        Query query = this.manager.createNativeQuery("insert int lesson_members(lessonId,membersId) values"+value);
        query.setFlushMode(FlushModeType.COMMIT);

        return query.executeUpdate();
    }//end method



}//end class
