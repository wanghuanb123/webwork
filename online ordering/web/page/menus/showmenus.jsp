<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.foods.service.FoodsService" %>
<%@ page import="com.foods.entity.Foods" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link href="css/common_style_blue.css" rel="stylesheet" type="text/css" />
<html>
<head>
    <base href="<%=basepath %>"/>
    <title>展示菜品</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" type="text/css" href="css/css.css">

</head>
<script language="JavaScript">
    function dodelete(foodsId) {
        if (confirm("您确认删除商品编号为"+foodsId+"的商品吗？")){
            location.href = "http://localhost:8080/OFM/page/menus/deletefoods.do?foodsId="+foodsId;
        }
    }
</script>
<body>
<%--<style>--%>
<%--    body{--%>
<%--        background-size:cover;--%>
<%--        background-image: url("/img/backpng.png");--%>
<%--        background-origin: content-box;--%>
<%--    }--%>
<%--</style>--%>
<form method="post" action="page/menus/showfoods.do">
    <div align="center">
        <jsp:include flush="true" page="top.jsp"/>

        <table border="0" width="800" id="table1" bgcolor="#CCFFCC">
            <tr>
                <td bgcolor="#08ffcc" align="center">
                    <h2 align="center">
                        菜单
                    </h2>
                </td>
                <td bgcolor="#FFE3BB" align="right" colspan="6" height="25">
                    <a href="page/menus/toaddfoods.do">
                        添加新菜品
                    </a>
                </td>
            </tr>
            <tr>
                <td align="center">菜码</td>
                <td align="center">菜品名称</td>
                <td align="center">菜品单价</td>
                <td align="center">菜品信息</td>
                <td align="center">菜品类型</td>
                <td align="center">　</td>
                <td align="center">　</td>
            </tr>
           <c:choose>
               <c:when test="${requestScope.foodsList eq null}">
                   <tr>
                       <td>
                           <span style="color: red;font-size: 10px;font-family: 宋体">
                               空空空！！！
                           </span>
                       </td>
                   </tr>
               </c:when>
               <c:otherwise>
                   <c:forEach items="${requestScope.foodsList}" var="foods">
                       <tr>
                       <td bgcolor="#FFE3BB" align="center" height="20">
                               ${foods.foodsId}
                       </td>
                       <td bgcolor="#FFE3BB" align="center" height="20">
                           ${foods.foodsName}
                       </td>
                       <td bgcolor="#FFE3BB" align="center" height="20">
                           ${foods.foodsPrice}
                       </td>
                       <td bgcolor="#FFE3BB" align="center" height="20">
                           ${foods.foodsInfo}
                       </td>
                       <td bgcolor="#FFE3BB" align="center" height="20">
                           ${foods.foodsType.typeName}
                       </td>
                       <td bgcolor="#FFE3BB" align="center" height="20">
                           <a class="alterbill" href="page/menus/toalterfoods.do?foodsId=${foods.foodsId}" >
                               <img src="img/alter.jpg" alt="修改" title="修改"/>
                           </a>
                       </td>
                       <td bgcolor="#FFE3BB" align="center" height="20">
                           <a href="javascript:dodelete(${foods.foodsId});"><img src="img/schu.png" alt="删除" title="删除"/></a>
                       </td>
                   </c:forEach>

                   </tr>
               </c:otherwise>
           </c:choose>


        </table>
    </div>



</form>
</body>
</html>
