<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

// 接收信息 
/*
Object robj = request.getAttribute("dlist") ;
List<Dept> dlist = new ArrayList<Dept>();
if(robj !=null){
	dlist = (List<Dept>)robj;
}
*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dept.jsp' starting page</title>
    
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
    <h1>部门信息</h1>
    <table align="center" border="1" width="80%">
      <tr>
         <td>部门编码</td><td>部门名称</td><td>部门地址</td><td>操作</td>
      </tr>
      <c:forEach var="d2" items="${dlist}">
      <tr>
         <td><a href="OneAction?dno=${d2.deptno}">${d2.deptno}</a></td>
         <td>${d2.dname}</td>
         <td>${d2.loc}</td>
         <td><a href="DeleteAction?dno=${d2.deptno}">删除</a></td>
      </tr>
      </c:forEach>
    </table>
    <h2><a href="deptadd.jsp">新增部门</a></h2>
  </body>
</html>
