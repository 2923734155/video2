package com.wwd.video.service;

import com.wwd.video.entity.Course;
import com.wwd.video.entity.Course2;


import java.util.List;

public interface CourseService {
    public List<Course> CourseList();

    public List<Course> findAll(Integer page,Integer limit);

   public void deleteCourse(int id);

   public void updateCourse(Course2 course2);

   public Course2 findById(int id);

    public void addCourse(Course2 course2);
}
