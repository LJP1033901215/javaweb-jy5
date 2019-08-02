package com.itdr;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class asd {
    public static void main(String[] args) {
        ComboPooledDataSource n = new ComboPooledDataSource();
        Statement d = null;
        try{
            Connection c = n.getConnection();
            String name = "select * from test1";
            d =  c.createStatement();
            ResultSet a = d.executeQuery(name);
            while (a.next()){
                System.out.println(a.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
