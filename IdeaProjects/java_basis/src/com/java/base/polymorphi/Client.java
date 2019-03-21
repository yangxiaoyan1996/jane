package com.java.base.polymorphi;

/**
 * @Authou YXY
 * @Date 2018/12/5 15:18
 */
public class Client {
    public static void main(String[] args) {
        Email email = new Email("请参加会议","请与今天12：30到会议室参见会议。。。");

        Person person1 = new Person("张三",email);

//        Person person2 = person1.clone();
        Person person2 = CloneUtils.clone(person1);
        person2.setName("李四");

//        Person person3 = person1.clone();
        Person person3 = CloneUtils.clone(person1);
        person3.setName("王五");
        person1.getEmail().setContent("12:00");

        System.out.println(person1.getName() + "邮件内容是" +person1.getEmail().getContent());
        System.out.println(person2.getName() + "邮件内容是" +person2.getEmail().getContent());
        System.out.println(person3.getName() + "邮件内容是" +person3.getEmail().getContent());


    }
}
