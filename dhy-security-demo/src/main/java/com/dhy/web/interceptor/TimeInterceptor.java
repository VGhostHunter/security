package com.dhy.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author VGhostHunter
 */
// @Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在访问的某一个Controller放在在调用之前  这个方法会被调用
        System.out.println("preHandle");
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("start", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //在Controller方法调用之后  这个方法会被调用  如果在Controller里面抛出了异常 这个方法就不会被调用了
        System.out.println("postHandle");
        Long start = (Long)request.getAttribute("start");
        System.out.println("time interceptor 耗时：" + (System.currentTimeMillis()- start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //不管Controller方法有没有抛出异常 这个方法都会被调用
        System.out.println("afterCompletion");
        Long start = (Long)request.getAttribute("start");
        System.out.println("time interceptor 耗时：" + (System.currentTimeMillis()- start));
        System.out.println("ex is：" + ex);
    }
}
