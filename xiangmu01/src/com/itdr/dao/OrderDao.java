package com.itdr.dao;

import com.itdr.pojo.Order;
import com.itdr.pojo.Poiduct;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
//--------------------------------------------------查询所有的订单的方法------------------------------------------------
    public List<Order> OrderAll(String pageNum, String pageSize) {
        ComboPooledDataSource co = PoolUtil.getCom();//创建连接池
        QueryRunner qr = new QueryRunner(co);//创建DBUilts
//        Integer pageNum= Integer.parseInt(pageNums);//转型
//        Integer pageSize = Integer.parseInt(pageSizes);//转型
        String Sql = "SELECT * FROM  `order`";//创建SQL语句
        List<Order> li = null;//创建List数组
        try {
            li = qr.query(Sql,new BeanListHandler<Order>(Order.class));//所有订单的方法
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
//---------------------------------------------------根据订单号查询订单-------------------------------------------------
    public Order OrderOne(String orderNos) {
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        String orderNo = orderNos;
        String Sql = "select * from  `order` where orderNo = ?";
        Order li = null;
        try {
            li = qr.query(Sql, new BeanHandler<Order>(Order.class), orderNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
//-------------------------------------------------根据订单号更改发货的状态----------------------------------------------
    public Integer Ordersend_goods(String orderNos) {
        ComboPooledDataSource co = PoolUtil.getCom();
        Integer orderNo = Integer.parseInt(orderNos);
        QueryRunner qr = new QueryRunner(co);
        String Sql ="update `order` set status = 1 where orderNo= ?";
        Integer li = null;
        try {
            li = qr.update(Sql, orderNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
