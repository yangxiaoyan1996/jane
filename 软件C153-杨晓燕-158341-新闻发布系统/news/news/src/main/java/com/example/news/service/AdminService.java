package com.example.news.service;

import com.example.news.domain.Admin;
/**
 * @Authou YXY
 * @Date 2018/11/15 16:29
 */
public interface AdminService {
    boolean isAdminExist(String adminName);
    Admin login(String adminName ,String password);
}
