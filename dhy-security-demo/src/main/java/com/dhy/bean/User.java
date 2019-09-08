package com.dhy.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author VGhostHunter
 */
public class User implements UserDetails {

    private static final long serialVersionUID = 1284011010357285456L;

    private String id;

    private String username;

    private String mobile;

    private String password;

    private Integer isExpired;

    private Integer isEnabled;

    private Integer locked;

    private Set<Authority> authorities = new HashSet<>();

    /**
     * 账户是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return 1 == isExpired;
    }

    /**
     * 是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return 1 == locked;
    }

    /**
     * 密码是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否允许登陆
     */
    @Override
    public boolean isEnabled() {
        return 1 == isEnabled;
    }

    /**
     * 权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Integer isExpired) {
        this.isExpired = isExpired;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
