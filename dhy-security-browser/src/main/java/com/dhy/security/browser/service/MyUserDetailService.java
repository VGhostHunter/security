package com.dhy.security.browser.service;

import com.dhy.security.browser.dao.UserDao;
import com.dhy.security.core.service.IMyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements IMyUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登陆用户名：" + username);
        //根据用户名查找信息
        return userDao.findUserByUsername(username);
    }

    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        logger.info("登陆手机号：" + mobile);
        //根据用户名查找信息
        return userDao.findUserByMobile(mobile);
    }
}
