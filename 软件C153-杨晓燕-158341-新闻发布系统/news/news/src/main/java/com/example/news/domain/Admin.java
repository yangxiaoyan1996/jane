package com.example.news.domain;

import lombok.ToString;

/**
 * @Authou YXY
 * @Date 2018/11/15 16:18
 */
@ToString
public class Admin {
    private int id;
    private String adminName;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
