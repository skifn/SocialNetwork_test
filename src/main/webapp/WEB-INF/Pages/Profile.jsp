<%@ page import="com.social_network.Service.Service" %>
<%@ page import="java.net.InetAddress" %>
<%@ page import="com.social_network.Model.User" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: fivef
  Date: 04.01.2023
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ITNetwork</title>


        </head>





<body>





<%



    String login = request.getParameter("login");
    String password = request.getParameter("password");

    InetAddress IPAddress;

    try {
        if(Service.auth(login, password )){
            //Осуществляем вывод

            User user = Service.GetUser(login, password);

            PrintWriter writer = response.getWriter();
            //Создаем нового пользователя и выводим его имя

            writer.write("<div style=\"text-align: center;\">\n" +
                    "\n <img src ='/profilePhoto?login=" + login +"'"  + "  width=400 height=300 alt=''>" +
                    "</div>");

            writer.println("<p> Имя: "+user.getName()+"</p><br>");
            writer.println("<p> Возраст: "+ user.getAge() +"</p><br>");
            writer.println("<p> Образование: "+user.getEducation()+"</p><br>");
            writer.println("<p> Интересы: "+user.getInterests()+"</p><br>");
            writer.println("________________________________________________\n");


            writer.println("<p> Друзья: "+"</p><br>");
            ArrayList<User> users = Service.GetFriends(login, password);

            if(!users.isEmpty()) {


                for(int i = 0; i < users.size(); i++) {
                    writer.println("<p> Пользователь: " +
                            "  <a href='/friend?l=" +users.get(i).getLogin() + "'" + ">" + ""
                            + users.get(i).getName() +"</a>" + "</p><br>" +"\n");
                }


            }




            IPAddress = InetAddress.getLocalHost();

            writer.println("\n________________________________________________\n");
            writer.println("<p> Количество посещений: "+user.getVisits()+ "\n" + "</p><br>");
            writer.println("<p> Регистрация: "+user.getOnlineFrom()+"</p><br>");
            writer.println("________________________________________________\n");
            //Имя компьютерап
            writer.println("<p> Вход был осуществлен с устройства: " + IPAddress + "</p><br>");
        }
        else {
            String error = "/access_denied.jsp";
            request.getRequestDispatcher(error).forward(request, response);


        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }





%>


<p1>  </p1>
<div style="text-align: center;">
    <button onclick="location.href='/welcomePage'">Выйти из аккаунта</button>
</div>


</body>
</html>


