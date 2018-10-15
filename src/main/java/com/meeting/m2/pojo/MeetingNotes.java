package com.meeting.m2.pojo;

public class MeetingNotes {

    private Long id;

    private Long mid;

    private String trafficontes;

    private String meetingcontes;

    private String notesfilename;

    private String notesfileurl;

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

    public String getTrafficontes() {
        return trafficontes;
    }

    public void setTrafficontes(String trafficontes) {
        this.trafficontes = trafficontes == null ? null : trafficontes.trim();
    }

    public String getMeetingcontes() {
        return meetingcontes;
    }

    public void setMeetingcontes(String meetingcontes) {
        this.meetingcontes = meetingcontes == null ? null : meetingcontes.trim();
    }

    public String getNotesfilename() {
        return notesfilename;
    }

    public void setNotesfilename(String notesfilename) {
        this.notesfilename = notesfilename == null ? null : notesfilename.trim();
    }

    public String getNotesfileurl() {
        return notesfileurl;
    }

    public void setNotesfileurl(String notesfileurl) {
        this.notesfileurl = notesfileurl == null ? null : notesfileurl.trim();
    }
}