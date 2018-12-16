<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="UTF-8"%>
<%@ page import="com.test.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

   // 小脚本 == main方法
   Demo d2 = new Demo();
   String ss = d2.say("小明");

   int num = 10 ;
   int num2 = 5 ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <h1>my page</h1>
    <h1><a href="DeptAction">部门信息</a></h1>
    <h1>  <%=ss %> </h1>
    <%
        if(num == 10){
    %>
         	  
        	<h2>num == 10</h2>	
        	
    <%
        }
    %>
    <hr/>
    <%
       for(int i=0 ;i<num2;i++){
    %>
    
       <h3>小明 <%=i+1 %></h3>
    
    <%
       }
    %>
  </body>
</html>
