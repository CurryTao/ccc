package com.meeting.m2.dao;

import com.meeting.m2.pojo.MeetingShedule;

import java.util.List;

public interface MeetingSheduleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MeetingShedule record);

    int insertSelective(MeetingShedule record);

    MeetingShedule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MeetingShedule record);

    int updateByPrimaryKey(MeetingShedule record);

    List<MeetingShedule> getMeetingList(MeetingShedule meetingShedule);
}