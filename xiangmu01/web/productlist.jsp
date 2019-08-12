<%--
  Created by IntelliJ IDEA.
  User: 刘江鹏
  Date: 2019/8/11
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        a{
            text-decoration:none;
            out-line: none;
        }
        body{
            width: 100%;
            height: 100%;
            /*background: black;*/
            display: flex;
            position: fixed; /*flex-direction: column;*/
            flex-direction: column;
            justify-content: center;
        }
        #DZ{
            width: 100%;
            height: 7%;
            /*background-color: #74c6ec;*/
            /*border-bottom: 3px #F2F2F2 solid;*/
            display: flex;
            align-items: center;
        }
        #X{
            width: 100%;
            height: 93%;
            background-color:white;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow-y: scroll;
            flex-direction: column;
        }
        #kong{
            width: 100%;
            height: 2%;
            background-color:#F2F2F2 ;
        }
        .kong1{
            width: 4%;
            height: 100%;
            background:#F2F2F2 ;
        }
        #X1{
            width: 100%;
            height: 25%;
            background: #74c6ec;
        }
        /*td{*/
            /*text-align: center;*/
        /*}*/
        #TR1{
            background-color: #F2F2F2;
        }
        #XA
        {
            height: 100%;
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            width:67%;
            border-collapse:collapse;
            vertical-align: middle;
            text-align: center;
        }

        #XA td, #XA th
        {
            font-size:1em;
            border:1px solid #D2D2D2;/*//边框的色*/
            padding:3px 7px 2px 7px;
            height: 30px;
        }

        #XA th
        {
            font-size:1.1em;
            /*text-align:left;*/
            padding-top:5px;
            padding-bottom:4px;
            background-color: #F0F0F0;/*头部的颜色*/
            color:#666666;
        }

        #XA td
        {
            color:#666666;
            background-color: #F8F8F8;
        }
        #XA tr:hover td{
            background-color:#F0F0F0;
            transition: all 0.75s ;
        }
    </style>
</head>
<body>
<div id="DZ">
    <span style="color:#7A7A7A">&ensp;主页 /</span><span  style="color:#7A7A7A"> &ensp;商品 /</span><span>&ensp; 商品列表 </span>
</div>
<div id="kong"></div>
<div id="X">
    <div class="kong1"></div>
    <div id="X1"></div>
    <table id="XA"  border="0">
        <tr id="TR1">
            <th>商品ID</th>
            <th>分类序号</th>
            <th>商品名称</th>
            <th>商品备注</th>
            <th>商品图片</th>
            <th>状态</th>
            <th>商品价格</th>
            <th>库存数量</th>
            <th>操作账户</th>
        </tr>

    </table>
    <div class="kong1"></div>
</div>

</body>
<script src="js/jquery-3.3.1.js"></script>
<script>
    $(function () {
        $.get(
            "/manage/product/list.do",
            function (dl) {
                if (dl.status!==0){
                    alert(dl.mag);
                } else{
                    for (var i = 0; i < dl.data.length; i++) {
                      if (dl.data[i].pstatus===1){
                          var qw ="上架";
                      } else {
                          qw ="下架";
                      }
                        var a = "<tr><td>"
                            +dl.data[i].pid+"</td><td>"//ID
                            +dl.data[i].pcategoruID+"</td><td>"//分类的ID
                            +dl.data[i].pname+"</td><td>"//产品名字
                            +dl.data[i].psubtitle+"</td><td>"//产品的副标题
                            +dl.data[i].pmainlmage+"</td><td>"//产品的图片
                            +qw+"</td><td>"//产品的上架是否
                            +dl.data[i].pprice+"</td><td>"//价格
                            +dl.data[i].pstick+"</td><td>"//库存数量
                            +"<button type='button' id='name"+i+"' value='"+dl.data[i].uid+"'>禁用</button>"+
                            "<button type='button'>启用</button>"+"</td></tr>";

                        $("#XA").append(a);

                    }
                }
            },"json"
        )
    })
    // $("#name0").click(function () {
    //     alert("sadsada")
    //   var dd = $("#name0").val()
    // $.get(
    //     "/manage/user/disableuser.do",
    //     {uid:$("#name0").val()},
    //     function (dl) {
    //         if (dl.data === 1){
    //             alert("成功了")
    //         } else{
    //             alert("失败了")
    //         }
    //     }
    // )
    // });

</script>
</html>
