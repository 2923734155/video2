package com.wwd.video.controller;

import com.wwd.video.entity.SubJect;
import com.wwd.video.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("/subjectList.do")
    @ResponseBody
    public Map<String,Object> subjectList(){
        HashMap<String, Object> map = new HashMap<>();

        List<SubJect> list = subjectService.findSubAll();

        map.put("subject",list);
        return map;
    }


}
