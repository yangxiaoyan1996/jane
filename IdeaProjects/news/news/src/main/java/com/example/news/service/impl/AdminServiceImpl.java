package com.example.news.service.impl;

import com.example.news.dao.AdminDao;
import com.example.news.domain.Admin;
import com.example.news.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Authou YXY
 * @Date 2018/11/15 16:31
 */

@Service
public class AdminServiceImpl implements AdminService {

    Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean isAdminExist(String adminName) {
        System.out.println("dadadada");
        Admin admin = adminDao.isAdminExist(adminName);
        if (null != admin) {
            log.info(admin.toString());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Admin login(String adminName, String password) {
        Admin admin = adminDao.login(adminName, password);

        if (admin != null) {
            if (adminName.equals(adminName) && password.equals(password)) {
                return admin;
            }
        }
        return null;

    }

}
