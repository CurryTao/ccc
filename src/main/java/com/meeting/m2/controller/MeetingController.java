package com.meeting.m2.controller;

import com.meeting.m2.pojo.Meeting;
import com.meeting.m2.pojo.MeetingNotes;
import com.meeting.m2.pojo.MeetingShedule;
import com.meeting.m2.service.MeetingService;
import com.meeting.m2.util.DataGrid;
import com.meeting.m2.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping("/getMeetingList")
    public DataGrid getMeetingList(@RequestParam(value = "currentPage", required = false, defaultValue = "0") int currentPage, @RequestParam(value = "pageSize", required = false, defaultValue = "10000000") int pageSize, @RequestBody Meeting meeting) {
        return meetingService.getMeetingList(currentPage, pageSize, meeting);
    }

    @RequestMapping("/findMeetingListAll")
    public DataGrid findMeetingListAll() {
        return meetingService.getMeetingList(0, 100000, null);
    }

    @RequestMapping("/getMeetingNoteList")
    public DataGrid getMeetingList(@RequestParam(value = "currentPage", required = false, defaultValue = "0") int currentPage, @RequestParam(value = "pageSize", required = false, defaultValue = "10000000") int pageSize, @RequestBody MeetingNotes meetingNotes) {
        return meetingService.getMeetingNoteList(currentPage, pageSize, meetingNotes);
    }

    @RequestMapping("/getMeetingSheduleList")
    public DataGrid getMeetingSheduleList(@RequestParam(value = "currentPage", required = false, defaultValue = "0") int currentPage, @RequestParam(value = "pageSize", required = false, defaultValue = "10000000") int pageSize, @RequestBody MeetingShedule meetingShedule) {
        return meetingService.getMeetingSheduleList(currentPage, pageSize, meetingShedule);
    }

    @RequestMapping("/addMeeting")
    public PageResult addMeeting(@RequestBody Meeting meeting) {
        try {
            meetingService.addMeeting(meeting);
            return PageResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.error(500, "会议添加失败");
        }
    }

    @RequestMapping("/addMeetingNotes")
    public PageResult addMeetingNotes(@RequestBody MeetingNotes meetingNotes) {
        try {
            meetingService.addMeetingNotes(meetingNotes);
            return PageResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.error(500, "会议指南添加失败");
        }
    }

    @RequestMapping("/addMeetingShedule")
    public PageResult addMeetingShedule(@RequestBody MeetingShedule meetingShedule) {
        try {
            meetingService.addMeetingShedule(meetingShedule);
            return PageResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.error(500, "会议添加日程失败");
        }
    }

    @RequestMapping("/updateMeeting")
    public PageResult updateMeeting(@RequestBody Meeting meeting) {
        try {
            meetingService.updateMeeting(meeting);
            return PageResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.error(500, "会议修改失败");
        }
    }

    @RequestMapping("/getMeetingByPrimaryKey")
    public Meeting getMeetingByPrimaryKey(long id) {
        return meetingService.getMeetingByPrimaryKey(id);
    }

}
