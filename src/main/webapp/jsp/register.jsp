<%--
  Created by IntelliJ IDEA.
  User: limkean
  Date: 2020/3/26
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
<form action="register" method="post" style="background-color: aquamarine;align-content: center">
    <label>用户名</label>
    <input name="name"><br>
    <label>密码</label>
    <input type="password" name="pwd"><br>
    <label>性别</label>
    <input type="radio" name="gender" value="男" checked>男
    <input type="radio" name="gender" value="女">女
    <label>家庭</label>
    <select name="home">
        <option value="上海">上海</option>
        <option value="北京" selected>北京</option>
        <option value="杭州">杭州</option>
    </select><br>
    填写个人信息:<br>
    <textarea name="info" row="5"cols="30"></textarea><br>
    <input type="reset"value="重置"><input type="submit"value="注册">
</form>
</body>
</html>
