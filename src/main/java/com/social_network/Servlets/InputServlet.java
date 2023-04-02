package com.social_network.Servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/** Сервлет, обеспечивающий вход */
public class InputServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String file_jsp = "/WEB-INF/Authorization/Input.jsp";
        request.getRequestDispatcher(file_jsp).forward(request, response);

    }


}
