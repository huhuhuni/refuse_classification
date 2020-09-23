package com.huni.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminLoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("admin") ==null){
            //System.out.println(request.getSession().getId()+request.getSession().getAttribute("user"));
            response.sendRedirect("/admin/login");
            return  false;
        }
        return  true;
 }
}