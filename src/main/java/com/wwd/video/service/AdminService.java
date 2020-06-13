package com.wwd.video.service;


import com.wwd.video.entity.Admin;

public interface AdminService {
    public Admin login(String usernam,String password);

    public void updateHeadImg(Integer id,String imgPath);

    public void updateAdmin(String username,String password1,String password2,Integer id);

    public Admin selectByName(String username);

}
