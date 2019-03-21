package com.anntotion.test3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @Authou YXY
 * @Date 2018/10/23 10:24
 */
public class Test {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(1);//查询ID为10的用户

        Filter f2 = new Filter();
        f2.setUserName("jane");//模糊查询用户名为Jane的用户

        Filter f3 = new Filter();
        f3.setEmail("737565846@qq.com,yangxiaoyan_1028@163.com");//查询任意一个邮箱

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);
    }

    private static String query(Filter f) {
        StringBuilder sb = new StringBuilder();
        //1.获取Class
        Class c = f.getClass();
        //2.获取Table的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if (!exists){
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("SELECT * FROM").append(tableName).append("WHERE 1 = 1");
        //3.遍历所有字段
        Field[] fields = c.getDeclaredFields();
        for (Field field:fields) {
            //4.处理每个字段对应的sql
            //4.1获取字段名
            boolean isExists = c.isAnnotationPresent(Column.class);
            if (!isExists){
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            //4.2拿到字段的值
            String filedName = field.getName();
            String getMethodName = "get" + filedName.substring(0,1).toUpperCase()+filedName.substring(1);
            String fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = (String)getMethod.invoke(f,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //4.3拼装sql
            sb.append("and").append(filedName).append("=").append(fieldValue);

        }

        return sb.toString();
    }
}
