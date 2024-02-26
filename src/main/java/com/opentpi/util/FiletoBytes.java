package com.opentpi.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FiletoBytes {

    public FiletoBytes(String file_name) {
    }
    /**
     * @Description:    只需要传入文件的绝对路径就可以进行转化
     *  需要根据文件大小修改bytes大小
     */
    public String FiletoBytes(String filename ){
        String buf = null;
        // 20m
        byte[] bytes = new byte[4096];
        File file = new File(filename);

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            fis.read(bytes);
            buf = Arrays.toString(bytes);
            fis.close();
            return buf;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return buf;
    }
    /**
     * @Description:    bytes大小需要传入设置
     */
    public String FiletoBytes(String filename ,byte[] bytes){
        String buf = null;
        File file = new File(filename);

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            fis.read(bytes);
            buf = Arrays.toString(bytes);
            fis.close();
            return buf;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return buf;
    }

}