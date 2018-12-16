<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


Object obj1 = session.getAttribute("num1");
if(obj1==null){
	 session.setAttribute("num1", 1);
}else{
	int n1 = (Integer)obj1;
	    n1++;
    session.setAttribute("num1", n1);    
}

Object obj2 = application.getAttribute("num2");
if(obj2==null){
	application.setAttribute("num2", 1);
}else{
	int n2 = (Integer)obj2;
	    n2++;
	application.setAttribute("num2", n2);    
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sinfo.jsp' starting page</title>
    
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
     <h1>作用域测试</h1>
     <h1>pagenum : <%=pageContext.getAttribute("pagenum") %></h1>
     <h1>rnum : <%=request.getAttribute("rnum") %></h1>
     <h1>snum : <%=session.getAttribute("snum") %></h1>
     <hr/>
     <h2>num1 : <%=session.getAttribute("num1")  %></h2>
     <h2>num2 : <%=application.getAttribute("num2")  %></h2>
  </body>
</html>
