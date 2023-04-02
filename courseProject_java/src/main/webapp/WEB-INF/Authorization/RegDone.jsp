<%@ page import="com.social_network.Service.Service" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.social_network.Model.User" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: fivef
  Date: 04.01.2023
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>

<div style="text-align: center;">

<p1> Поздравляем вас c успешной регистрацией! </p1>

    <div style="text-align: center;">
    <%

        String login = request.getParameter("login");


            PrintWriter writer = response.getWriter();
            writer.println("Приветствуем вас: " + login + "\n");

    %>
    </div>
    <p1>  </p1>

<div>
    <button onclick="location.href='/welcomePage'">Назад на главную</button>
</div>
</div>
</body>
</html>
