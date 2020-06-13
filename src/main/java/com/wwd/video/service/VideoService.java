package com.wwd.video.service;

import com.wwd.video.entity.Video;
import com.wwd.video.vo.VideoInfo;

import java.util.List;

public interface VideoService {
    public List<VideoInfo> videoList(String searchInfo,Integer course_id,Integer speaker_id, Integer page, Integer limit);

    public void deleteVideo(Integer id);

    public void updateVideo(Video video);

    public Video queryVideo(Integer id);

    public void addVideo(Video video);

    public void deleteSomeVideo(String[] ids);
}
