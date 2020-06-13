package com.wwd.video.service.impl;

import com.wwd.video.dao.AdminDao;
import com.wwd.video.entity.Admin;
import com.wwd.video.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
  @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminDao.findByName(username);
        System.out.println("用户信息："+admin);
        if(admin ==null){
            System.out.println("账号不存在");

            }
            if (!admin.getPassword().equals(password)){
                System.out.println("密码错误");
        }
//            if (!admin.getRoles().equals(roles)){
//                System.out.println("用户权限错误");
//            }

        return admin;

    }

    @Override
    public void updateHeadImg(Integer id, String imgPath) {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setImgPath(imgPath);
        adminDao.update(admin);
    }

    @Override
    public void updateAdmin(String username, String password1,String password2, Integer id) {

        if (password1.equals(password2)){
            System.out.println("两次密码不一致");
        }
        Admin admin = new Admin();
        admin.setId(id);
        admin.setPassword(password1);
        admin.setUsername(username);

        adminDao.update(admin);


    }

    @Override
    public Admin selectByName(String username) {
        return adminDao.findByName(username);
    }
}
