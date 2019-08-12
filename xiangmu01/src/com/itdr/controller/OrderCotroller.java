package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderCotroller",value = "/manage/order/*")
public class OrderCotroller extends HttpServlet {
//    ResponseCode rs = new ResponseCode();
    OrderService os = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    //控制层
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        ResponseCode rs = new ResponseCode();
        switch(path){
            case "list"://查询所有的产品
                rs = OrderAll(request);
                break;
            case "search"://根据订单号查询订单
                rs = OrderOne(request);
                break;
            case "detail"://根据订单号查询订单详情
                rs = Orderparticulars(request);
                break;
            case "send_goods"://修改订单发货状态
                rs = Ordersend_goods(request);
                break;

        }
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));
    }
//----------------------------------------查询所有的订单-------------------------------------------------
    private ResponseCode OrderAll(HttpServletRequest request) {
        String pogeSize = request.getParameter("pogeSize");
        String pogeNum = request.getParameter("pogeNum");
        ResponseCode rs = os.OrderAll(pogeNum,pogeSize);
        return rs;
    }
//----------------------------------------根据单号查询订单-------------------------------------------------
    private ResponseCode OrderOne(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");
        ResponseCode rs = os.OrderOne(orderNo);
        return rs;
    }
//----------------------------------------根剧单号查询订单---------------------------------------------------
private ResponseCode Orderparticulars(HttpServletRequest request) {
    String orderNo = request.getParameter("orderNo");
    ResponseCode rs = os.Orderparticulars(orderNo);
    return rs;
}
//-----------------------------------------修改发货的状态-----------------------------------------------------
    private ResponseCode Ordersend_goods(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");//获取前台传过来的值
        ResponseCode rs = os.Ordersend_goods(orderNo);
        return rs;
    }
}
