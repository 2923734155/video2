package com.wwd.video.dao;

import com.wwd.video.entity.Leave;
import com.wwd.video.entity.Speaker;
import com.wwd.video.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> studentList();

    public List<Leave> LeaveList();

    public Student queryStudent(Integer id);

    public void deleteSpeaker(Integer id);

    public void updateSpeaker(Speaker speaker);

    public Speaker querySpeaker(Integer id);


    public void addLeave(Leave leave);

    public void addSpeaker(Speaker speaker);
}
