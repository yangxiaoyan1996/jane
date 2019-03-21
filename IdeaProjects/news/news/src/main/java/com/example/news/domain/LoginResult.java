package com.example.news.domain;

import java.io.Serializable;

/**
 * @Authou YXY
 * @Date 2018/11/21 22:40
 */
public class LoginResult implements Serializable {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
