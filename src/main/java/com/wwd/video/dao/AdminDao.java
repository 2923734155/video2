package com.wwd.video.dao;


import com.wwd.video.entity.Admin;

public interface AdminDao {
    public Admin findByName(String username);

    public void update(Admin admin);



}
