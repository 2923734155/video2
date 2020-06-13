package com.wwd.video.service.impl;

import com.github.pagehelper.PageHelper;
import com.wwd.video.dao.SpeakerDao;
import com.wwd.video.dao.StudentDao;
import com.wwd.video.entity.Leave;
import com.wwd.video.entity.Speaker;
import com.wwd.video.entity.Student;
import com.wwd.video.service.SpeakerService;
import com.wwd.video.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private SpeakerDao speakerDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Speaker> findAllSpeaker() {
        return speakerDao.speakerList();
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDao.studentList();
    }

    @Override
    public List<Speaker> speakerList(Integer page, Integer limit) {
   //        设置页码数和显示的条数
// 后面紧跟着数据库查询的相关语句，中间不可以加其他代码
        PageHelper.startPage(page,limit);
        List<Speaker> list = speakerDao.speakerList();

        return list;
    }

    @Override
    public List<Student> studentList(Integer page, Integer limit) {
        //        设置页码数和显示的条数
// 后面紧跟着数据库查询的相关语句，中间不可以加其他代码
        PageHelper.startPage(page,limit);
        List<Student> list2 = studentDao.studentList();

        return list2;

    }

    @Override
    public List<Leave> LeaveList(Integer page, Integer limit) {
        //        设置页码数和显示的条数
// 后面紧跟着数据库查询的相关语句，中间不可以加其他代码
        PageHelper.startPage(page,limit);
//        List<Speaker> list = speakerDao.speakerList();
        List<Leave> leaveList = studentDao.LeaveList();

        return leaveList;
    }


    @Override
    public void deleteSpeaker(Integer id) {
        speakerDao.deleteSpeaker(id);
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        speakerDao.updateSpeaker(speaker);
    }

    @Override
    public Speaker querySpeaker(Integer id) {
        Speaker speaker = speakerDao.querySpeaker(id);
        System.out.println(speaker);
        return speaker;
    }

    @Override
    public Student queryStudent(Integer id) {
        Student student = studentDao.queryStudent(id);
        System.out.println(student);
        return student;
    }

    @Override
    public void addLeave(Leave leave) {
        studentDao.addLeave(leave);
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speakerDao.addSpeaker(speaker);
    }
}
