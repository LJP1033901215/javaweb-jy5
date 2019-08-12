<%--
  Created by IntelliJ IDEA.
  User: 刘江鹏
  Date: 2019/7/25
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>睿乐购</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/manage/user/login.do" method="get">
    <input type="text" placeholder="请输入您的账户" name="username" >
    <input type="password" placeholder="请输入您的密码" name="password" >
    <input type="submit" value="提交">
  </form>
  </body>
</html>
