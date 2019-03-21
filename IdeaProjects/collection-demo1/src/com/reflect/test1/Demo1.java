package com.reflect.test1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Authou YXY
 * @Date 2018/10/19 14:30
 */
public class Demo1 {
    private String name = "Jane";
    public int age = 22;
    //构造方法
    public void persom(){}
    private void say(){
        System.out.println("这是一个私有方法");
    }
    public void work(){
        System.out.println("这是一个公有方法");
    }

    public static void main(String[] args) {


    Demo1 demo1 = new Demo1();
    Class c1 = demo1.getClass();

    //获取完成的类的名字
    String classname = c1.getName();
        System.out.println(classname);

        //获取public类的属性
        Field[] fields = c1.getFields();
        for (Field field:fields) {
            System.out.println(field.getName());
        }
        //获取所有的属性
        Field[] fields1 = c1.getDeclaredFields();
        for (Field field1:fields1) {
            System.out.print("suoyou:"+field1.getName()+" ");
        }
        //获取public方法
        Method[] methods = c1.getMethods();
        for (Method method:methods) {
            System.out.println("ff:"+method);
        }
        //获得指定的属性
        try {
            Field field = c1.getField("age");
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


}
