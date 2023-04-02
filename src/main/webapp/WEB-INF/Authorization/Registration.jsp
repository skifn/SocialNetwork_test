<%@ page import="com.social_network.Model.User" %>
<%@ page import="com.social_network.Service.Service" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: fivef
  Date: 04.01.2023
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action = "/regDone" method="post" enctype='multipart/form-data'>

    <div style="text-align: center;">

        <input name="name" placeholder="Имя">
        <div> </div>
        <input name="age" placeholder="Возраст">
        <div> </div>
        <input name="education" placeholder="Образование">
        <div> </div>
        <input name="interests" placeholder="Интересы">
        <div> </div>


        <div>____________________________ </div>
        <div>____________________________ </div>
        <label> Фото профиля: </label>
        <input
                type="file"
                id="profile_pic"
                name="profile_pic"
                accept=".jpg, .jpeg, .png" />
        <div>____________________________ </div>
        <div>____________________________ </div>

        <input name="login" placeholder="Логин">
        <div> </div>
        <input type = "password" name="password" placeholder="Пароль">
        <div> </div>
        <input name="submit" type="submit" value="Зарегистрироваться">


</div>
</form>

</body>
</html>
