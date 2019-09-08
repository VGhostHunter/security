package com.dhy.security.browser.mapper;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author VGhostHunter
 */
public interface UserDao {

    UserDetails findUserByUsername(String username);
}
