package com.itdr.controller;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersCotroller",value = "/manage/user/*")
public class UsersCotroller extends HttpServlet {
    private UserService us = new UserService();//调用业务层—处理业务逻辑；
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
//    /list.do
    //控制层
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取地址中的最后一段地址名称
        String pathInfo = request.getPathInfo();//返回地址中最后的一段地址名称
        String path = PathUtil.getPath(pathInfo);//返回字符串

        ResponseCode rs = new ResponseCode();
        //判断是什么样的请求
        switch(path){
            case "list":
                //如果是获得用户列表的请求，我就调用下面的方法
                rs = listDO(request);

                break;
            case"login":
                rs = loginDo(request);
//                loginDo(request,response);
                break;
            case"disableuser":
                rs = disableuserDo(request);
                break;
            case"nodisableuser":
                rs = nodisableuserDo(request);
                break;
//            case"Sessionone":
//                rs = Sessionone(request);
//                break;
        }
        //返回响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));
//       response.getWriter().write(rs.toString());//返回

    }
    //获取所有用户列表的请求
    private ResponseCode listDO(HttpServletRequest request ){
        ResponseCode rs = new ResponseCode();//创建了ResponseCode的对象

//        HttpSession session = request.getSession();//获取session的状态
//        Users user = (Users) session.getAttribute("user");//获取session中的信息，若已登录，则会有信息，无则会返回空

        //获取参数
        String pageSize = request.getParameter("pageSize");//通过请求向前端页面获取信息
        String pageNum = request.getParameter("pageNum");//通过请求向前端页面获取名字

        rs = us.selectAll(pageSize, pageNum);//获取所有的用户放入到封装的方法类中统一返回
        request.setAttribute("uli",rs);//将数据存放在请求的域对象内部

        //调用业务层处理业务
        return rs;
    }
    //用户登陆的方法
    private ResponseCode loginDo(HttpServletRequest request){
        //获取参数
        String username = request.getParameter("username");//通过请求向前端页面获取信息
        String password = request.getParameter("password");//通过请求向前端页面获取名字
        ResponseCode rs = us.selectOne(username, password);//获取所有的用户
        //获取session对象
        HttpSession session = request.getSession();//获取Session的状态
        session.setAttribute("user",rs.getData());//将session登陆后的信息放入到页面中

        //调用业务层处理业务
       return rs;
    }
    //禁用用户的方法
    private ResponseCode disableuserDo(HttpServletRequest request) {
        String uid = request.getParameter("uid");
        ResponseCode rs = us.selectOne(uid);
        HttpSession session = request.getSession();//获取Session的状态
        Users users =(Users) session.getAttribute("user");//获取当前的登陆信息，如果是登陆状态则不会返回空，若未登陆就会返回空
        if (users==null){//判断Session的返回对象是不是空，若果是空则证明没有登陆
            rs =  ResponseCode.defeatdRS(3,"当前未登录");
            return rs;
        }
        if (!users.getUyhlx().equals("1")){//判断Session的返回数据中用户权限是不是够，若不够则返回错误
            rs =  ResponseCode.defeatdRS(3,"访问权限不够");
            return rs;
        }//如果没有问题则返回禁用对象的信息。
        System.out.println(uid);
        rs.setStatus(0);
        return rs;

    }
    //启用的方法
    private ResponseCode nodisableuserDo(HttpServletRequest request) {
        String uid = request.getParameter("uid");
        ResponseCode rs = us.noselectOne(uid);
        //如果没有问题则返回禁用对象的信息。
        rs.setStatus(0);
        return rs;
    }

//
// 获得Session的方法
//    private ResponseCode Sessionone(HttpServletRequest request) {
//        ResponseCode rs = new ResponseCode();
//        HttpSession session = request.getSession();
//        Users user = (Users) session.getAttribute("user");
//        rs.setData(user);
//        return rs;
//    }
}
