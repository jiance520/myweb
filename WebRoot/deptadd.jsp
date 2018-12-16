<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//接收信息 
Object robj = request.getAttribute("dobj") ;
Dept dobj = new Dept();
if(robj !=null){
	dobj = (Dept)robj;
}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
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
    <h1>新增部门</h1>
    <form action="AddAction" method="post">
      <p>
                部门编码：<input type="text" name="deptno" required/>
      </p>
      <p>
                部门名称：<input type="text" name="dname" required/>
      </p>
      <p>
                部门地址：<input type="text" name="loc" required/>
      </p>
      <p>
         <input type="submit" value="新增"/>
      </p>
    </form>
  </body>
</html>
