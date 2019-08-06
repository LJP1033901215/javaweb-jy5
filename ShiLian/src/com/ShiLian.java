package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShiLian",value = "/shilian")
public class ShiLian extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "admin";
        String mm = "admin";
        String zh = request.getParameter("zh");
        String mm1 = request.getParameter("mm");
        if (zh.equals(name)&&mm.equals(mm1)){
            response.sendRedirect("/wenti.jsp");//重定向地址
        }else{
            response.sendRedirect("/index.jsp");
        }
    }
}
