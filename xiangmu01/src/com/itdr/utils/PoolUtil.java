package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//创建连接池的工具
public class PoolUtil {
    public static ComboPooledDataSource n = new ComboPooledDataSource();
    public static ComboPooledDataSource getCom(){
        return n;
    }
}
