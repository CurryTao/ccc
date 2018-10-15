package com.meeting.m2.dao;

import com.meeting.m2.pojo.MeetingNotes;

import java.util.List;

public interface MeetingNotesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MeetingNotes record);

    int insertSelective(MeetingNotes record);

    MeetingNotes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MeetingNotes record);

    int updateByPrimaryKey(MeetingNotes record);

    List<MeetingNotes> getMeetingList(MeetingNotes meetingNotes);
}