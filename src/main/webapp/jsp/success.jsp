<%--
  Created by IntelliJ IDEA.
  User: limkean
  Date: 2020/3/26
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
</head>
<body>
${xiaoxi} <br>
<a href="viewAllUser">查看所有</a>
</body>
</html>
