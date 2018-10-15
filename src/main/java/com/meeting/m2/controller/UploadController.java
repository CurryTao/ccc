package com.meeting.m2.controller;

import com.meeting.m2.service.MeetingService;
import com.meeting.m2.util.FastDFSClientWrapper;
import com.meeting.m2.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("file")
public class UploadController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @RequestMapping("/uploadMeeingPoster")
    public PageResult fdfsUpload(@RequestBody MultipartFile uploadMeeingPoster) {
        if (uploadMeeingPoster.isEmpty()) {
            return PageResult.error(405, "图片不能为空");
        }
        try {
            String fileUrl = fastDFSClientWrapper.uploadFile(uploadMeeingPoster);
            return PageResult.success(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.error(500, "图片上传失败");
        }
    }

    @RequestMapping("/uploadMeeingShedule")
    public PageResult uploadMeeingShedule(@RequestBody MultipartFile meeingSheduleList, long mid) {
        if (meeingSheduleList.isEmpty()) {
            return PageResult.error(405, "图片不能为空");
        }
        try {
            meetingService.importMeetingShedule(mid, meeingSheduleList.getOriginalFilename(), meeingSheduleList);
            return PageResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return PageResult.error(500, "图片上传失败");
        }
    }

}
