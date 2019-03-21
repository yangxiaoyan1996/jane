package com.example.news.mysql;

/**
 * 功能描述: 分页对象
 *
 * @param:
 * @return:
 * @auther: MLC
 * @date: 2018/9/17 18:29
 */
public class PagedParam {

    /**
     * 页码
     */
    private Integer p;

    /**
     * 每页显示条数
     */
    private Integer size = 10;

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
}
