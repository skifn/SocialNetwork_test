<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: fivef
  Date: 07.01.2023
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ошибка</title>
</head>
<body>
<div style="text-align: center;">


  <%
    String login = request.getParameter("login");
    PrintWriter writer = response.getWriter();

    writer.println("Пользователь с логином: " + login + " уже зарегистрирован" + "\n");


  %>

  <div>
    <button onclick="location.href='/input'">Войти</button>
  </div>
</div>
</body>
</html>
