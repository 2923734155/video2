package com.wwd.video.controller;

import com.wwd.video.entity.User;
import com.wwd.video.service.UserService;
import com.wwd.video.utils.StrUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser.do")
    @ResponseBody
    public String loginUser(@RequestParam("email")String email, @RequestParam("password")String password, HttpSession session){

        User user = userService.login(email);
            if (user == null) {
            return "false";
        } else {
            if (user.getPassword().equals(password)){
                session.setAttribute("userAccount",user.getEmail());
                session.setAttribute(StrUtils.LOGIN_USER,user);
                return "success";
            } else {
                return "false";
            }
        }
    }

    @RequestMapping("/insertUser.do")
    @ResponseBody
    public String insertUser(@RequestParam("email")String email,@RequestParam("psw_again") String psw_again,@RequestParam("password")String password, HttpSession session){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.insertUser(user);

        if (user.getPassword().equals(psw_again)){
            return "success";
        } else {
            return "false";
        }

    }

    @RequestMapping("/loginOut.do")
    @ResponseBody
    public String loginOut(HttpSession session){
        session.removeAttribute(StrUtils.LOGIN_USER);

        return "redirect:/index.jsp";

    }

    @RequestMapping("/showMyProfile.do")
    @ResponseBody

    public String showMyProfile(HttpSession session){
        User user=(User) session.getAttribute(StrUtils.LOGIN_USER);
        HashMap<String, Object> map = new HashMap<>();
        map.put("map",user);


        return "before/my_profile.jsp";
    }
    @RequestMapping("/change_profile.do")
    @ResponseBody
    public String change_profile(@RequestParam("User") User user,HttpSession session){

        User user1 = (User)session.getAttribute(StrUtils.LOGIN_USER);

        userService.change_profile(user);

        return "before/change_profile.jsp";

    }
}
