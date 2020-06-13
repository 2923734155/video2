package com.wwd.video.entity;

public class Student {
    private Integer st_id;
    private Integer st_password;
    private String st_name;
    private Integer st_age;
    private String st_grade;
    private Integer st_phone;
    private String st_major;
    private String education;
    private Integer roles;

    public Student() {
    }

    public Student(Integer st_id, Integer st_password, String st_name, Integer st_age, String st_grade, Integer st_phone, String st_major, String education, Integer roles) {
        this.st_id = st_id;
        this.st_password = st_password;
        this.st_name = st_name;
        this.st_age = st_age;
        this.st_grade = st_grade;
        this.st_phone = st_phone;
        this.st_major = st_major;
        this.education = education;
        this.roles = roles;
    }

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public Integer getSt_password() {
        return st_password;
    }

    public void setSt_password(Integer st_password) {
        this.st_password = st_password;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public Integer getSt_age() {
        return st_age;
    }

    public void setSt_age(Integer st_age) {
        this.st_age = st_age;
    }

    public String getSt_grade() {
        return st_grade;
    }

    public void setSt_grade(String st_grade) {
        this.st_grade = st_grade;
    }

    public Integer getSt_phone() {
        return st_phone;
    }

    public void setSt_phone(Integer st_phone) {
        this.st_phone = st_phone;
    }

    public String getSt_major() {
        return st_major;
    }

    public void setSt_major(String st_major) {
        this.st_major = st_major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }
}
