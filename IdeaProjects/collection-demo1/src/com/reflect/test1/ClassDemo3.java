package com.reflect.test1;

/**
 * @Authou YXY
 * @Date 2018/10/17 13:50
 */
public class ClassDemo3{
    public static void main(String[] args) {
        //获取String的所有信息
        String s = "hello";
        ClassUtil.printClassMessage(s);

        //获取Integer的所有信息
        Integer n = 1;
        ClassUtil.printClassMessage(n);
    }


}
