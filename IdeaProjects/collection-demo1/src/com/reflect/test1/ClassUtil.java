package com.reflect.test1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Authou YXY
 * @Date 2018/10/17 13:22
 */
public class ClassUtil {
    public static void printClassMessage(Object obj){
        Class c = obj.getClass();
        System.out.println("类的名称是"+c.getName());
        //getMethods是获取所有public的信息，getDeclaredMethods是获得所以该类自己声明的方法
        Method[] ms = c.getMethods();
        for (int i=0;i<ms.length;i++){
            //得到方法的返回值类型名称
            Class returnType = ms[i].getReturnType();
            System.out.println(returnType.getName()+" ");
            //得到方法的名称
            System.out.print(ms[i].getName()+"(");
            //获取参数类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1:paramTypes) {
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
            //printFiledMessage(c);
        }
    }

    public static void printFiledMessage(Object obj) {
        Class c = obj.getClass();

        //获取public成员变量的信息
        Field[] fs = c.getFields();
        //获取该类所有自己声明的成员变量的信息
        Field[] fs1 = c.getDeclaredFields();
        for (Field field:fs) {
            //得到成员变量的类型的类类型
            Class fieldTpye = field.getType();
            String typeName = fieldTpye.getName();
            //得到成员变量的名称
            String filedName = field.getName();
            System.out.println(typeName+" "+filedName);
        }
    }
}
