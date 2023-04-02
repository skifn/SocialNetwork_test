<%--
  Created by IntelliJ IDEA.
  User: fivef
  Date: 04.01.2023
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>

<form action="/profile"  method="post">
    <div style="text-align: center;">
        <p class="login-text">Авторизация</p>
        <input class="login-input" name="login" placeholder="Логин">

        <div> </div>

        <p> </p>

        <input class="login-input" name="password" type="password" placeholder="Пароль">

        <p> </p>

        <input class="login-input-btn" name="submit" type="submit" value="Войти">

        <p> </p>

    </div>
</form>


</body>
</html>
