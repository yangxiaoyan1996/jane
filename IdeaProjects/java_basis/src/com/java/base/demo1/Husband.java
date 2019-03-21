package com.java.base.demo1;

/**
 * @Authou YXY
 * @Date 2018/12/4 10:56
 */
public class Husband {
    private String name;
    private String sex;
    private int age;
    private Wife wife;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setWife(Wife wife) {
        this.wife = wife;
    }


}
