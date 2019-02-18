package com.example.news.dao;

import com.example.news.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Authou YXY
 * @Date 2018/11/15 16:19
 */
@Repository
public interface AdminDao {
    Admin isAdminExist(@Param("adminName") String adminName);
    Admin login(@Param("adminName") String adminName, @Param("password") String password);
}
