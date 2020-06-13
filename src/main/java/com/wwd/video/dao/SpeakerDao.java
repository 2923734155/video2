package com.wwd.video.dao;

import com.wwd.video.entity.Speaker;

import java.util.List;

public interface SpeakerDao {
    public List<Speaker> speakerList();

    public void deleteSpeaker(Integer id);

    public void updateSpeaker(Speaker speaker);

    public Speaker querySpeaker(Integer id);

    public void addSpeaker(Speaker speaker);
}
