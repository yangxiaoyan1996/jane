package com.example.news.domain;


import java.io.Serializable;

/**
 * @Authou YXY
 * @Date 2018/11/14 10:49
 */
public class Category implements Serializable {
    private int Id;
    private String category;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
