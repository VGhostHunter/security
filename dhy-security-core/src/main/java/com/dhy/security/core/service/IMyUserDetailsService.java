package com.dhy.security.core.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author VGhostHunter
 */
public interface IMyUserDetailsService extends UserDetailsService {

    UserDetails loadUserByMobile(String mobile);
}
