package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    //数据层
    public List<Users> selctALL(String pageSize, String pageNum) {
        ComboPooledDataSource co = PoolUtil.getCom();//调用自己创建的连接池工具类中的方法
        QueryRunner qr = new QueryRunner(co);//使用DBUtils传入连接池进去
        String Sql = "select * from users ";//创建sql语句
        List<Users> li = null;
        try {
           li = qr.query(Sql, new BeanListHandler<Users>(Users.class));//使用连接池的方法
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public Users selctOne(String username, String password) {
        ComboPooledDataSource co = PoolUtil.getCom();//调用自己创建的连接池工具类中的方法
        QueryRunner qr = new QueryRunner(co);//使用DBUtils传入连接池进去

        String Sql = "select * from users where uname = ? and upwd = ?";//创建sql语句
        Users u = null;
        try {
            u = qr.query(Sql, new BeanHandler<Users>(Users.class),username,password);//使用连接池的方法
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
