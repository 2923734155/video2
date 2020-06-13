package com.wwd.video.dao;

import com.wwd.video.entity.User;

public interface UserDao {
    public User findByEmail(String email);

    public void insertUser(User user);

    public void change_profile(User user);
}
