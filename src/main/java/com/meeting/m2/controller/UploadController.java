package com.meeting.m2.controller;

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
    private FastDFSClientWrapper fastDFSClientWrapper;

    @RequestMapping("/upload")
    public PageResult fdfsUpload(@RequestBody MultipartFile file) {
        if (file.isEmpty()) {
            return PageResult.error(405, "图片不能为空");
        }
        try {
            String fileUrl = fastDFSClientWrapper.uploadFile(file);
            return PageResult.success(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return PageResult.error(500, "图片上传失败");
        }
    }

}
