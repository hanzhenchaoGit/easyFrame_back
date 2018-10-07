package com.frank.boot.utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    // 判断文件是否存在 不存在就创建
    public static boolean checkFileExists(File file) {

        if (file.exists()) {
            System.out.println("file exists");
        } else {
            System.out.println("file not exists, create it ...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file.exists();

    }

    // 判断文件夹是否存在
    public static boolean checkDirExists(File file) {

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("dir exists");
            } else {
                System.out.println("the same name file exists, can not create dir");
            }
        } else {
            System.out.println("dir not exists, create it ...");
            file.mkdir();
        }
        return file.exists();

    }
}
