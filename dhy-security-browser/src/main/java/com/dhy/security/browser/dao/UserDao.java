package com.dhy.security.browser.dao;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author VGhostHunter
 */
public interface UserDao {

    UserDetails findUserByUsername(String username);

    UserDetails findUserByMobile(String mobile);
}
