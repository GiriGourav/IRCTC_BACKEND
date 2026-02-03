package com.irctc.backend.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeLoggerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       Request Process hone se pahle
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime= (Long)request.getAttribute("startTime");
        long endTime=System.currentTimeMillis();
        long timeTaken=endTime-startTime;

        System.out.println("[Execution Time]" +request.getRequestURI()+ ":"+timeTaken + "ms" );
    }
}
