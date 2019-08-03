package com.itdr.utils;

import java.util.Arrays;
//创建一个获取地址的工具类
public class PathUtil {
    public static String getPath(String path){
        String replace = path.replace(".", "/");//     /ppp/do
        String[] split = replace.split("/");//       ppp do
        return split[1];
    }
}
