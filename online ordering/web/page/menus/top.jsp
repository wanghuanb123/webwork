<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网络订餐后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="img/lucfron.css">
	

  </head>
  <script type="text/javascript">
      function getCurTime() {
          var d = new Date();
          var week;
          switch (d.getDay()) {
              case 1: week="星期一" ; break;
              case 2: week="星期二" ; break;
              case 3: week="星期三" ; break;
              case 4: week="星期四" ; break;
              case 5: week="星期五" ; break;
              case 6: week="星期六" ; break;
              default: week="星期日"; break;
          }
          var year = d.getFullYear();
          var month =add_zero( d.getMonth()+1);
          var day = add_zero(d.getDate());
          var hour = add_zero(d.getHours());
          var minute =add_zero(d.getMinutes());
          var second = add_zero(d.getSeconds());
          var ndate = year +" 年 "+month + " 月 "+day +" 日 "+hour
              +":"+minute+":"+second+" "+week;
          document.getElementById("curTime").innerHTML = ndate;
          function add_zero(temp) {
              if(temp<10){
                  return '0'+temp;
              }
              return temp;
          }
          setInterval("getCurTime()", 1000);
      }
      window.onload =function(){
          getCurTime();
      }
  </script>


  <body topmargin="0" leftmargin="0" rightmargin="0" onload="getCurTime()">
	<div align="center">
	<table style="border-style: dotted; border-width: 1px">
	<tr><td background="img/tpbg.jpg" width="795" height="100">



        <section class="publicHeader">
            <header>
                <h1 align="center">订餐管理系统</h1>
                <div class="publicHeaderR">
                    <h2>
                        <p align="center" style="color: #000000">
                            <span>下午好！</span>
                            <span style="color: #fff21b">${sessionScope.admin.adminName}</span> , 欢迎你！
                        </p>
                    </h2>
                </div>
            </header>
        </section>

        <section class="publicTime">
            <span id="curTime"></span>
        </section>

        <section class="publicMain">
        <tr>
            <td align="center" valign="top">
                <table width="100%">
                    <tr><td align="center" bgcolor="#C0C0C0">
                        <table>
                            <tr>
                                <td><a href="page/menus/showfoods.do">菜品管理|</a></td>
                                <td><a href="page/menus/searchfoods.do">菜品查询|</a></td>
                                <td><a href="page/user/showuser.do">用户管理|</a></td>
                                <td><a href="page/admin/exit.do">注销退出|</a></td>
                            </tr>
                        </table>
                    </td></tr>
                </table>
            </td>
        </tr>
        </section>

  </table>
  	</div>
  </body>
</html>