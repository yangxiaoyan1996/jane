package com.java.base.nmnbl;

/**
 * @Authou YXY
 * @Date 2018/12/7 11:22
 */
public abstract class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}

