package com.itdr.utils;

import java.util.Arrays;
//创建一个获取地址的工具类
public class PathUtil {
    public static String getPath(String path){
        String replace = path.replace(".", "/");
        String[] split = replace.split("/");
        return split[1];
    }
}
