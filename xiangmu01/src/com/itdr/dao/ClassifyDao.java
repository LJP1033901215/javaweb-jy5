package com.itdr.dao;

import com.itdr.pojo.Classify;
import com.itdr.pojo.Poiduct;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ClassifyDao {
    //数据层
    public List<Poiduct> categoryALL( String categoryIds) {
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        Integer categoryId = Integer.parseInt(categoryIds);
        String Sql = "select * from prooduct where PcategoruID = ?";
        List<Poiduct> li =null;
        try {
           li =  qr.query(Sql,new BeanListHandler<Poiduct>(Poiduct.class),categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
//------------------------------------------------根据名字查询数据----------------------------------
    public Classify categoryOneName(String categoryName) {
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        String Sql = "select * from classify where name = ?";
        Classify li =null;
        try {
            li =  qr.query(Sql,new BeanHandler<Classify>(Classify.class),categoryName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
//----------------------------------------根据ID查询品类的名字-----------------------------------
    public Classify categoryOneName(Integer parentId) {
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        String Sql = "select * from classify where id = ?";
        Classify li =null;
        try {
            li =  qr.query(Sql,new BeanHandler<Classify>(Classify.class),parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
//-------------------------------------------添加数据-----------------------------------------
    public Integer categoryaddOne(String categoryIds, String categoryName) {
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        Integer categoryId = Integer.parseInt(categoryIds);
        String Sql = "insert into classify (id,parentId,name)values (null,?,?)";
        Integer li =null;
        try {
            li =  qr.update(Sql,categoryId,categoryName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
//-----------------------------------------------根据ID修改名字---------------------------------------
    public Integer categorysetOne(Integer parentId, String categoryName) {
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        String Sql = "update classify set  name = ?  where id= ?";
        Integer li =null;
        try {
            li =  qr.update(Sql,categoryName,parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return li;
    }
}
