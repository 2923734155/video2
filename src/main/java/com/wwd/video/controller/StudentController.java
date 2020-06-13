package com.wwd.video.controller;

import com.github.pagehelper.Page;
import com.wwd.video.common.JsonResult;
import com.wwd.video.entity.Admin;
import com.wwd.video.entity.Leave;
import com.wwd.video.entity.Speaker;
import com.wwd.video.entity.Student;
import com.wwd.video.service.SpeakerService;
import com.wwd.video.service.StudentService;
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
public class StudentController {
    @Autowired
    private SpeakerService speakerService;

    @Autowired
    private StudentService studentService;



//    @RequestMapping("/speakerList.do")

    @RequestMapping("/studentList.do")
    @ResponseBody
    public Map<String,Object> studentList(HttpSession session, HttpServletResponse response,Integer page,Integer limit){
        List<Speaker> list = speakerService.speakerList(page,limit);

        List<Student> students = studentService.studentList(page, limit);
        long total = ((Page) list).getTotal();

        HashMap<String, Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",students);
        System.out.println(map);
        return map;
    }

//
//    @RequestMapping("/speakerList.do")
//    @ResponseBody
//    public Map<String,Object> speakerList(HttpSession session, HttpServletResponse response,Integer page,Integer limit){
//        List<Speaker> list = speakerService.speakerList(page,limit);
//        long total = ((Page) list).getTotal();
//
//        HashMap<String, Object> map = new HashMap();
//        map.put("code",0);
//        map.put("msg","");
//        map.put("count",total);
//        map.put("data",list);
//        System.out.println(map);
//        return map;
//    }


    @RequestMapping("/listLeave.do")
    @ResponseBody
    public Map<String,Object> LeaveList(HttpSession session, HttpServletResponse response,Integer page,Integer limit){
//        List<Speaker> list = speakerService.speakerList(page,limit);
        List<Leave> leaveList = studentService.LeaveList(page, limit);
        long total = ((Page) leaveList).getTotal();

        HashMap<String, Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",leaveList);
        System.out.println(map);
        return map;
    }


////    删除
//    @RequestMapping("/deleteSpeaker.do")
//    @ResponseBody
//    public JsonResult deleteSpeaker(Integer id){
//        speakerService.deleteSpeaker(id);
//        return new JsonResult(1,0,null);
//    }
////    修改
//    @RequestMapping("/updateSpeaker.do")
//    @ResponseBody
//    public JsonResult update(Speaker speaker){
//        speakerService.updateSpeaker(speaker);
//        return new JsonResult(1,0,null);
//    }
////根据id查询对象
//    @RequestMapping("/querySpeaker.do")
//    @ResponseBody
//    public JsonResult querySpeaker(Integer id){
//        Speaker speaker = speakerService.querySpeaker(id);
//        System.out.println(speaker);
//        return new JsonResult(1,0,speaker);
//    }

    //根据id查询学生信息
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public JsonResult queryStudent(HttpSession session){
//        Speaker speaker = speakerService.querySpeaker(id);

        Admin admin = (Admin) session.getAttribute(StrUtils.LOGIN_USER);
        Student student = studentService.queryStudent(admin.getId());
        System.out.println(student);
        return new JsonResult(1,0,student);
    }

 //   增加
    @RequestMapping("/addLeave.do")
    @ResponseBody
    public JsonResult addLeave(Leave leave){
//        speakerService.addSpeaker(speaker);
        studentService.addLeave(leave);
        return new JsonResult(1,0,null);
    }



////    增加
//    @RequestMapping("/addSpeaker.do")
//    @ResponseBody
//    public JsonResult addSpeaker(Speaker speaker){
//        speakerService.addSpeaker(speaker);
//        return new JsonResult(1,0,null);
//    }
}
