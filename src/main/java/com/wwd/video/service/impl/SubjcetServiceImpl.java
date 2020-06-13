package com.wwd.video.service.impl;

import com.wwd.video.dao.SubjectDao;
import com.wwd.video.entity.SubJect;
import com.wwd.video.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjcetServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;
    @Override
    public List<SubJect> findSubAll() {
        List<SubJect> list = subjectDao.subjectList();
        return list;
    }
}
