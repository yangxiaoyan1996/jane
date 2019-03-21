package com.java.base.deepCopy;

/**
 * @Authou YXY
 * @Date 2018/12/11 14:21
 */
public class Student implements Cloneable{
    private int number;
    private Address address;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Object clone(){
        Student stu = null;
        try {
            stu = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        stu.address = (Address) address.clone();
        return stu;
    }

}
