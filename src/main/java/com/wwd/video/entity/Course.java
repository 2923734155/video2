package com.wwd.video.entity;

public class Course {
    private int id;
    private String course_title;
    private String course_desc;
    private String subject_name;

    public Course() {
    }

    public Course(int id, String course_title, String course_desc, String subject_name) {
        this.id = id;
        this.course_title = course_title;
        this.course_desc = course_desc;
        this.subject_name = subject_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_desc() {
        return course_desc;
    }

    public void setCourse_desc(String course_desc) {
        this.course_desc = course_desc;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_title='" + course_title + '\'' +
                ", course_desc='" + course_desc + '\'' +
                ", subject_name='" + subject_name + '\'' +
                '}';
    }
}
