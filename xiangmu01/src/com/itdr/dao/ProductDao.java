package com.itdr.dao;

import com.itdr.pojo.Poiduct;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
//-------------------------------------------数据层---------------------------------------------------------
public class ProductDao {
//---------------------------------------创建查询所有商品信息的方法------------------------------------------
    public List<Poiduct> selectAll(String pageNums, String pageSizes) {
        ComboPooledDataSource co = PoolUtil.getCom();//创建连接池
        QueryRunner qr = new QueryRunner(co);//创建DBUilts
//        Integer pageNum= Integer.parseInt(pageNums);//转型
//        Integer pageSize = Integer.parseInt(pageSizes);//转型
        String Sql = "select * from prooduct";//创建SQL语句
        List<Poiduct> li = null;//创建List数组
        try {
            li = qr.query(Sql,new BeanListHandler<Poiduct>(Poiduct.class));//所有商品的方法
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
//-------------------------------------------根据ID查询产品-------------------------------------------------
    public Poiduct selectOneId(String productID) {
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        Integer productId = Integer.parseInt(productID);
        String Sql = "select * from prooduct where Pid = ?";
        Poiduct li = null;
        try {
            li = qr.query(Sql, new BeanHandler<Poiduct>(Poiduct.class), productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
//----------------------------------------根据产品名称查询产品-------------------------------------------------
    public List<Poiduct> selectOneName(String productName) {
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        String productNames = "%"+productName+"%";
        String Sql = "select * from prooduct where Pname like ?";
        List<Poiduct> li = null;
        try {
            li = qr.query(Sql,new BeanListHandler<Poiduct>(Poiduct.class),productNames);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
