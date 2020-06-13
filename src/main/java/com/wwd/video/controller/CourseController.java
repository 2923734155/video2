package com.wwd.video.controller;

import com.github.pagehelper.Page;
import com.wwd.video.common.JsonResult;
import com.wwd.video.entity.Admin;
import com.wwd.video.entity.Course;
import com.wwd.video.entity.Course2;
import com.wwd.video.entity.SubJect;
import com.wwd.video.service.CourseService;
import com.wwd.video.utils.JsonUtils;
import com.wwd.video.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courseList.do")
    @ResponseBody
    public Map<String,Object> findAll(HttpSession session, HttpServletResponse response,Integer page,Integer limit){
        Admin admin =(Admin) session.getAttribute(StrUtils.LOGIN_USER);
        System.out.println(admin.getUsername());

        List<Course> list = courseService.findAll(page,limit);

        long total = ((Page) list).getTotal();
        HashMap<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);
        System.out.println(map);
        return map;
    }
//    删除课程操作
    @RequestMapping("/deleteCourse.do")
    @ResponseBody
    public JsonResult deleteCourse(int id){
        courseService.deleteCourse(id);

        JsonResult jsonResult = new JsonResult(1,0,null);
        return jsonResult;
    }
//    修改课程操作
    @RequestMapping("/updateCourse.do")
    @ResponseBody
  public JsonResult update(Course2 course2){
        System.out.println(course2);
        courseService.updateCourse(course2);

        return new JsonResult(1,0,null);
    }
//根据id查询对应的数据
    @RequestMapping("/queryCourse.do")
    @ResponseBody
    public JsonResult queryCourse(int id){

        Course2 course2 = courseService.findById(id);

        JsonResult jsonResult = new JsonResult(1,0, course2);
        return jsonResult;

    }
//    增加

    @RequestMapping("addCourse.do")
    @ResponseBody
    public JsonResult addCourse(Course2 course2) {
        courseService.addCourse(course2);
        return new  JsonResult(1,0,null);
    }

}
