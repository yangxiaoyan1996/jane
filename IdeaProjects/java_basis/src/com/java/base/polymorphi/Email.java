package com.java.base.polymorphi;

import java.io.Serializable;

/**
 * @Authou YXY
 * @Date 2018/12/5 15:11
 */
public class Email implements Serializable {
    private static final long serialVersionUID = 1267293988171991494L;

    private String title;
    private String content;

    public Email(String title, String content) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
