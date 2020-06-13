package com.wwd.video.entity;

public class Leave {
    private Integer id;
    private Integer st_id;
    private String begin_time;
    private String end_time;
    private String reason;
    private String st_name;
    private String st_grade;
    private String st_phone;
    private String st_major;

    public Leave() {
    }

    public Leave(Integer id, Integer st_id, String begin_time, String end_time, String reason, String st_name, String st_grade, String st_phone, String st_major) {
        this.id = id;
        this.st_id = st_id;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.reason = reason;
        this.st_name = st_name;
        this.st_grade = st_grade;
        this.st_phone = st_phone;
        this.st_major = st_major;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public String getSt_grade() {
        return st_grade;
    }

    public void setSt_grade(String st_grade) {
        this.st_grade = st_grade;
    }

    public String getSt_phone() {
        return st_phone;
    }

    public void setSt_phone(String st_phone) {
        this.st_phone = st_phone;
    }

    public String getSt_major() {
        return st_major;
    }

    public void setSt_major(String st_major) {
        this.st_major = st_major;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", st_id=" + st_id +
                ", begin_time='" + begin_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", reason='" + reason + '\'' +
                ", st_name='" + st_name + '\'' +
                ", st_grade='" + st_grade + '\'' +
                ", st_phone='" + st_phone + '\'' +
                ", st_major='" + st_major + '\'' +
                '}';
    }
}
