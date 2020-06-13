package com.wwd.video.dao;

import com.wwd.video.entity.Video;
import com.wwd.video.vo.VideoInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoDao {
//    public List<VideoInfo> videoList(@Param("searchInfo") String searchInfo,@Param("course_id")Integer course_id,@Param("speaker_id")Integer speaker_id);
public List<VideoInfo> videoList(@Param("searchInfo") String searchInfo, @Param("course_id") Integer course_id, @Param("speaker_id") Integer speaker_id);

    public void deleteVideo(Integer id);

    public void updateVideo(Video video);

    public Video queryVideo(Integer id);

    public void addVideo(Video video);

    public void deleteSomeVideo(String [] ids);

}
