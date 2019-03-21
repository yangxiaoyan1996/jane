package com.example.news.controller;

import com.example.news.domain.Admin;
import com.example.news.domain.LoginResult;
import com.example.news.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @Authou YXY
 * @Date 2018/11/15 16:32
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/login")
    public LoginResult login(Admin admin, HttpServletRequest httpServletRequest  , HttpSession httpSession) {

        boolean checkName = (null == admin.getAdminName() || "".equals(admin.getAdminName()));
        boolean checkPassword = (null == admin.getPassword() || "".equals(admin.getPassword()));
        String loginResult ;
        if (checkName || checkPassword) {
            httpServletRequest.setAttribute("nullNameAndPassword", "用户名和密码不能为空");
            loginResult =  "nullLogin";
        }else {
            System.out.println(">>>>>>>>");
            if (!adminService.isAdminExist(admin.getAdminName())) {
                loginResult =  "notAdminLogin";
            } else {
                System.out.println(">>>>>>>>sdfdsfsdf");

                Admin login = adminService.login(admin.getAdminName(), admin.getPassword());
                if (null != login) {
                    System.out.println(">>>>>>>>");
                    loginResult =  "success";
                } else {
                    loginResult =  "errorPwd";
                }
            }

        }
        LoginResult result = new LoginResult();
        result.setResult(loginResult);
        return result;
    }

    }



