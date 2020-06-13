package com.wwd.video.service;

import com.wwd.video.entity.User;

public interface UserService {

    public User login(String email);

    public void insertUser(User user);

    public void change_profile(User user);
}
