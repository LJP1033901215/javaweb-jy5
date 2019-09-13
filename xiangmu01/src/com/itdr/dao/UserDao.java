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
    //传去分页的数据查询所有的数据
    public List<Users> selctALL(String pageSize, String pageNum) {
        ComboPooledDataSource co = PoolUtil.getCom();//调用自己创建的连接池工具类中的方法
        QueryRunner qr = new QueryRunner(co);//使用DBUtils传入连接池进去
        String Sql = "select * from users order by uyhlx DESC ";//创建sql语句
        List<Users> li = null;
        try {
           li = qr.query(Sql, new BeanListHandler<Users>(Users.class));//使用连接池的方法
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
    //根据账户和密码进行查询
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
    //根据uid查询数据
    public Users selctOne(Integer uid) {
        ComboPooledDataSource co = PoolUtil.getCom();//调用自己创建的连接池工具类中的方法
        QueryRunner qr = new QueryRunner(co);//使用DBUtils传入连接池进去
        String Sql = "select * from users where uid = ?";//创建sql语句
        Users u = null;
        try {
            u = qr.query(Sql, new BeanHandler<Users>(Users.class),uid);//使用连接池的方法
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    //根据uid禁用一个用户
    public Integer updateByUid(Integer uid,Integer state) {
        ComboPooledDataSource co = PoolUtil.getCom();//使用自己创建的工具类创建连接池
        QueryRunner qr = new QueryRunner(co);//使用DBUtils
        String Sql = "update users set uzc = ? where uid = ?";//SQL语句
        Integer u = null;//接收返回值
        try {
             u =  qr.update(Sql,state,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;//返回成功否，成功为1
    }
//开启禁用的方法
//    public Integer noupdateByUid(Integer uid) {
//        ComboPooledDataSource co = PoolUtil.getCom();//使用自己创建的工具类创建连接池
//        QueryRunner qr = new QueryRunner(co);//使用DBUtils
//        String Sql = "update users set uzc = 0 where uid = ?";//SQL语句
//        Integer u = null;//接收返回值
//        try {
//            u =  qr.update(Sql,uid);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return u;//返回成功否，成功为1
//    }
}
