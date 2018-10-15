package com.meeting.m2.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meeting.m2.dao.MeetingMapper;
import com.meeting.m2.dao.MeetingNotesMapper;
import com.meeting.m2.dao.MeetingSheduleMapper;
import com.meeting.m2.pojo.Meeting;
import com.meeting.m2.pojo.MeetingNotes;
import com.meeting.m2.pojo.MeetingShedule;
import com.meeting.m2.service.MeetingService;
import com.meeting.m2.util.DataGrid;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingMapper meetingMapper;

    @Autowired
    private MeetingNotesMapper meetingNotesMapper;

    @Autowired
    private MeetingSheduleMapper meetingSheduleMapper;

    @Override
    public DataGrid getMeetingList(int currentPage, int pageSize, Meeting meeting) {
        PageHelper.startPage(currentPage, pageSize);
        PageInfo<Meeting> pageInfo = new PageInfo<>(meetingMapper.getMeetingList(meeting));
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public DataGrid getMeetingNoteList(int currentPage, int pageSize, MeetingNotes meetingNotes) {
        PageHelper.startPage(currentPage, pageSize);
        PageInfo<MeetingNotes> pageInfo = new PageInfo<>(meetingNotesMapper.getMeetingList(meetingNotes));
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public DataGrid getMeetingSheduleList(int currentPage, int pageSize, MeetingShedule meetingShedule) {
        PageHelper.startPage(currentPage, pageSize);
        PageInfo<MeetingShedule> pageInfo = new PageInfo<>(meetingSheduleMapper.getMeetingList(meetingShedule));
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Meeting getMeetingByPrimaryKey(long id) {
        return meetingMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addMeeting(Meeting meeting) throws Exception {
        try {
            meeting.setStatus("0");
            meetingMapper.insertSelective(meeting);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void updateMeeting(Meeting meeting) throws Exception {
        try {
            meetingMapper.updateByPrimaryKeySelective(meeting);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void addMeetingShedule(MeetingShedule meetingShedule) {
        try {
            meetingSheduleMapper.insertSelective(meetingShedule);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void addMeetingNotes(MeetingNotes meetingNotes) {
        try {
            meetingNotesMapper.insertSelective(meetingNotes);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void importMeetingShedule(long meetingId, String meetingShedulListName, MultipartFile file) {

        boolean notNull = false;
        if (!meetingShedulListName.matches("^.+\\.(?i)(xls)$") && !meetingShedulListName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new RuntimeException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (meetingShedulListName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        try {
            InputStream is = file.getInputStream();
            Workbook wb = null;
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }
            Sheet sheet = wb.getSheetAt(0);
            if (sheet != null) {
                notNull = true;
            }

            MeetingShedule meetingShedule;
            for (int r = 1; r <= sheet.getLastRowNum(); r++) {

                Row row = sheet.getRow(r);
                if (row == null) {
                    continue;
                }

                meetingShedule = new MeetingShedule();

                if (row.getCell(0).getCellType() != 1) {
                    throw new RuntimeException("导入失败(第" + (r + 1) + "行,议程议题请设为文本格式)");
                }
                String lessus = row.getCell(0).getStringCellValue();
                if (lessus == null || lessus.isEmpty()) {
                    throw new RuntimeException("导入失败(第" + (r + 1) + "行,议程议题未填写)");
                }

                if (row.getCell(1).getCellType() != 1) {
                    throw new RuntimeException("导入失败(第" + (r + 1) + "行,演讲人请设为文本格式)");
                }
                String speaker = row.getCell(1).getStringCellValue();
                if (speaker == null || speaker.isEmpty()) {
                    throw new RuntimeException("导入失败(第" + (r + 1) + "行,演讲人未填写)");
                }

                Date starttime;
                if (row.getCell(2).getCellType() != 0) {
                    throw new RuntimeException("导入失败(第" + (r + 1) + "行,开始日期格式不正确或未填写)");
                } else {
                    starttime = row.getCell(2).getDateCellValue();
                }
                Date endtime;
                if (row.getCell(3).getCellType() != 0) {
                    throw new RuntimeException("导入失败(第" + (r + 1) + "行,结束日期格式不正确或未填写)");
                } else {
                    endtime = row.getCell(3).getDateCellValue();
                }

                if (row.getCell(4).getCellType() != 1) {
                    throw new RuntimeException("导入失败(第" + (r + 1) + "行,演讲内容请设为文本格式)");
                }
                String content = row.getCell(4).getStringCellValue();
                if (content == null || content.isEmpty()) {
                    throw new RuntimeException("导入失败(第" + (r + 1) + "行,演讲内容未填写)");
                }

                //TODO 传入对象值
                meetingShedule.setMid(meetingId);
                meetingShedule.setLssues(lessus);
                meetingShedule.setSpeaker(speaker);
                meetingShedule.setStarttime(starttime);
                meetingShedule.setEndtime(endtime);
                meetingShedule.setContent(content);

                //TODO 写入数据库
                meetingSheduleMapper.insertSelective(meetingShedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("导入失败");
        }

    }


}
