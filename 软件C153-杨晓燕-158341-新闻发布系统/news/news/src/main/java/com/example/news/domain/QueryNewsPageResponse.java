package com.example.news.domain;

import java.util.List;

/**
 * @Authou YXY
 * @Date 2018/11/20 15:24
 */
public class QueryNewsPageResponse<T> {

    private Integer p;

    private Integer size;

    private List<T> newsList;

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<T> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<T> newsList) {
        this.newsList = newsList;
    }
}
