package com.social_network.Servlets;

import com.social_network.Model.User;
import com.social_network.Service.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

/** Сервлет, обеспечивающий регистрацию пользователя в базу данных  */
public class RegisterServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {  response.setContentType("text/html");
        String file_jsp = "WEB-INF/Authorization/Registration.jsp";
        request.getRequestDispatcher(file_jsp).forward(request, response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String file_jsp = "WEB-INF/Authorization/Registration.jsp";
        request.getRequestDispatcher(file_jsp).forward(request, response);


    }


}
