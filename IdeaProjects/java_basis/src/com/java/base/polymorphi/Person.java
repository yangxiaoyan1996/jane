package com.java.base.polymorphi;

import java.io.Serializable;

/**
 * @Authou YXY
 * @Date 2018/12/5 15:11
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 2631590509760908280L;

    private String name;
    private Email email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Person(String name,Email email){
        this.name = name;
        this.email = email;
    }
    /*protected Person clone(){
        Person person = null;
        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }*/
}
