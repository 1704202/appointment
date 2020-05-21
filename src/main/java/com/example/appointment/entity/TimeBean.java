package com.example.appointment.entity;

public class TimeBean {
    private String tid;//流水id
    private String user_id;//发布用户ID
    private String address;//预约地址
    private String starttime;//开始时间
    private String endtime;//结束时间
    private int schedule;//是否被预约
    private String schedule_user;//预约用户
    private String detail;//预约详情

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public String getSchedule_user() {
        return schedule_user;
    }

    public void setSchedule_user(String schedule_user) {
        this.schedule_user = schedule_user;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public TimeBean(String tid, String user_id, String address, String starttime, String endtime, int schedule, String schedule_user, String detail) {
        this.tid = tid;
        this.user_id = user_id;
        this.address = address;
        this.starttime = starttime;
        this.endtime = endtime;
        this.schedule = schedule;
        this.schedule_user = schedule_user;
        this.detail = detail;
    }

    public TimeBean() {
    }
}
