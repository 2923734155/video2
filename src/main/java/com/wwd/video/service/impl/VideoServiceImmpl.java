package com.wwd.video.service.impl;


import com.github.pagehelper.PageHelper;
import com.wwd.video.dao.VideoDao;
import com.wwd.video.entity.Video;
import com.wwd.video.service.VideoService;
import com.wwd.video.vo.VideoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImmpl  implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Override
    public List<VideoInfo> videoList(String searchInfo, Integer course_id, Integer speaker_id, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<VideoInfo> list = videoDao.videoList(searchInfo, course_id, speaker_id);

     return list;
    }

    @Override
    public void deleteVideo(Integer id) {
        videoDao.deleteVideo(id);
    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Override
    public Video queryVideo(Integer id) {
        Video videoInfo = videoDao.queryVideo(id);
        System.out.println(videoInfo);
        return videoInfo;
    }

    @Override
    public void addVideo(Video video) {
        videoDao.addVideo(video);
    }

    @Override
    public void deleteSomeVideo(String[] ids) {
        videoDao.deleteSomeVideo(ids);
    }
}
