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
<script language="JavaScript">
    function dodelete(userId) {
        if (confirm("您确认删除商品编号为"+userId+"的商品吗？")){
            location.href = "http://localhost:8080/OFM/page/user/deleteuser.do?userId="+userId;
        }
    }
</script>
<body bgcolor="#ffe4c4">
<div align="center">
    <jsp:include flush="true" page="/page/user/top.jsp"/>
    <form action="page/user/searchuser.do" method="post" name="searchuser">
        <tr>
            <td height="25" align="center">
                <table border="1" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" style="border-collapse: collapse" bordercolor="#E8E8E8" bgcolor="#E8E8E8">
                    <tr>
                        <td>按姓名查询</td>
                        <td><input class="input6" type="text" name="userName" size="20"></td>
                        <td><input type="submit" value="查询"></td>
                        <td>
                            <a href="page/user/showuser.do">
                                <input type="button" id="back" name="back" value="返回">
                            </a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>



    <form action="page/user/showuser.do" method="post" name="form1">
            <tr>
                <td valign="top" align="center">
                    <table id="table2" style="width:800px; border-left: 1px solid #7BD676; border-right: 1px solid #7BD676; border-top: 11px solid #7bd676; border-bottom: 1px solid #7BD676; margin: 0; padding: 0" cellSpacing="1" cellPadding="0">
                        <tbody style="margin: 0; padding: 0">
                        <tr class="rb">
                            <td class="pl" align="center" colspan="8" height="20">
                                <span style="color: #874604">用户列表</span></td>
                        </tr>
                        <tr class="ry">
                            <td class="pl" align="center">
                                <span style="color: #874604">用户编号</span>
                            </td>
                            <td class="pl" align="center">
                                <span style="color: #874604">用户姓名</span>
                            </td>
                            <td class="pl" align="center">
                                <span style="color: #874604">用户账号</span></td>
                            <td class="pl" align="center">
                                <span style="color: #874604">用户地址</span>
                            </td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="center">
                                <span style="color: #874604">用户电话电话</span>
                            </td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="center">
                                <span style="color: #874604">用户类刑</span>
                            </td>
                            <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="center">
                            </td>
                        </tr>
                        <c:choose>
                            <c:when test="${requestScope.userList eq null}">
                                <tr>
                                     <td>
                                        <span style="color: red;font-size: 30px;font-family: 宋体">
                                           空空空！！！
                                         </span>
                                     </td>
                                 </tr>
                             </c:when>
                            <c:otherwise>
                                <c:forEach items="${requestScope.userList}" var="user">
                                    <tr>
                                        <td class="pl" align="center">
                                                ${user.userId}
                                        </td>
                                        <td class="pl" align="center">
                                                ${user.userName}
                                        </td>
                                        <td class="pl" align="center">
                                                ${user.userAccount}
                                        </td>
                                        <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="center">
                                                ${user.userAddress}
                                        </td>
                                        <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="center">
                                                ${user.userTel}
                                        </td>
                                        <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="center">
                                                ${user.userType.UTypeName}
                                        </td>
                                        <td style="font-size: 13px; line-height: 24px !important; font-style: normal; font-variant: normal; font-weight: normal; font-family: 宋体; border: 0 none; margin: 0; padding: 0" align="center">
                                            <a class="alterform" href="page/user/toalteruser.do?userId=${user.userId}" >修改</a>&nbsp;
                                            <a href="javascript:dodelete(${user.userId});"><img src="img/schu.png" alt="删除" title="删除"/></a>
                                        </td>
                                    </tr>

                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </td>

            </tr>
    </form>
    </form>
</div>
</body>
</html>
