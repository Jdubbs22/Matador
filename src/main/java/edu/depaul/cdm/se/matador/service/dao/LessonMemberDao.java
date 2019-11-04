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
    public int addMemberIdToLessonID( Long lesson_id,Long members_id){
        String value = String.format("(%s, '%s')",lesson_id,members_id);
        Query query = this.manager.createNativeQuery("insert into lesson_members(lesson_id,members_id) values "+value);
        query.setFlushMode(FlushModeType.COMMIT);

        return query.executeUpdate();
    }//end method


    //todo: fix this query
    @Transactional
    public int removeMemberIdFromLessonId( Long lesson_id, Long members_id){
        String value = String.format("(%s, '%s')",lesson_id,members_id);
        Query query = this.manager.createNativeQuery("DELETE " +members_id+" FROM lesson_members WHERE lesson_id = "+ members_id+";");
        query.setFlushMode(FlushModeType.COMMIT);
        return query.executeUpdate();
    }

}//end class
