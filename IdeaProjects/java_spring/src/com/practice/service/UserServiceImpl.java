package com.practice.service;

import com.practice.dao.UserDao;
import com.practice.dao.UserDaoMysqlImpl;

/**
 * @Authou YXY
 * @Date 2018/10/24 15:39
 */
//依赖关系：ClassA使用了ClassB的属性
public class UserServiceImpl implements UserService {
    //引用类型
    private UserDao userDao = new UserDaoMysqlImpl();


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        userDao.insertUser();
    }

}
