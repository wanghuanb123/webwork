<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basepath %>"/>
    <title>Title</title>

</head>
<body>
<div align="center">
    <jsp:include flush="true" page="/page/user/top.jsp"/>
    <form action="page/user/alteruser.do" method="post" name="form1">
        <table border="0" align="center" background="img/MainBg.gif" height="494" width="100%">
            <tr>
                <td valign="top" bgcolor="#E8E8E8" align="center">
                    <table id="table2" style="width:800px; border-left: 1px solid #7BD676; border-right: 1px solid #7BD676; border-top: 11px solid #7bd676; border-bottom: 1px solid #7BD676; margin: 0; padding: 0" cellSpacing="1" cellPadding="0">
                        <tbody style="margin: 0; padding: 0">
                        <tr class="rb">
                            <td class="pl" align="center" colspan="2" height="25">
                                <span style="color: #874604">修改用户信息</span></td>
                        </tr>
                        <tr class="ry">
                            <td class="pl" align="right" width="47%">
                                <span style="color: #874604">用户姓名：</span></td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="left" width="53%">
                                <input class="input6" type="text" name="userName" size="20" value=""></td>
                        </tr>
                        <tr class="rb">
                            <td class="pl" align="right" width="47%">
                                <span style="color: #874604">用户账号：</span></td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="left" width="53%">
                                <input class="input6" value="" type="text" name="userAccount" size="20" >
                            </td>
                        </tr>
                        <tr class="ry">
                            <td class="pl" align="right" width="47%">
                                <span style="color: #874604">用户密码：</span></td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="left" width="53%">
                                <input class="input6" value="" type="text" name="userPassword" size="20" ></td>
                        </tr>
                        <tr class="ry">
                            <td class="pl" align="right" width="47%">
                                <span style="color: #874604">用户地址：</span></td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="left" width="53%">
                                <input class="input6" type="text" name="userAddress" size="20" value=""></td>
                        </tr>
                        <tr class="ry">
                            <td class="pl" align="right" width="47%">
                                <span style="color: #874604">用户电话：</span></td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="left" width="53%">
                                <input class="input6" type="text" name="userTel" size="20" value=""></td>
                        </tr>
                        <tr class="ry">
                            <td class="pl" align="right" width="47%">
                                <span style="color: #874604">用户类型：</span></td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="left" width="53%">
                                <label>
                                    <select class="w3-select w3-border w3-padding-4" name="uTypeId">
                                        <option value="" disabled selected>--请选择用户类型--</option>
                                        <c:forEach items="${requestScope.uTypeList}" var="utype">
                                            <option value="${utype.UTypeId}">
                                                    ${utype.UTypeName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </label></td>
                        </tr>
                        <tr><input type="submit" name="alterfoods" id="alterfoods" value="修改">
                            <input type="button" id="back" name="back" value="返回" onclick="javascript:history.back()"></tr>
                    </table>
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
