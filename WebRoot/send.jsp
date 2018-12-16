<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'send.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>发信息</h1>
    <h2><a href="info.jsp?usid=12&uname=小明&sex=男">超链接发送信息(?&)</a></h2>
    <form action="info.jsp" method="post">
        <h3>用户编码：<input type="text" name="usid"/></h3>
        <h3>用户姓名：<input type="text" name="uname"/></h3>
        <h3>用户性别：
            <input type="radio" name="sex" checked="checked" value="男"/>男
            <input type="radio" name="sex" value="女"/>女
        </h3>
        <p><input type="submit" value="提交"/></p>
    </form>
  </body>
</html>
