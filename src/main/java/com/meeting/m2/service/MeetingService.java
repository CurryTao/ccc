package com.meeting.m2.service;

import com.meeting.m2.pojo.Meeting;
import com.meeting.m2.pojo.MeetingNotes;
import com.meeting.m2.pojo.MeetingShedule;
import com.meeting.m2.util.DataGrid;
import org.springframework.web.multipart.MultipartFile;

public interface MeetingService {

    DataGrid getMeetingList(int currentPage, int pageSize, Meeting meeting);

    Meeting getMeetingByPrimaryKey(long id);

    void addMeeting(Meeting meeting) throws Exception;

    void updateMeeting(Meeting meeting) throws Exception;

    DataGrid getMeetingNoteList(int currentPage, int pageSize, MeetingNotes meetingNotes);

    DataGrid getMeetingSheduleList(int currentPage, int pageSize, MeetingShedule meetingShedule);

    void addMeetingNotes(MeetingNotes meetingNotes);

    void addMeetingShedule(MeetingShedule meetingShedule);

    void importMeetingShedule(long meetingId, String meetingShedulListName, MultipartFile file);
}
