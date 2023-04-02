<%--
  Created by IntelliJ IDEA.
  User: fivef
  Date: 06.01.2023
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
<div style="text-align: center;">
    <p>Введеный логин или пароль не соответствуют установленному паттерну</p>
    <p> </p>
    <p>Логин должен быть не менее 5 знаков</p>
    <p> </p>
    <p>Пароль должен быть не менее 6 знаков</p>
    <p> </p>
    <div style="text-align: center;">
        <button onclick="location.href='/register'">Возврат к регистрации</button>
    </div>
</div>
</body>
</html>
