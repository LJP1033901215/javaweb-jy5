package com.itdr.utils;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterDemo",value = "/manage/user/*")
//Filter有默认路径，完全匹配路径，目录匹配
public class JurisDictionFilter implements Filter {
    ResponseCode rs = new ResponseCode();
    public void destroy() {
        //销毁方法,服务器关闭时会销毁
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //添加解决乱码的问题
        //处理乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //向下转型，使用子类更多的方法
        HttpServletRequest request = (HttpServletRequest)req;
        //获取路径
        String pathInfo = request.getPathInfo();
        if (pathInfo.equals("/login.do")){//判断获取的路径是不是登陆的路径，如果是就直接放行
            chain.doFilter(req,resp);//放行
            return;
        }
        //如果是其他的请求，则验证是不是登陆状态
        HttpSession session = request.getSession();//创建一个Session的对象
        Users user = (Users) session.getAttribute("user");
        if (user ==null){
            rs.setStatus(3);
            rs.setMag("请登录后执行此操作");
            resp.getWriter().write(rs.toString());
            return;
        }
//        无意义
        if (user.getUyhlx()!=1 ){
            rs.setStatus(3);
            rs.setMag("没有操作权限");
            resp.getWriter().write(rs.toString());
        }
        //若没有问题就放行
        //所有请求被拦截后，通过下面的方法进行放行
        chain.doFilter(req, resp);
    }
    public void init(FilterConfig config) throws ServletException {
        //初始化方法，在第一次访问的时候就会创建Filter

    }

}
