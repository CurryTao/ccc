package com.meeting.m2.controller;

import com.meeting.m2.service.MeetingService;
import com.meeting.m2.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping(value = "/importMeetingShedule", method = RequestMethod.POST)
    public PageResult addUser(@RequestParam long meetingId, @RequestBody MultipartFile file) {
        if (file.isEmpty()) return PageResult.error(405, "上传的信息不能为空");
        String meetingShedulListName = file.getOriginalFilename();
        try {
            meetingService.importMeetingShedule(meetingId, meetingShedulListName, file);
            return PageResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.error(500, "上传信息失败");
        }

    }

}
