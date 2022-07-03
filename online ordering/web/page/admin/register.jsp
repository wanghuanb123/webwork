<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basepath %>"/>
    <title>管理员注册</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<script language="JavaScript">
    function check11()
    {

        if (document.form1.adminName.value == "" )
        {
            alert("账号不能为空!");
            document.form1.adminName.focus();
            return false;
        }
        if (document.form1.adminPassword.value == ""  )
        {
            alert("密码不能为空!");
            document.form1.adminPassword.focus();
            return false;
        }
        if (document.form1.adminPassword2.value == ""  )
        {
            alert("确认密码不能为空!");
            document.form1.adminPassword2.focus();
            return false;
        }
        if (document.form1.adminPassword2.value != document.form1.adminPassword.value  )
        {
            alert("两次密码不一致!");
            document.form1.adminPassword.focus();
            return false;
        }
        if (document.form1.gTypeId.value == ""  )
        {
            alert("类别不能为空!");
            document.form1.gTypeId.focus();
            return false;
        }
    }
</script>
<body>
<form action="page/admin/register.do" name="form1" method="post" onSubmit="return check11()">
    <jsp:include flush="true" page="/page/menus/top.jsp"/>
    <div align="center"><br>
        <table bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" border="1">
            <tr>
                <td colspan="3" align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <font color="#666666">管理员注册</font>
                </td>
            </tr>
            <tr>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <font color="#996633">账   号：</font>
                </td>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <input class="input7" type="text" name="adminName"/>
                </td>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    您用来登录的账号
                </td>
            </tr>
            <tr>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <font color="#996633">密&nbsp;&nbsp; &nbsp;码：</font>
                </td>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <input class="input7" type="password" name="adminPassword"/>
                </td>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    请输入您的密码
                </td>
            </tr>
            <tr>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <font color="#996633">确认密码：</font>
                </td>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <input class="input7" type="password" name="adminPassword2"/>
                </td>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    请将输入的密码再次输入
                </td>
            </tr>

            <tr>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <font color="#996633">管理员类别：</font>
                </td>
                <td align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <label>
                        <select class="w3-select w3-border w3-padding-4" name="gTypeId">
                            <c:forEach items="${requestScope.gTypeList}" var="gtype">
                                <option value="${gtype.GTypeId}">
                                        ${gtype.GTypeName}
                                </option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
                <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    选择您的类型
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                    <input type="submit" value="注册">
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
    </div>
</form>
<jsp:include flush="true" page="/page/menus/tail.jsp"/>
</body>
</html>
