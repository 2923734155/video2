package com.wwd.video.service.impl;

import com.wwd.video.dao.UserDao;
import com.wwd.video.entity.User;
import com.wwd.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void insertUser(User user) {

        userDao.insertUser(user);
    }

    @Override
    public void change_profile(User user) {
        userDao.change_profile(user);
    }
}
