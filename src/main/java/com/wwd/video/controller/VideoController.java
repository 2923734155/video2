package com.wwd.video.controller;

import com.github.pagehelper.Page;

import com.wwd.video.common.JsonResult;
import com.wwd.video.entity.Course;
import com.wwd.video.entity.Speaker;
import com.wwd.video.entity.Video;
import com.wwd.video.service.CourseService;
import com.wwd.video.service.SpeakerService;
import com.wwd.video.service.VideoService;


import com.wwd.video.vo.VideoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/videoList.do")
    @ResponseBody
    public Map<String, Object> videoList(String searchInfo, Integer course_id, Integer speaker_id, Integer page, Integer limit) {

        List<VideoInfo> list = videoService.videoList(searchInfo, course_id, speaker_id, page, limit);

        long total = ((Page) list).getTotal();

        HashMap<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        System.out.println(map);
        return map;
    }

    //    下拉框
    @RequestMapping("/findSAC.do")
    @ResponseBody
    public Map<String, Object> findSAC() {
        HashMap<String, Object> map = new HashMap<>();

        List<Speaker> allSpeaker = speakerService.findAllSpeaker();

        List<Course> list = courseService.CourseList();

        map.put("course", list);
        map.put("speaker", allSpeaker);
        return map;


    }

    //    删除
    @RequestMapping("/deleteVideo.do")
    @ResponseBody
    public JsonResult deleteVideo(Integer id) {
        videoService.deleteVideo(id);

        return new JsonResult(1, 0,null);
    }

    //    修改
    @RequestMapping("/updateVideo.do")
    @ResponseBody
    public JsonResult updateVideo(Video video) {
        videoService.updateVideo(video);
        return new JsonResult(1,0, null);
    }

    //    根据id查询对象
    @RequestMapping("/queryVideo.do")
    @ResponseBody
    public JsonResult queryVideo(Integer id) {
        Video Video = videoService.queryVideo(id);
        System.out.println(Video);
        return new JsonResult(1, 0,Video);

    }

    //    增加
    @RequestMapping("/addVideo.do")
    @ResponseBody
    public JsonResult addVideo(Video video) {
        videoService.addVideo(video);
        return new JsonResult(1,0, null);
    }

    //    批量删除
    @RequestMapping("/deleteSomeVideo.do")
    @ResponseBody
    public JsonResult deleteSomeVideo(String string) {
        String[] split = string.split(",");
        videoService.deleteSomeVideo(split);
        return new JsonResult(1,0, null);

    }
}
