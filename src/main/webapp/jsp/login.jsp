<%--
  Created by IntelliJ IDEA.
  User: limkean
  Date: 2020/3/26
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="loginServlet" id="form" method="get">
    <text>请输入用户名:</text>
    <input id="username" name="username">
    <br/>
    <text>请输入  密码:</text>
    <input type="password" id="password" name="pwd">
    <br/>
    <button id="login" name="login">登录</button>
    <button id="cancel" name="cancel">取消</button>
</form>
<form action="register.jsp">
    <input type="submit"value="新用户注册">
</form>
</body>
</html>
