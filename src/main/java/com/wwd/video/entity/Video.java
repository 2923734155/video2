package com.wwd.video.entity;

public class Video {
    private Integer id;
    private String title;
    private String detail;
    private String time;
    private Integer speaker_id;
    private Integer course_id;
    private String video_url;
    private String image_url;
    private Integer play_num;


    public Video() {
    }

    public Video(Integer id, String title, String detail, String time, Integer speaker_id, Integer course_id, String video_url, String image_url, Integer play_num) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.time = time;
        this.speaker_id = speaker_id;
        this.course_id = course_id;
        this.video_url = video_url;
        this.image_url = image_url;
        this.play_num = play_num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Integer speaker_id) {
        this.speaker_id = speaker_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Integer play_num) {
        this.play_num = play_num;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", time='" + time + '\'' +
                ", speaker_id=" + speaker_id +
                ", course_id=" + course_id +
                ", video_url='" + video_url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", play_num=" + play_num +
                '}';
    }
}
