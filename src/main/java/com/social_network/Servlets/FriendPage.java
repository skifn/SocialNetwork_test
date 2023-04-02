package com.social_network.Servlets;

import com.social_network.Model.User;
import com.social_network.Service.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/** —ервлет, обеспечивающий вывод страницы друга авторизованного пользовател€ */
public class FriendPage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");


        String login = request.getParameter("l");
        String password = Service.GetPassword(login);

            //ќсуществл€ем вывод друга
            User user = Service.GetUser(login, password);

            PrintWriter writer = response.getWriter();
            //—оздаем нового пользовател€ и выводим его им€

            writer.write("<div style=\"text-align: center;\">\n" +
                    "\n <img src ='/profilePhoto?login="+ login +"'" + " width=400 height=300 alt=''>" +
                    "</div>");


            writer.println("<p> : "+user.getName()+"</p><br>");
            writer.println("<p> : "+ user.getAge() +"</p><br>");
            writer.println("<p> : "+user.getEducation()+"</p><br>");
            writer.println("<p> : "+user.getInterests()+"</p><br>");
            writer.println("________________________________________________\n");


            writer.println("<p> : \n "+"</p><br>");

            ArrayList<User> users = Service.GetFriends(login, password);

            if(!users.isEmpty()) {
                for (int i = 0; i < users.size(); i++) {

                    writer.println("<p> : " + users.get(i).getName() + "</p><br>\n");


                }
            }




        }
}
