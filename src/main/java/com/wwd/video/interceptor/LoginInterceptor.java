package com.wwd.video.interceptor;

import com.wwd.video.entity.Admin;
import com.wwd.video.utils.StrUtils;
import com.wwd.video.entity.Admin;
import com.wwd.video.utils.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);

        Admin admin = (Admin)request.getSession().getAttribute(StrUtils.LOGIN_USER);
        if (admin == null) {
            //还没有登录
            //jquery 发送ajax请求的时候.会有一个特殊的请求头
            String value = request.getHeader("X-Requested-With");
            System.out.println(value);
            //证明是一个ajax请求
            if (value != null && value.equals("XMLHttpRequest")) {
                response.getWriter().write("{'code':0,'info':'未登录'}");
            }else {
                //如果是非ajax请求,直接重定向到登录页面
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
            return false;
        }else {
            return true;
        }


    }
}
