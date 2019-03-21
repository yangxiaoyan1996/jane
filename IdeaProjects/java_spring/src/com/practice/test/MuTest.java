package com.practice.test;

import com.practice.service.UserService;
import com.practice.service.UserServiceImpl;

/**
 * @Authou YXY
 * @Date 2018/10/24 15:50
 */
public class MuTest {
    public static void main(String[] args) {
        //创建Service对象
        UserService service = new UserServiceImpl();
        service.addUser();

    }
}
