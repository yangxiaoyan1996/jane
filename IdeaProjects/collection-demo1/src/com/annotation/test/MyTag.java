package com.annotation.test;

import java.lang.annotation.*;

/**
 * @Authou YXY
 * @Date 2018/10/22 15:47
 */
@Target({ElementType.METHOD})//所修饰的对象范围
@Inherited  //注解可继承
@Retention(RetentionPolicy.RUNTIME)//该注解被保留的时间长短
public @interface MyTag {
    String name() default "车";
    int size() default 10;
}
