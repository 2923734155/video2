package com.wwd.video.service;

import com.wwd.video.entity.Leave;
import com.wwd.video.entity.Speaker;
import com.wwd.video.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<Speaker> findAllSpeaker();

    public List<Student> findAllStudent();

    public List<Speaker> speakerList(Integer page, Integer limit);

    public List<Student> studentList(Integer page, Integer limit);

    public List<Leave> LeaveList(Integer page,Integer limit);

    public void deleteSpeaker(Integer id);

    public void updateSpeaker(Speaker speaker);

    public Speaker querySpeaker(Integer id);


    public Student queryStudent(Integer id);

    public void addLeave(Leave leave);

    public void addSpeaker(Speaker speaker);
}
