package com.java.base.deepCopy;

/**
 * @Authou YXY
 * @Date 2018/12/11 16:36
 */
public class Address implements Cloneable {
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public Object clone(){
        Address address = null;

        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }
}
