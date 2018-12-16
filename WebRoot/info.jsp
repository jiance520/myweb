<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//post 提交 的乱码处理,写在接收之前
request.setCharacterEncoding("UTF-8");

// 请求：request
      // 接收参数  
      //String usid = request.getParameter("usid");
      String uname = request.getParameter("uname");
      String sex = request.getParameter("sex");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info.jsp' starting page</title>
    
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
    <h1>显示信息</h1>
    <h2>个人信息</h2>
    <h3>用户编码：${param.usid}</h3>
    <h3>用户姓名：<%=uname %></h3>
    <h3>用户性别：<%=sex %></h3>
  </body>
</html>
