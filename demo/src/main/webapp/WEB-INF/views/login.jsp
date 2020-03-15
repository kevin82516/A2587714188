<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h1>Login Page</h1>
<!--表單提交目標連結和方法post-->
<form action="/account/valid" method="post">
    <input type="text" name="name" placeholder="使用者名稱">
    <input type="password" name="password" placeholder="密碼">
    <input type="submit" value="登入">
</form>
</html>