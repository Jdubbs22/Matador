package edu.depaul.cdm.se.matador.service.repository;

public interface LessonMemberService {

    public int addMemberIdToLessonID( Long lessonID,Long membersID);
    public int removeMemberIdFromLessonId(Long lessonId, Long memberId);
}
