package com.itdr.utils;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ProductFilter",value = "/manage/product/*")
public class ProductFilter implements Filter {
    public void destroy() {
    }
    ResponseCode rs = new ResponseCode();//创建返回时参数
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//--------------------------------------------解决乱码问题--------------------------------------------------
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
//----------------------------------------获取当前页面的登陆状态-----------------------------------------------
        //1.向下转型
        HttpServletRequest request = (HttpServletRequest) req;
        //2.创建一个Session的对象
        HttpSession session = request.getSession();
        //3.获取当前的登陆状态
        Users user = (Users) session.getAttribute("user");
//------------------------------------判断用户有没有登陆和有没有权限操作-------------------------------------------
        if (user==null){
            rs.setStatus(Const.USER_NONENTITY_CODE);
            rs.setMag(Const.USER_NOT_LOG_IN_MSG);
            resp.getWriter().write(rs.toString());
            return;
        }
        if (user.getUyhlx()!=1){
            rs.setStatus(Const.USER_NOT_JURISDICTION_CODE);
            rs.setMag(Const.USER_NOT_JURISDICTION_MSG);
            resp.getWriter().write(rs.toString());
            return;
        }
//----------------------------------------------若没问题就放行------------------------------------------------
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
