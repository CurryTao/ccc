package com.meeting.m2.pojo;

import java.util.Date;

public class MeetingShedule {
    private Long id;

    private Long mid;

    private String lssues;

    private String speaker;

    private Date starttime;

    private Date endtime;

    private String content;

    private Date createtime;

    private String creatby;

    private Date updatetime;

    private String updateby;

    private String sheduletemplatename;

    private String sheduletemplateurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getLssues() {
        return lssues;
    }

    public void setLssues(String lssues) {
        this.lssues = lssues == null ? null : lssues.trim();
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker == null ? null : speaker.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreatby() {
        return creatby;
    }

    public void setCreatby(String creatby) {
        this.creatby = creatby == null ? null : creatby.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public String getSheduletemplatename() {
        return sheduletemplatename;
    }

    public void setSheduletemplatename(String sheduletemplatename) {
        this.sheduletemplatename = sheduletemplatename == null ? null : sheduletemplatename.trim();
    }

    public String getSheduletemplateurl() {
        return sheduletemplateurl;
    }

    public void setSheduletemplateurl(String sheduletemplateurl) {
        this.sheduletemplateurl = sheduletemplateurl == null ? null : sheduletemplateurl.trim();
    }
}