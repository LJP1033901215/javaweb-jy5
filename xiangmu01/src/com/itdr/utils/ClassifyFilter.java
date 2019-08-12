package com.itdr.utils;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ClassifyFilter",value = "/manage/category/*")
public class ClassifyFilter implements Filter {
    public void destroy() {
    }
    //分类的过滤器
    ResponseCode rs = new ResponseCode();
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpServletRequest request =(HttpServletRequest)req;
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        if (user==null){
            rs.setStatus(1);
            rs.setMag("请登陆后才进行操作");
            resp.getWriter().write(rs.toString());
            return;
        }
        if (!user.getUyhlx().equals("1")){
            rs.setStatus(1);
            rs.setMag("访问的权限不够");
            resp.getWriter().write(rs.toString());
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
