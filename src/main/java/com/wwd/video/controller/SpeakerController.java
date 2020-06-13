package com.wwd.video.controller;

import com.github.pagehelper.Page;
import com.wwd.video.common.JsonResult;
import com.wwd.video.entity.Speaker;
import com.wwd.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Signature;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

@Controller
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/speakerList.do")
    @ResponseBody
    public Map<String,Object> speakerList(HttpSession session, HttpServletResponse response,Integer page,Integer limit){
        List<Speaker> list = speakerService.speakerList(page,limit);
        long total = ((Page) list).getTotal();

        HashMap<String, Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);
        System.out.println(map);
        return map;
    }
//    删除
    @RequestMapping("/deleteSpeaker.do")
    @ResponseBody
    public JsonResult deleteSpeaker(Integer id){
        speakerService.deleteSpeaker(id);
        return new JsonResult(1,0,null);
    }
//    修改
    @RequestMapping("/updateSpeaker.do")
    @ResponseBody
    public JsonResult update(Speaker speaker){
        speakerService.updateSpeaker(speaker);
        return new JsonResult(1,0,null);
    }
//根据id查询对象
    @RequestMapping("/querySpeaker.do")
    @ResponseBody
    public JsonResult querySpeaker(Integer id){
        Speaker speaker = speakerService.querySpeaker(id);
        System.out.println(speaker);
        return new JsonResult(1,0,speaker);
    }
//    增加
    @RequestMapping("/addSpeaker.do")
    @ResponseBody
    public JsonResult addSpeaker(Speaker speaker){
        speakerService.addSpeaker(speaker);
        return new JsonResult(1,0,null);
    }
}
