package com.meeting.m2.pojo;

import java.io.Serializable;
import java.util.Date;

public class Meeting implements Serializable {

    private Long id;

    private String name;

    private Date starttime;

    private Date endtime;

    private Long areasid;

    private String address;

    private Integer num;

    private String chargeperson;

    private String chargepersonTelFixed;

    private String chargepersonTelMobile;

    private String content;

    private String poster;

    private String status;

    private Date creattime;

    private String creatby;

    private Date updatetime;

    private String updateby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Long getAreasid() {
        return areasid;
    }

    public void setAreasid(Long areasid) {
        this.areasid = areasid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getChargeperson() {
        return chargeperson;
    }

    public void setChargeperson(String chargeperson) {
        this.chargeperson = chargeperson == null ? null : chargeperson.trim();
    }

    public String getChargepersonTelFixed() {
        return chargepersonTelFixed;
    }

    public void setChargepersonTelFixed(String chargepersonTelFixed) {
        this.chargepersonTelFixed = chargepersonTelFixed == null ? null : chargepersonTelFixed.trim();
    }

    public String getChargepersonTelMobile() {
        return chargepersonTelMobile;
    }

    public void setChargepersonTelMobile(String chargepersonTelMobile) {
        this.chargepersonTelMobile = chargepersonTelMobile == null ? null : chargepersonTelMobile.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster == null ? null : poster.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
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
        this.updateby = updateby;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", areasid=" + areasid +
                ", address='" + address + '\'' +
                ", num=" + num +
                ", chargeperson='" + chargeperson + '\'' +
                ", chargepersonTelFixed='" + chargepersonTelFixed + '\'' +
                ", chargepersonTelMobile='" + chargepersonTelMobile + '\'' +
                ", content='" + content + '\'' +
                ", poster='" + poster + '\'' +
                ", status='" + status + '\'' +
                ", creattime=" + creattime +
                ", creatby='" + creatby + '\'' +
                ", updatetime=" + updatetime +
                ", updateby='" + updateby + '\'' +
                '}';
    }
}