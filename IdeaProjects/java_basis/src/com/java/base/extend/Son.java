package com.java.base.extend;

/**
 * @Authou YXY
 * @Date 2018/12/7 10:34
 */
public class Son {
    class Father1 extends Father{
        public int strong(){
            return super.strong() + 1;
        }
    }

    class Mother1 extends Mother{
        public int kind(){
            return super.kind() - 1;
        }
    }

    public int getStrong(){
        return new Father1().strong();
    }

    public int getKind(){
        return new Mother1().kind();
    }
}
