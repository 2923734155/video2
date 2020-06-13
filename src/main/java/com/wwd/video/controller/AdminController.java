package com.wwd.video.controller;

import com.wwd.video.common.JsonResult;
import com.wwd.video.entity.Admin;
import com.wwd.video.service.AdminService;
import com.wwd.video.utils.StrUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.IOException;

@Controller
@Validated
public class AdminController {


    @Autowired
    private AdminService adminService;
//
//    @RequestMapping("/query.do")
//    @ResponseBody
//    public JsonResult adminInfo(HttpSession session) {
//        Admin admin = (Admin) session.getAttribute(StrUtils.LOGIN_USER);
//
//        Admin admin1 = adminService.selectByName(admin.getUsername());
//        System.out.println(admin1.getImgPath());
//
//        JsonResult result = null;
//        if (admin != null) {
//            result = new JsonResult(1, admin1);
//        } else {
//            result = new JsonResult(0, "未登录");
//        }
//
//        return result;
//    }

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(@NotEmpty String username, @Size(max = 12, min = 3) String password,Integer type, HttpSession session) {
        Admin admin = adminService.login(username, password);

        System.out.println("用户名："+username+"密码:"+password+"角色类型:"+type);



        session.setAttribute(StrUtils.LOGIN_USER, admin);
        JsonResult jsonResult =new JsonResult(0,0,null);
        if (type == 1){
            jsonResult = new JsonResult(1,1, null);
        }
        if (type == 2){
            jsonResult = new JsonResult(1,2, null);
        }
        if (type == 3){
            jsonResult = new JsonResult(1,3, null);
        }
        return jsonResult;


    }

    @RequestMapping("/upload.do")
    @ResponseBody
    public JsonResult uploadFile2(@RequestParam("file") MultipartFile upfile, String name, HttpSession session) {
        //获取登录的对象uid
        Admin admin = (Admin) session.getAttribute(StrUtils.LOGIN_USER);

        System.out.println(admin);
        //1.上传文件的目录
        String dir = "D:/upload";
        //2.获取上传文件的名字
        String filename = upfile.getOriginalFilename();
        System.out.println(filename);
        //3.判断目录是非存在
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        //4.要保存的文件的file对象
        File newFile = new File(dir, filename);
        try {
            upfile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //操作数据库
        adminService.updateHeadImg(admin.getId(), "/upload/" + filename);


        return new JsonResult(1,0,"头像上传成功，请重新登录");
    }

    @RequestMapping("/updateAdmin.do")
    @ResponseBody
    public JsonResult updateAdmin(HttpSession session, String username, String password1, String password2) {
        Admin admin = (Admin) session.getAttribute(StrUtils.LOGIN_USER);
        System.out.println(admin);

        System.out.println(username + ":" + password1 + ":" + password2 + ":" + admin.getId());

        adminService.updateAdmin(username, password1, password2, admin.getId());

        return new JsonResult(1,0, null);

    }


}
