package com.social_network.Servlets;



import com.social_network.Service.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/** Сервлет, обеспечивающий вывод профиля пользователя на странице */
public class MainPageServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            try {
                if(Service.auth(login, password )){


                    String success = "/WEB-INF/Pages/Profile.jsp";
                    request.getRequestDispatcher(success).forward(request, response);


                }
                else {
                    String error = "/WEB-INF/Authorization/access_denied.jsp";
                    request.getRequestDispatcher(error).forward(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

    }

}
