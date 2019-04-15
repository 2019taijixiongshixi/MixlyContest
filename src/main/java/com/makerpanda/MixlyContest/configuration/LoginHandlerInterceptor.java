package com.makerpanda.MixlyContest.configuration;

import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherLoginService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        start = System.currentTimeMillis();
        if(TeacherLoginService.teacher != null || StudentLoginService.student != null)
            return true;
        else {
            httpServletResponse.sendRedirect("login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o,
                                Exception e) throws Exception {
    }
}