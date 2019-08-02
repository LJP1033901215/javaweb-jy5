package com.itdr;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class demo1 {
    @Test
    public void test1() throws Exception{
        ComboPooledDataSource name  = new ComboPooledDataSource();
       Connection n =  name.getConnection();
       String sql = "select * from users";
        PreparedStatement ps = n.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){

            System.out.println(rs.getString(2));
        }
    }
    @Test
    public void  n(){
        String n = "/list.do";
        String replace = n.replace(".", "/");
        String[] split = replace.split("/");
        System.out.println(Arrays.toString(split));
        System.out.println(split[1]);
    }

}