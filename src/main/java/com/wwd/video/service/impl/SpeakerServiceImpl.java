package com.wwd.video.service.impl;

import com.github.pagehelper.PageHelper;
import com.wwd.video.dao.SpeakerDao;
import com.wwd.video.entity.Speaker;
import com.wwd.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerDao speakerDao;

    @Override
    public List<Speaker> findAllSpeaker() {
        return speakerDao.speakerList();
    }

    @Override
    public List<Speaker> speakerList(Integer page, Integer limit) {
   //        设置页码数和显示的条数
// 后面紧跟着数据库查询的相关语句，中间不可以加其他代码
        PageHelper.startPage(page,limit);
        List<Speaker> list = speakerDao.speakerList();

        return list;
    }

    @Override
    public void deleteSpeaker(Integer id) {
        speakerDao.deleteSpeaker(id);
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        speakerDao.updateSpeaker(speaker);
    }

    @Override
    public Speaker querySpeaker(Integer id) {
        Speaker speaker = speakerDao.querySpeaker(id);
        System.out.println(speaker);
        return speaker;
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speakerDao.addSpeaker(speaker);
    }
}
