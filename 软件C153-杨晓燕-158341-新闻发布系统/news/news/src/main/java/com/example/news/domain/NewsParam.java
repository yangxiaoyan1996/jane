package com.example.news.domain;

import com.example.news.mysql.PagedParam;

/**
 * @Authou YXY
 * @Date 2018/11/19 19:24
 */
public class NewsParam extends PagedParam {
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
