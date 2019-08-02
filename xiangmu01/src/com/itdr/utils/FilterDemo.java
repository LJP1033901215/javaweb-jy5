package com.itdr.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FilterDemo",value = "/*")
//Filter有默认路径，完全匹配路径，目录匹配
public class FilterDemo implements Filter {
    public void destroy() {
        //销毁方法,服务器关闭时会销毁
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //所有请求被拦截后，通过下面的方法进行放行
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        //初始化方法，在第一次访问的时候就会创建Filter

    }

}
