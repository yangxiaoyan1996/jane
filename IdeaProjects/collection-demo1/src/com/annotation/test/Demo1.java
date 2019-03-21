//package com.annotation.test;
//
//import java.lang.annotation.Annotation;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Target;
//import java.lang.reflect.Field;
//
///**
// * @Authou YXY
// * @Date 2018/10/22 14:51
// */
//
//public class Demo1 {
//    public static void annoProcess(AnntotionDmeo anntotionDmeo){
//        for (Field filed: anntotionDmeo.getClass().getDeclaredFields()) {
//            if (filed.isAnnotationPresent(MyTag.class)){
//                Annotation[] myTag = filed.getAnnotations();
//            }
//        }
//    }
//    public static void main(String[] args) {
//
//    }
//}
