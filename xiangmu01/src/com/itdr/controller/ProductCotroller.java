package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.ProductService;
import com.itdr.utils.JsonUtils;
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
        ResponseCode rs = new ResponseCode();
        switch(path){
            case "list"://查询所有的产品
                rs = ListDO(request);
                break;
            case "searcho"://查询所有的产品
                //判断是不是两个都没选或者两个都选上了
                if (request.getParameter("productName")==null&& request.getParameter("productIdName")==null||
                        request.getParameter("productIdName")!=null&&request.getParameter("productName")!=null){
                    rs = ResponseCode.defeatdRS(101,"请选择根据什么进行查询");
                    break;
                }
                //判断是不是用名字进行查询
                if (request.getParameter("productName")!=null){
                    rs= SearchName(request);
                    break;
                }
                //判断是不是用ID查询
                if (request.getParameter("productIdName")!=null){
                    rs= SearchIdName(request);
                    break;
                 }
                break;
            case "search"://查询所有的产品
                rs=SearchName(request);
                break;
            case"detail":
                rs = SearchId(request);
                break;
            case"set_sale_status":
                rs = Set_sale_status(request);
                break;
            case"save":
                rs = Save(request);
                break;
        }
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));
    }



    //-----------------------------------------------获取所有产品信息-----------------------------------------------
    public ResponseCode ListDO(HttpServletRequest request){
        ResponseCode rs = new ResponseCode();
        String pageNum = request.getParameter("pageNum");//获取页数
        String pageSize = request.getParameter("pageSize");//获取个数
        rs = ps.selectAll(pageNum,pageSize);//调用方法传入信息
        return rs;//返回
    }
//---------------------------------------------根据ID查询商品名称----------------------------------------------
    private ResponseCode SearchIdName(HttpServletRequest request) {
        String productId = request.getParameter("productIdName");
        ResponseCode rs =  ps.selectOneIdName(productId);
       return rs;
    }
//------------------------------------------------根据名字查询商品---------------------------------------------
private ResponseCode SearchName(HttpServletRequest request) {
    String productName = request.getParameter("productName");
    ResponseCode rs =  ps.selectOneName(productName);
    return rs;
}
//---------------------------------------------根据ID查询商品详情------------------------------------------
    private ResponseCode SearchId(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        ResponseCode rs = ps.selectOneId(productId);
        return rs;
    }
//-------------------------------------------根据ID修改产品的上下架-------------------------------------------
    private ResponseCode Set_sale_status(HttpServletRequest request) {
        String productId = request.getParameter("productId");//获取前台传过来的值
        String status = request.getParameter("status");//获取前台传来的值
        System.out.println(productId);
        System.out.println(status);
        ResponseCode rs = ps.Set_sale_status(productId,status);
        return rs;
    }
//---------------------------------------------修改商品或更新商品-----------------------------------------------
    private ResponseCode Save(HttpServletRequest request) {
        String id = request.getParameter("id");
        String categoryId = request.getParameter("categoryId");
        String name = request.getParameter("name");
        String subtitle = request.getParameter("subtitle");
        String mainImage = request.getParameter("mainImage");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String status = request.getParameter("status");
        ResponseCode rs = ps.Save(id,categoryId,name,subtitle,mainImage,price,stock,status);
        return rs;
    }


}
