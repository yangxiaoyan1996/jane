package com.practice.read;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Authou YXY
 * @Date 2018/10/24 16:02
 */
//读取myobject.txt：读取文件中的对象，给对象的属性赋值
public class Container {

    public Container(File file) throws IOException {
        init(file);
    }

    private void init(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;

        while ((line = br.readLine()) != null) {
            String data[] = line.split("=");
        }
    }

}
