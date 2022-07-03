<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.foods.service.TypeService" %>
<%@ page import="com.foods.entity.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foods.service.FoodsService" %>
<%@ page import="com.foods.entity.Foods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basepath %>"/>
    <title>查找菜品</title>

    <link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<body bgcolor="#ffe4c4">
<%--<style>--%>
<%--    body{--%>
<%--        background-size:cover;--%>
<%--        background-image: url("/img/backpng.png");--%>
<%--        background-origin: content-box;--%>
<%--    }--%>
<%--</style>--%>
<jsp:include flush="true" page="top.jsp"/>
<form name="form1" method="post" action="page/menus/searchfoods.do">
    <div align="center">
        <table width="770" border="0" cellspacing="0" cellpadding="10" bordercolor="#EDECEC" style="border-style: solid; border-width: 1px">
            <tr>
                <td align="center">
                    <table border="1" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" bordercolor="#C0C0C0" width="284">
                        <tr>
                            <td colspan="3" align="center" valign="middle">
                                <font color="#FF0000">菜&nbsp; 品&nbsp; 搜&nbsp; 索</font></td>
                        </tr>
                        <tr>
                            <td align="right">按菜号：</td>
                            <td>
                                <input type="text" placeholder="请输入菜号" name="foodsId" id="foodsId">
                            </td>
                        </tr>
                        <tr>
                            <td align="right">按菜品名称：</td>
                            <td>
                                <input type="text" placeholder="请输入菜品名称" name="foodsName" id="foodsName">
                            </td>
                        </tr>
                        <tr>
                            <td align="right">按菜品价格：</td>
                            <td>
                                <input size="6" type="text" placeholder="请输入菜品价格" name="minfoodsPrice" id="minfoodsPrice">
                                -
                                <input size="6" type="text" placeholder="请输入菜品价格" name="maxfoodsPrice" id="maxfoodsPrice">
                            </td>
                        </tr>
                        <tr>
                            <td align="right">按菜品类别：</td>
                            <td>
                                <select name="typeId">
                                    <option value="">--请选择菜品类型--</option>
                                    <c:forEach items="${applicationScope.typeList}" var="type">
                                        <option value="${type.typeId}">
                                                ${type.typeName}
                                        </option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                        <tr>
                            <td colspan="3" align="center" valign="middle">
                                <input type="submit" value="搜索">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table><br>
        <table width="750" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFCC00">
            <tr>
                <td align="center">菜码</td>
                <td align="center">菜名</td>
                <td align="center">单价</td>
                <td align="center">菜品信息</td>
                <td align="center">菜品类别</td>

            </tr>
            <c:choose>
                <c:when test="${requestScope.foodsList eq null}">
                    <tr>
                        <td align="center">
                            <span style="color: red;font-family: 宋体;font-size: 30px;">
                                空空空！！！
                            </span>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${requestScope.foodsList}" var="foods">
                        <tr bgcolor="#FFFFFF">
                            <td align="center">
                                <span>
                                        ${foods.foodsId}
                                </span>

                            </td>
                            <td align="center">
                                <span>
                                        ${foods.foodsName}
                                </span>

                            </td>
                            <td align="center">
                                <span>
                                    ${foods.foodsPrice}元
                                </span>

                            </td>
                            <td align="center">
                                <span>
                                        ${foods.foodsInfo}
                                </span>

                            </td>
                            <td align="center">
                                <span>
                                        ${foods.foodsType.typeName}
                                </span>

                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>



        </table>
    </div>
</form>
<jsp:include flush="true" page="tail.jsp"/>
</body>
</html>
