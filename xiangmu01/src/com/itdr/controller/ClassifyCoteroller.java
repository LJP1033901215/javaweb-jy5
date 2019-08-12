package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.ClassifyService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;
import com.itdr.utils.PoolUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassifyFilter",value = "/manage/category/*")
//分类的控制层
public class ClassifyCoteroller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    //控制层
    ClassifyService cs = new ClassifyService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode rs = new ResponseCode();
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        switch(path){
            case "get_category":
                rs = categoryAll(request);
                break;
            case "add_category":
                rs = categoryaddOne(request);
                break;
            case "set_category_name":
                rs = categorysetOne(request);
                break;
        }
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));
    }


    //-----------------------------------------创建根据ID查询所有子节点的的方法-------------------------------------
    private ResponseCode categoryAll(HttpServletRequest request) {
        String categoryId = request.getParameter("categoryId");
        ResponseCode rs = cs.categoryAll(categoryId);
        return rs;
    }
    //----------------------------------------------增加节点------------------------------------------------------
    private ResponseCode categoryaddOne(HttpServletRequest request) {
        String parentId = request.getParameter("parentId");
        String categoryName = request.getParameter("categoryName");
        ResponseCode rs = cs.categroyaddOne(parentId,categoryName);
        return rs;
    }
    //-----------------------------------------------修改品类的名字-------------------------------------------
    private ResponseCode categorysetOne(HttpServletRequest request) {
        String categoryId = request.getParameter("categoryId");
        String categoryName = request.getParameter("categoryName");
        ResponseCode rs = cs.categroysetOne(categoryId,categoryName);
        return rs;
    }



}
