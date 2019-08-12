<%--
  Created by IntelliJ IDEA.
  User: 刘江鹏
  Date: 2019/8/6
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/one.css">
<link rel="stylesheet" href="css/Gonggong.css">
<title>睿乐GO后台管理系统</title>
<html>
<body>
<div id="A">
    <div id="A1">Backstage</div>
    <a href="one.jsp"  class="A2">
        <div class="A21"></div>
        <div class="A22"><img src="imgs/主页.png" alt="" style="height: 28%"></div>
        <div class="A23">主页</div>
        <div class="A24"><!--<img src="../imgs/下三角.png" alt="" class="img3">-->
        </div>
    </a>
    <div class="C" style="width: 0%;height: 0%">
        <div class="CAB">
        </div>
    </div>
    <div class="A2">
        <div class="A21"></div>
        <div class="A22"><img src="imgs/用户管理.png" alt=""></div>
        <div class="A23">用户</div>
        <div class="A24"><img src="imgs/下三角.png" alt="" class="img3">
            <img src="imgs/上三角.png" alt="" class="img4" style="display:none"></div>
    </div>
    <div class="C">

        <div class="CAB">
            <a href="html/userList.html" target="TZ" class="CABA">用户列表</a>
            <div class="CABA">用户搜索</div>
            <div class="CABA">用户详情</div>
        </div>

    </div>
    <div  class="A2">
        <div class="A21"></div>
        <div class="A22"><img src="imgs/商品管理.png" alt=""></div>
        <div class="A23">商品</div>
        <div class="A24"><img src="imgs/下三角.png" alt="" class="img3">
            <img src="imgs/上三角.png" alt="" class="img4" style="display:none"></div>
    </div>
    <div class="C">
        <div class="CAB">
            <a href="html/ProductList.html" class="CABA" target="TZ">商品管理</a>
            <a href="html/Porductss.html" target="TZ" class="CABA">商品搜索</a>
            <div class="CABA">广告位</div>
        </div>
    </div>
    <div class="A2">
        <div class="A21"></div>
        <div class="A22"><img src="imgs/信息管理.png" alt="" style="height: 28%"></div>
        <div class="A23">订单</div>
        <div class="A24"><img src="imgs/下三角.png" alt="" class="img3">
            <img src="imgs/上三角.png" alt="" class="img4" style="display:none">
        </div>
    </div>
    <div class="C">

        <div class="CAB">
            <a href="html/Order.html" target="TZ" class="CABA">订单列表</a>
            <%--<div class="CABA">订单查询</div>--%>
            <%--<div class="CABA">订单修改</div>--%>
        </div>

    </div>
    <div class="A2">
        <div class="A21"></div>
        <div class="A22"><img src="imgs/设置.png" alt=""></div>
        <div class="A23">设置</div>
        <div class="A24"><img src="imgs/下三角.png" alt="" class="img3">
            <img src="imgs/上三角.png" alt="" class="img4" style="display:none">
        </div>
    </div>
    <div class="C">

        <div class="CAB">
            <div class="CABA">设置管理员权限</div>
            <div class="CABA">设置</div>
            <%--<div class="CABA">广告位</div>--%>
        </div>

    </div>
</div>
<div id="A3">版权所有归xxx解释</div>
<div id="B">
    <div id="B1">
        <div id="B1A">
            <div class="BBB"></div>
            <div class="BBB"></div>
            <div class="BBB"></div>
        </div>
        <div id="B1B">
            <div class="BBB"></div>
            <div class="BBB"></div>
            <div class="BBB"></div>
        </div>
        <div id="B1C">
            <div class="BBB"></div>
            <div class="BBB">
                <%--<img src="imgs/123.jpg" alt="" style="width: 100%">--%>
            </div>
            <div class="BBB">
                <div id="BBBA">${user.uname}</div>
                <div id="BBBB">
                    <img src="imgs/下三角(1).png" alt="" id="img1">
                    <img src="imgs/上三角(1).png" alt="" style="display:none" id="img2">
                </div>
                <div id="BBBC"><div id="BBBCA">
                    <a href="#" class="BBBCAA">基本信息</a>
                    <a href="#" class="BBBCAA">修改信息</a>
                    <a href="denglu.html" class="BBBCAA" style="height: 40%;border-top:1px #999999 solid">退出</a>
                </div>
                </div>
            </div>
        </div>
    </div>
    <div id="B2"> <iframe src="" frameborder="0" name="TZ" ></iframe></div>
</div>

</body>
<script src="js/jquery-3.3.1.js"></script>
<script>

    $(".A2").click(
        function(){
            $(this).next().slideToggle()
            // $(".img3").slideToggle(0)
            // $(".img4").slideToggle(0)
        }
    )
    $("#BBBA,#BBBB").click(
        function () {
            $("#BBBC").slideToggle()
            $("#img1").slideToggle(0)
            $("#img2").slideToggle(0)
        })


</script>
</html>
