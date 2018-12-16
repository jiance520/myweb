<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String name = "小明2"; // el 不能取 

request.setAttribute("name", name); // el 能取 

pageContext.setAttribute("name", "老王");


Dept d2 = new Dept(60,"软件部","cssl");

request.setAttribute("deptinfo", d2);

request.setAttribute("num1", 14);
request.setAttribute("num2", "12");

String ss = "<script>alert('okok');</script>";

request.setAttribute("js", ss);

request.setAttribute("name2", "小明");

int[] arr = {1,2,3,4,5,6,7,8,9}; 
request.setAttribute("arr", arr);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el.jsp' starting page</title>
    
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
  <h1>name : <%=request.getAttribute("name") %></h1>
  <h1>el name : ${name}</h1>
  <h1>el name request: ${requestScope.name}</h1>
  <h2>部门名称: ${deptinfo.dname}</h2>
  
  <h2>num1 + 1: ${num1 + 1}</h2>
  <h2>num2 + 1: ${num2 + 1}</h2>
  
  <hr/>
  
  <h3>num1 : <c:out value="${num1}"/></h3>
  <h3>num1 el: ${num1}</h3>
  <h3>js: <c:out value="${js}"/></h3>
  
  <c:set var="num3" value="${num1+1}" scope="request"></c:set>
  <h3>num3: ${requestScope.num3}</h3>
  <c:remove var="num3" scope="request"/>
  <h3>num3: ${requestScope.num3}</h3>
  <hr/>
  
  <c:if test="${num1 == 12}">
      <h3> num1 == 12</h3>
  </c:if>
  <c:if test="${num1 != 12}">
      <h3> num1 != 12</h3>
  </c:if>
  <c:if test="${name2 == '小明'}">
      <h3> 我是小明</h3>
  </c:if>
  
  <c:choose>
    <c:when test="${num1==12}">
      <h3> A </h3>
    </c:when>
    <c:when test="${num1==13}">
      <h3> B </h3>
    </c:when>
    <c:otherwise>
      <h3> C </h3>
    </c:otherwise>
  </c:choose>
  
  <hr/>
  <c:forEach var="n2" items="${arr}">
     <h3>${n2}</h3>
  </c:forEach>
 
  </body>
</html>
