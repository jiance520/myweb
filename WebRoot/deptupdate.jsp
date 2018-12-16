<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//接收信息 
/*
Object robj = request.getAttribute("dobj") ;
Dept dobj = new Dept();
if(robj !=null){
	dobj = (Dept)robj;
}
*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deptupdate.jsp' starting page</title>
    
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
    <h1>修改部门</h1>
    <form action="UpdateAction" method="post">
      <p>
                部门编码：<input type="text" readonly="readonly" name="deptno" value="${dobj.deptno}"/>
      </p>
      <p>
                部门名称：<input type="text" name="dname" value="${dobj.dname}"/>
      </p>
      <p>
                部门地址：<input type="text" name="loc" value="${dobj.loc}"/>
      </p>
      <p>
         <input type="submit" value="修改"/>
      </p>
    </form>
  </body>
</html>
