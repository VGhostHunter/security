package com.dhy.bean;

import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

/**
 * @author VGhostHunter
 */
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 5496002851233236900L;

    private int id;

    private int uid;

    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return id == authority1.id &&
                uid == authority1.uid &&
                Objects.equals(authority, authority1.authority);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uid, authority);
    }
}
