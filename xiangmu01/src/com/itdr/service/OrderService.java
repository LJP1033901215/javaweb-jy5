package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.pojo.Order;
import com.itdr.pojo.Poiduct;

import java.util.List;

//业务层
public class OrderService {

    OrderDao od = new OrderDao();
//------------------------------------查询所有订单的方法------------------------------------------
    public ResponseCode OrderAll(String pageNum, String pageSize) {
        ResponseCode  rs = new ResponseCode();
        if (pageNum==null||pageNum.equals("")) {
            pageNum = "1";
        }
        if (pageSize==null||pageSize.equals("")){
            pageSize="10";
        }
        List<Order> li = od.OrderAll(pageNum,pageSize);//创建一个List集合存放数据
        if (li==null){
            rs =  ResponseCode.defeatdRS(209,"失败了");
            return rs;
        }
         rs =  ResponseCode.successRS(0,li);
        return rs;
    }
//------------------------------------根据订单号查询名字-------------------------------------------
    public ResponseCode OrderOne(String orderNo) {
        ResponseCode  rs = new ResponseCode();
        if (orderNo==null||orderNo.equals("")){
            rs =  ResponseCode.defeatdRS(1,"输入的查询信息有误");
            return rs;
        }
        Order li =  od.OrderOne(orderNo);
        if (li==null){
            rs =  ResponseCode.defeatdRS(3,"没有找到订单");
            return rs;
        }
            rs= ResponseCode.successRS(0,li.getOrderItemVoList());
        return rs;
    }
//--------------------------------------------根据订单号查询详情------------------------------------------------------
    public ResponseCode Orderparticulars(String orderNo) {
        ResponseCode  rs = new ResponseCode();
        if (orderNo==null||orderNo.equals("")){
            rs = ResponseCode.defeatdRS(1,"输入的查询信息有误");
            return rs;
        }
        Order li =  od.OrderOne(orderNo);
        if (li==null){
            rs = ResponseCode.defeatdRS(3,"没有找到订单");
            return rs;
        }
        rs = ResponseCode.successRS(0,li);
        return rs;
    }
//----------------------------------------------修改发货状态----------------------------------------------------------
    public ResponseCode Ordersend_goods(String orderNo) {
        ResponseCode rs = new ResponseCode();
        if (orderNo==null||orderNo.equals("")){//判断传入的信息是否为空值
            rs = ResponseCode.defeatdRS(Const.USER_PARAMETER_CODE,Const.USER_PARAMETER_MSG);
            return rs;
        }
//-------------------------------------------判断订单是否存在--------------------------------------------
        Order order = od.OrderOne(orderNo);
        if (order==null){//判断订单是不是存在
            rs = ResponseCode.defeatdRS(101,"修改的产品不存在");
            return rs;
        }
        //判断订单的状态是不是已经是发货的状态
        if (order.getStatus()==1){
            rs = ResponseCode.defeatdRS(1,"该订单已经发货");
            return rs;
        }
//----------------------------------------调用数据层进行修改数据----------------------------------------
        Integer integer = od.Ordersend_goods(orderNo);
        if (integer<=0){
            rs = ResponseCode.defeatdRS(1,"发货失败");
            return rs;
        }
        rs = ResponseCode.successRS(0,"发货成功");
        return rs;
    }
}
