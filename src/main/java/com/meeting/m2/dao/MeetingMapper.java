package com.meeting.m2.dao;

import com.meeting.m2.pojo.Meeting;

import java.util.List;

public interface MeetingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);

    List<Meeting> getMeetingList(Meeting meeting);
}