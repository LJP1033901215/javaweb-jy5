package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.ProductService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductCotroller",value ="/manage/product/*")
public class ProductCotroller extends HttpServlet {
    ProductService ps = new ProductService();//创建业务层的对象
//-------------------------------------------产品控制层------------------------------------------------------
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//--------------------------------------------获取地址------------------------------------------------
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
//--------------------------------------获取地址后判断是什么请求------------------------------------------
        ResponseCode rs =new ResponseCode();
        switch(path){
            case "list"://查询所有的产品
                rs = ListDO(request);
                break;
            case "search"://查询所有的产品
                //判断是不是两个都没选或者两个都选上了
                if (request.getParameter("productName")==null&& request.getParameter("productId")==null||
                        request.getParameter("productId")!=null&&request.getParameter("productName")!=null){
                    rs.setStatus(101);
                    rs.setMag("请选择根据什么进行查询");
                    break;
                }
                //判断是不是用名字进行查询
                if (request.getParameter("productName")!=null){
                    rs= SearchName(request);
                    break;
                }
                //判断是不是用ID查询
                if (request.getParameter("productId")!=null){
                    rs= SearchId(request);
                    break;
                 }
                break;

        }
        response.getWriter().write(rs.toString());//响应
    }

//-----------------------------------------------获取所有产品信息-----------------------------------------------
    public ResponseCode ListDO(HttpServletRequest request){
        String pageNum = request.getParameter("pageNum");//获取页数
        String pageSize = request.getParameter("pageSize");//获取个数

        ResponseCode rs = ps.selectAll(pageNum,pageSize);//调用方法传入信息

        return rs;//返回
    }
//------------------------------------------------根据ID查询商品----------------------------------------------
    private ResponseCode SearchId(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        ResponseCode rs =  ps.selectOneId(productId);
       return rs;
    }
//------------------------------------------------根据名字查询商品---------------------------------------------
private ResponseCode SearchName(HttpServletRequest request) {
    String productName = request.getParameter("productName");
    ResponseCode rs =  ps.selectOneName(productName);
    return rs;
}

}
