<%@ page import="com.foods.service.TypeService" %>
<%@ page import="com.foods.entity.Type" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basepath %>"/>
    <title>新增菜品</title>

    <link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<script language="JavaScript">
    function check11()
    {

        if (document.addform.foodsName.value == "" )
        {
            alert("菜品名称不可以为空!");
            document.addform.foodsName.focus();
            return false;
        }
        if (document.addform.foodsInfo.value == ""  )
        {
            alert("菜品信息不可以为空!");
            document.addform.foodsInfo.focus();
            return false;
        }
        if (document.addform.foodsPrice.value == ""  )
        {
            alert("菜品单价不可以为空!");
            document.addform.foodsPrice.focus();
            return false;
        }
        if (document.addform.foodsName.value == ""  )
        {
            alert("说明不可以为空!");
            document.form1.brief.focus();
            return false;
        }

        if (document.addform.typeId.value == ""  )
        {
            alert("商品类型不能为空");
            document.addform.typeId.focus();
            return false;
        }
    }
</script>
<body>
    <jsp:include flush="true" page="top.jsp"/>
    <div align="center" class="providerAdd">
<%--        没有上传图片，既不用enctyp属性--%>
        <form method="post" action="page/menus/addfoods.do" name="addform" id="addform" onsubmit="check11()">
<%--            <input type="hidden" name="foodsId" value="${requestScope.foods.foodsId}">--%>
<%--            <input type="hidden" name="oldfoodsName" value="${requestScope.foods.foodsName}">--%>
            <table border="1" width="50%" bordercolorlight="#C0C0C0">
<%--                <tr>--%>
<%--                    <td class="title">--%>
<%--                        <span>图片：</span>--%>
<%--                    </td>--%>
<%--                    <td class="content">--%>
<%--                        <input type="file" name="filename"/>--%>
<%--                        <br>--%>
<%--                        <span>仅支持.jpg或.png格式</span>--%>
<%--                    </td>--%>
<%--                </tr>--%>
            <tr>
                <td height="25" bgcolor="#66CCFF" align="center" colspan="2">
                    <h2>添加菜品</h2>
                </td>
            </tr>


            <tr>
                <td height="25" bgcolor="#66CCFF" align="right" width="31%">
                    <label for="foodsName">菜品名称</label>
                </td>
                <td height="25" bgcolor="#FFE3BB" width="66%" align="center">
                    <input type="text" placeholder="请输入菜品名称" name="foodsName" id="foodsName">
                </td>
            </tr>
            <tr>
                <td height="25" bgcolor="#66CCFF" align="right" width="31%">
                    <label for="foodsInfo">菜品描述</label>
                </td>
                <td height="25" bgcolor="#FFE3BB" width="66%" align="center">
                    <input class="w3-input" type="text"
                           placeholder="请输入菜品相应的描述,限45字符内（可选填）"
                           name="foodsInfo" id="foodsInfo">
                </td>
            </tr>
            <tr>
                <td height="25" bgcolor="#66CCFF" align="right" width="31%">
                    <label for="foodsPrice">菜品单价</label>
                </td>
                <td height="25" bgcolor="#FFE3BB" width="66%" align="center">
                    <input class="w3-input" type="text"
                           placeholder="请输入菜品单价"
                           name="foodsPrice" id="foodsPrice">
                </td>
            </tr>
            <tr>
                <td height="25" bgcolor="#66CCFF" align="right" width="31%">
                        菜品类型
                </td>
                <td height="25" bgcolor="#FFE3BB" width="66%" align="center">
                    <label>
                        <select class="w3-select w3-border w3-padding-4" name="typeId">
                            <option value="" disabled selected>--请选择菜品类型--</option>
                            <c:forEach items="${requestScope.typeList}" var="type">
                                <option value="${type.typeId}">
                                    ${type.typeName}
                                </option>
                            </c:forEach>
                        </select>
                    </label>
                </td>

            </tr>
    <tr>
        <td height="25" bgcolor="#66CCFF" align="center" colspan="2">
            <input type="submit" name="add" id="add" value="保存">
            <input type="button" id="back" name="back" value="返回" onclick="javascript:history.back()">
        </td>
    </tr>
            </table>
    <c:choose>
        <c:when test="${requestScope.err ne null}">
            <p>
                <span style="color: red;font-size: 20px;font-family: 宋体;">
                        ${requestScope.err}
                </span>

            </p>
        </c:when>
    </c:choose>

        </form>

    </div>


</body>
</html>
