package com.dhy.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author VGhostHunter
 */
// @Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter Init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TimeFilter Start");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时：" + (System.currentTimeMillis() - start));
        System.out.println("TimeFilter Finish");
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter Destory");
    }
}
