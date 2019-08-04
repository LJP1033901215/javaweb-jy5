package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Poiduct;
import com.itdr.utils.PoolUtil;

import java.util.List;

public class ProductService {
//---------------------------------------------产品业务层-----------------------------------------------------
    ResponseCode rs = new ResponseCode();
    ProductDao pd = new ProductDao();
//-----------------------------------------返回所有的产品数据-------------------------------------------------
 public ResponseCode<Poiduct> selectAll(String pageNum, String pageSize) {
     if (pageNum==null||pageNum.equals("")){
         pageNum = "1";
     }
     if (pageSize==null||pageSize.equals("")){
         pageSize="10";
     }
    List<Poiduct> li = pd.selectAll(pageNum,pageSize);//创建一个List集合存放数据
     if (li==null){
         rs.setStatus(209);
         rs.setMag("失败了");
         return rs;
     }
     rs.setStatus(0);
     rs.setData(li);
     return rs;
    }
//----------------------------------------根据ID查询产品名称----------------------------------------------------
    public ResponseCode selectOneIdName(String productId) {
     if (productId.equals("")){
         rs.setStatus(1);
         rs.setMag("输入的查询信息有误");
         return rs;
     }
     Poiduct li =  pd.selectOneId(productId);
     if (li==null){
         rs.setStatus(3);
         rs.setMag("根据ID未找到任何商品");
         return rs;
     }
     rs.setStatus(0);
     rs.setData(li.getPname());//只返回名字
     return rs;
    }
//----------------------------------------根据名字查询产品------------------------------------------------------
    public ResponseCode selectOneName(String productName) {
        if (productName.equals("")){
            rs.setStatus(1);
            rs.setMag("输入的查询信息有误");
            return rs;
        }
        List<Poiduct> li =  pd.selectOneName(productName);
        if (li==null){
            rs.setStatus(3);
            rs.setMag("根据name无法找到商品");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
//----------------------------------------根据ID查询商品详情-----------------------------------------------
    public ResponseCode selectOneId(String productId) {
        Poiduct li = pd.selectOneId(productId);
        if (li==null){
            rs.setStatus(202);
            rs.setMag("查询商品不存在");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
}
