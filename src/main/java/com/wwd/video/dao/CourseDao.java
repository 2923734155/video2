package com.wwd.video.dao;

import com.wwd.video.entity.Course;
import com.wwd.video.entity.Course2;


import java.util.List;

public interface CourseDao {
    public List<Course> findAll();

    public void deleteCourse(int id);

    public void updateCourse(Course2 course2);

    public Course2 findById(int id);

    public void addCourse(Course2 course2);
}
