package com.wwd.video.service.impl;

import com.github.pagehelper.PageHelper;
import com.wwd.video.dao.CourseDao;
import com.wwd.video.entity.Course;
import com.wwd.video.entity.Course2;
import com.wwd.video.entity.SubJect;
import com.wwd.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;


    @Override
    public List<Course> CourseList() {
        return courseDao.findAll();
    }

    @Override
    public List<Course> findAll(Integer page,Integer limit) {

//        设置页码数和显示的条数
// 后面紧跟着数据库查询的相关语句，中间不可以加其他代码
        PageHelper.startPage(page,limit);
        List<Course> list = courseDao.findAll();
//        获取总记录数
        return list;
    }

    @Override
    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);
    }

    @Override
    public void updateCourse(Course2 course2) {
        courseDao.updateCourse(course2);
    }


    @Override
    public Course2 findById(int id) {
        Course2 course2 = courseDao.findById(id);
        System.out.println(course2);
        return course2;
    }

    @Override
    public void addCourse(Course2 course2) {
        courseDao.addCourse(course2);
    }
}
