package com.social_network.Servlets;

import com.social_network.Model.User;
import com.social_network.Service.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/** Сервлет, обеспечивающий вывод фотографии пользователя */
public class DisplayPhoto extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("image/jpeg");



        //Через http-сессию получаем логин и пароль


        String login, password;

        login = request.getParameter("login");
        password = Service.GetPassword(login);





                //получаем данные пользака
                User user = Service.GetUser(login, password);

                //Создаем файл и отрисовываем изображение
                File file = new File(user.getFilePath());
                response.setContentLength((int) file.length());
                FileInputStream in = new FileInputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
                byte[] buf = new byte[1024];
                int count = 0;
                while ((count = in.read(buf)) >= 0) {
                    bos.write(buf, 0, count);
                }
                bos.close();



    }


}
