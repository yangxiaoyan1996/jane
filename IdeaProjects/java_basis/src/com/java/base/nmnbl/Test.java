package com.java.base.nmnbl;

/**
 * @Authou YXY
 * @Date 2018/12/7 11:27
 */
public class Test {
    public void test(Bird bird){
        System.out.println(bird.getName() + "能够飞" + bird.fly() + "米");
    }

    public static void main(String[] args) {
        Test test = new Test();
        //在Test类中，test()方法接受一个Bird类型的参数，
        // 同时我们知道一个抽象类是没有办法直接new的，
        // 我们必须要先有实现类才能new出来它的实现类实例。
        // 所以在main方法中直接使用匿名内部类来创建一个Bird实例。
        test.test(new Bird() {
            @Override
            public int fly() {
                return 10000;
            }

            public String getName(){
                return "大雁";
            }

        });
    }
}
