<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//post 提交 的乱码处理,写在接收之前
request.setCharacterEncoding("UTF-8");

//请求：request
    // 接收参数  
    String nums = request.getParameter("nums");

    int num = Integer.parseInt(nums);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tables.jsp' starting page</title>
    
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
    <table border="1" width="80%">
       <%
         for(int i=0;i<num;i++){
       %>
       <tr>
          <td>&nbsp;</td>
       </tr>
       <%
         }
       %>
    </table>
  </body>
</html>
