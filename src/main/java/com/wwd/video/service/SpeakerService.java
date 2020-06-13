package com.wwd.video.service;

import com.wwd.video.entity.Speaker;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SpeakerService {

    public List<Speaker> findAllSpeaker();

    public List<Speaker> speakerList(Integer page,Integer limit);

    public void deleteSpeaker(Integer id);

    public void updateSpeaker(Speaker speaker);

    public Speaker querySpeaker(Integer id);

    public void addSpeaker(Speaker speaker);
}
