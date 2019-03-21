package com.anntotion.test2;

import java.lang.annotation.*;

/**
 * @Authou YXY
 * @Date 2018/10/22 18:34
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String desc();
    String author();
    int age() default 18;
}
