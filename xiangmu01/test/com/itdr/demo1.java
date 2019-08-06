package com.itdr;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import sun.java2d.pipe.OutlineTextRenderer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @Test
    public void test2() throws Exception{
        ComboPooledDataSource name  = new ComboPooledDataSource();
        QueryRunner ne = new QueryRunner(name);
        StringBuffer Q = new StringBuffer();
//        update prooduct set PcategoruID=?  where Pid= ?"
        Q.append("update prooduct set ");
        List<String> na = new ArrayList();
        int a = 0 ;
        na.add("PcategoruID=2 ");
        na.add("Pname=names");
        na.add("Psubtitle=subtitles");
        for (int i = 0;i<na.size();i++){
            if (a == 0) {
                Q.append(na.get(i));
                a++;
            }else {
                Q.append(" , ").append(na.get(i));
                a++;
            }
        }
//        Q.append("PcategoruID=2 ");
//        Q.append( "Pname=names");
        Q.append(" where Pid= ?");
        String Sql = Q.toString();
        System.out.println(Q.toString());
        String sql = "select * from users";
//        int update = ne.update(Sql, 2);
//        System.out.println(update);

    }
}