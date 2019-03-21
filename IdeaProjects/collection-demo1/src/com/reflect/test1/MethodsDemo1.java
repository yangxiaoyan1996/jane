package com.reflect.test1;

import java.lang.reflect.Method;

/**
 * @Authou YXY
 * @Date 2018/10/17 16:33
 */
public class MethodsDemo1 {
    public static void main(String[] args) {
        A a1 = new A();
        Class c = a1.getClass();


        try {
            //Method m = c.getMethods("print",new Class[]{int.class,int.class});
            Method m = c.getMethod("print", int.class, int.class);

            //a1.print(10,20);
            //方法的反射操作是用m对象来进行方法的调用，和a1的方法完全一致
            Object o = m.invoke(a1,10,20);

        } catch (Exception e) {
                e.printStackTrace();
        }
    }

}
class A{
    public void print(int a,int b){
        System.out.println(a+b);
    }
    public void print1(String a,String b){
        //toUpperCase是将小写字母转换为大写
        System.out.println(a.toUpperCase()+","+b.toLowerCase());
    }
}
