<%--
  Created by IntelliJ IDEA.
  User: 刘江鹏
  Date: 2019/8/6
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.itdr.pojo.Users" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%><%--将jsp的taglib指令导入到核心标签库--%>

<html>
<head>
    <title>主页</title>
</head>
<body>
    <div>欢迎${user.uname}</div>
    <a href="/manage/user/list.do"><div>用户列表</div></a>
    <a href=""><div>商品列表</div></a>
这是主页
</body>
</html>
