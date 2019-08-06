package com.itdr.dao;

import com.itdr.pojo.Poiduct;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
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
//-----------------------------------------根据id更改上下架的状态---------------------------------
    public Integer Set_sale_status(String productId, String status) {
        ComboPooledDataSource co = PoolUtil.getCom();
        Integer Status = Integer.parseInt(status);
        QueryRunner qr = new QueryRunner(co);
        String Sql ="update prooduct set Pstatus= ? where Pid= ?";
        Integer li = null;
        try {
            li = qr.update(Sql, Status, productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
//--------------------------------------------------更新或者新增一条数据-----------------------------------------------------
    public Integer saveOne(String ids, String categoryIds, String names, String subtitles, String mainImages, String prices, String stocks, String statuss){
        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(co);
        Integer li = null;

        //有个问题，这里如果单独查询一条数据时会出现问题，可以用StringBuffer解决，但中间的逗号问题有待思考
        //当id不为空的时候
        if (ids!=null){
//-----------------------------------------------将字符串转化成Integer开始-----------------------------------------------
            //将String转化为Integer类型的
            Integer id = Integer.parseInt(ids);
            Integer categoryIdA = null;
            Integer stockA = null;
            Integer statusA = null;
//-----------------------------------------------将字符串转化成Integer结束-----------------------------------------------
//-------------------------------------------------拼接SQL语句的过程开始-------------------------------------------------
            //创建List进行遍历
            List<String> na = new ArrayList<String>();

            //创建StringBuffer进行字符串的拼接
            StringBuffer n = new StringBuffer();

            //判断各个数段之间是不是存在
            if (categoryIds!=null){
                categoryIdA = Integer.parseInt(categoryIds);
                String categoryId = "PcategoruID="+categoryIdA;
                na.add(categoryId);
            }
            if (names!=null){
                String  name = "Pname="+"'"+names+"'";
                na.add(name);
            }
            if (subtitles!=null){
                String  subtitle = "Psubtitle="+"'"+subtitles+"'";
                na.add(subtitle);
            }
            if (mainImages!=null){
                String mainImage = "PmainImage="+"'"+mainImages+"'";
                na.add(mainImage);
            }
            if (prices!=null){
                String  price = "Pprice="+"'"+prices+"'";
                na.add(price);
            }
            if (stocks!=null){
                stockA = Integer.parseInt(stocks);
                String  stock = "Pstock="+stockA;
                na.add(stock);
            }
            if (statuss!=null){
                 statusA = Integer.parseInt(statuss);
                String status = "Pstatus="+statusA;
                na.add(status);
            }
            n.append("update prooduct set ");
            int a = 0;
            for (int i = 0 ;i<na.size();i++){
                if (a==0){
                    n.append(na.get(i));
                    a++;
                }else {
                    n.append(" , ").append(na.get(i));
                }
            }
            n.append(" where Pid= ?");
            String Sql =n.toString();
            System.out.println(Sql);
//-------------------------------------------------拼接SQL语句的过程结束-------------------------------------------------
//--------------------------------------------------执行SQL语句的开始----------------------------------------------------
            try {
//                li = qr.update(Sql,categoryId,name,subtitle,mainImage,price,stock,status,id);
                li = qr.update(Sql,id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
//--------------------------------------------------执行SQL语句的结束----------------------------------------------------
//---------------------------------------------------新增数据的开始------------------------------------------------------
        }else {
            Integer categoryIdA = Integer.parseInt(categoryIds);
            Integer stockA = Integer.parseInt(stocks);
            Integer statusA = Integer.parseInt(statuss);
            String Sql ="insert into prooduct values (null,?,?,?,?,?,?,?)";
            try {
                li = qr.update(Sql,categoryIdA,names,subtitles,mainImages,statusA,prices,stockA);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//---------------------------------------------------新增数据的结束------------------------------------------------------
        return li;
    }
}
