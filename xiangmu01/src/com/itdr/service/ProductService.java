package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Poiduct;
import com.itdr.utils.PoolUtil;

import java.util.List;

public class ProductService {
//---------------------------------------------产品业务层-----------------------------------------------------

    ProductDao pd = new ProductDao();
//-----------------------------------------返回所有的产品数据-------------------------------------------------
 public ResponseCode<Poiduct> selectAll(String pageNum, String pageSize) {
     ResponseCode rs = new ResponseCode();
     if (pageNum==null||pageNum.equals("")){
         pageNum = "1";
     }
     if (pageSize==null||pageSize.equals("")){
         pageSize="10";
     }
    List<Poiduct> li = pd.selectAll(pageNum,pageSize);//创建一个List集合存放数据
     if (li==null){
         rs = ResponseCode.defeatdRS(209,"失败了");
         return rs;
     }
     rs = ResponseCode.successRS(0,li);
     return rs;
    }
//----------------------------------------根据ID查询产品名称----------------------------------------------------
    public ResponseCode selectOneIdName(String productId) {
        ResponseCode rs = new ResponseCode();
     if (productId==null|| productId.equals("")){
         rs = ResponseCode.defeatdRS(1,"输入的查询信息有误");
         return rs;
     }
     Poiduct li =  pd.selectOneId(productId);
     if (li==null){
         rs = ResponseCode.defeatdRS(3,"根据ID未找到任何商品");
         return rs;
     }
     rs = ResponseCode.successRS(0,li.getPname());
     return rs;
    }
//----------------------------------------根据名字查询产品------------------------------------------------------
    public ResponseCode selectOneName(String productName) {
        ResponseCode rs = new ResponseCode();
        if (productName==null ||productName.equals("")){
            rs = ResponseCode.defeatdRS(1,"输入的查询信息有误");
            return rs;
        }
        List<Poiduct> li =  pd.selectOneName(productName);
        if (li.size()==0){
            rs = ResponseCode.defeatdRS(1,"根据name无法找到商品");
            return rs;
        }
        rs = ResponseCode.successRS(0,li);
        return rs;
    }
//----------------------------------------根据ID查询商品详情-----------------------------------------------
    public ResponseCode selectOneId(String productId) {
        ResponseCode rs = new ResponseCode();
        Poiduct li = pd.selectOneId(productId);
        if (productId==null||productId.equals("")){
            rs = ResponseCode.defeatdRS(Const.USER_PARAMETER_CODE,Const.USER_PARAMETER_MSG);
            return rs;
        }
        if (li==null){
            rs = ResponseCode.defeatdRS(202,"查询商品不存在");
            return rs;
        }
        rs = ResponseCode.successRS(0,li);
        return rs;
    }
//--------------------------------------根据ID进行更改上下架状态---------------------------------------
    public ResponseCode Set_sale_status(String productId, String status) {
        ResponseCode rs = new ResponseCode();
        if (productId==null||productId.equals("")){//判断传入的信息是否为空值
            rs = ResponseCode.defeatdRS(Const.USER_PARAMETER_CODE,Const.USER_PARAMETER_MSG);
            return rs;
        }
        if (status==null||status.equals("")){//判断传入的信息是否为空值
            rs = ResponseCode.defeatdRS(Const.USER_PARAMETER_CODE,Const.USER_PARAMETER_MSG);
            return rs;
        }
        if (!status.equals("0")&&!status.equals("1")){//判断传入的信息是不是0或者1
            rs = ResponseCode.defeatdRS(1,"修改的状态码不正确，只可以0or1");
            return rs;
        }
//-------------------------------------------判断ID是否存在--------------------------------------------
        Poiduct poiduct = pd.selectOneId(productId);
        if (poiduct==null){//判断商品是不是存在
            rs = ResponseCode.defeatdRS(101,"修改的产品不存在");
            return rs;
        }
        //判断商品的状态是不是已经是下架的状态
        if (poiduct.getPstatus()==0&&poiduct.getPstatus()==Integer.parseInt(status)){
            rs = ResponseCode.defeatdRS(101,"该产品已经是下架状态");
            return rs;
        }
        //判断商品的状态是不是已经是上架的状态
        if (poiduct.getPstatus()==1&&poiduct.getPstatus()==Integer.parseInt(status)){
            rs = ResponseCode.defeatdRS(1,"该产品已经是上架状态");
            return rs;
        }
//----------------------------------------调用数据层进行修改数据----------------------------------------
        Integer integer = pd.Set_sale_status(productId, status);
        if (integer<=0){
            rs = ResponseCode.defeatdRS(1,"修改产品状态失败");
            return rs;
        }
        rs = ResponseCode.defeatdRS(0,"修改产品状态成功");
        return rs;
    }
//-----------------------------------------修改和新增商品---------------------------------------------------------
    public ResponseCode Save(String id, String categoryId, String name, String subtitle, String mainImage, String price, String stock, String status) {
        ResponseCode rs = new ResponseCode();
     //判断ID是不是存在，存在运行修改语句，不存在新增
     if (id!=null){//当ID不为空时
         if (id.equals("")){
             rs = ResponseCode.defeatdRS(1,"id不可以为空字符串");
             return rs;
         }
        Poiduct poiduct = pd.selectOneId(id);
        if (poiduct==null){
            rs = ResponseCode.defeatdRS(1,"id对应的商品信息不存在");
            return rs;
        }
    }
    if (id==null){
         if (categoryId==null||name==null||subtitle==null||mainImage==null||price==null||stock==null||status==null){
             rs = ResponseCode.defeatdRS(1,"所有参数不可为空");
             return rs;
         }
    }
    Integer li = pd.saveOne(id,categoryId,name,subtitle,mainImage, price,stock ,status);
     if (li<=0||li==null){
         rs = ResponseCode.defeatdRS(1,"更新或新增失败");
         return rs;
     }
        rs = ResponseCode.defeatdRS(0,"更新产品成功");
    return rs;
 }
}
