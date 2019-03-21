package com.java.base.deepCopy;

/**
 * @Authou YXY
 * @Date 2018/12/11 14:38
 */
public class Test {
    public static void main(String[] args) {

        Address address = new Address();
        address.setAdd("北京市");

        Student stu1 = new Student();
        stu1.setNumber(12345);
        stu1.setAddress(address);


        Student stu2 = (Student) stu1.clone();

        System.out.println("学生1：" + stu1.getNumber() + ",地址：" + stu1.getAddress().getAdd() );
        System.out.println("学生2：" + stu2.getNumber() + ",地址：" + stu2.getAddress().getAdd());

        stu2.setNumber(54321);
        address.setAdd("张家口");

        System.out.println("学生1：" + stu1.getNumber() + ",地址：" + stu1.getAddress().getAdd() );
        System.out.println("学生2：" + stu2.getNumber() + ",地址：" + stu2.getAddress().getAdd());

    }
}
