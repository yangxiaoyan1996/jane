package com.reflect.test1;

/**
 * @Authou YXY
 * @Date 2018/10/17 13:06
 */
public class ClassDemo2 {
    //主方法快捷键psvm
    public static void main(String[] args) {
    Class c1 = int.class;
    Class c2 = String.class;
    Class c3 = double.class;
    Class c4 = Double.class;
    Class c5 = void.class;
    //sout是输出语句快捷键
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
        System.out.println(c2.getSimpleName());//不包含包名的类的名称

    }
}
