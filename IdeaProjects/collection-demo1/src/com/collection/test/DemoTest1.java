package com.collection.test;

import java.util.HashSet;
import java.util.Random;

/**
 * @Authou YXY
 * @Date 2018/10/18 18:05
 */
public class DemoTest1 {
    public static void main(String[] args) {
//        Random random = new Random();
//        HashSet<Integer> hashSet = new HashSet<>();
//        while (hashSet.size()<10){
//            hashSet.add(random.nextInt(20)+1);
//
//            for (Integer integer : hashSet) {
//                System.out.println(integer);
//            }
//        }
        //1.创建Random对象
        Random r = new Random();
        //2.创建HashSet对象
        HashSet<Integer> hs = new HashSet<>(); 	//注意是包装类不是int
        //3.判断并添加元素
        while(hs.size()< 10) {
            //4.通过Random中随机方法nextInt()获取1到20范围内随机数
            hs.add(r.nextInt(20) + 1); 		//如果不加1，随机范围是0到19
        }

        //5.遍历HashSet
        for (Integer integer : hs) {
            System.out.print(integer+" ");
        }


    }
}
