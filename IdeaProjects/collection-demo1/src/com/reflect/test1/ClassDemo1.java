package com.reflect.test1;

/**
 * @Authou YXY
 * @Date 2018/10/17 11:19
 */
public class ClassDemo1 {
    public static void main(String[] args){
        Foo foo1 =new Foo();
        //1.表达方式,任何一个类都有一个隐含的静态成员
        Class c1 = Foo.class;
        //2.类的对象调用get.class()方法
        Class c2 = foo1.getClass();
        //以上两种方式完全一样
        System.out.println(c1 == c2);
        //3.通过class.forName
        Class c3 = null;
        //快捷键:选中该行后，command+alt+T
        try {
            c3 = Class.forName("com.reflect.test1.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //通过类的不带参数的构造方法才创建这个类的一个对象
            Foo foo = (Foo)c1.newInstance();//需要无参构造方法
            foo.print();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
