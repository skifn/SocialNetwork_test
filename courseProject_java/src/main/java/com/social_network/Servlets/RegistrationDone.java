package com.social_network.Servlets;

import com.social_network.Model.User;
import com.social_network.Service.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/** �������, �������������� �����������  */
@MultipartConfig
public class RegistrationDone extends HttpServlet {

    private static final String DIR = "C:\\upload\\";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {



        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String education = request.getParameter("education");
        String interests = request.getParameter("interests");




        //�������� ����
        Part filePart = request.getPart("profile_pic");

        //�������� ��� �����
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        //��������� ���������� �� ����������. ���� ���, �� ������� ��
        File theDir = new File(DIR);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        //�������� ���� � �����
        String filePath = DIR + fileName;
        //��������� ����
        File file = new File(DIR + fileName);
        if(!file.exists() && !file.isDirectory()) {

            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            }

        }



         if( !Service.checking_login(login)) {
             //��������� ����� �����������
             DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
             Calendar cal = Calendar.getInstance();
             String OnlineFrom = (dateFormat.format(cal.getTime()));

             //������� ������������
             User user = new User(login, password, name, age, education, OnlineFrom, interests, filePath);


             //��������� ������ �� ���-�� ��������
             String counter_p = user.getPassword();
             String counter_l = user.getLogin();


             if (counter_l.length() >= 5 && counter_p.length() >= 6) {

                 response.setContentType("text/html");
                 String file_jsp = "WEB-INF/Authorization/RegDone.jsp";
                 request.getRequestDispatcher(file_jsp).forward(request, response);
                 try {

                     Service.register(user);

                 } catch (SQLException e) {
                     throw new RuntimeException(e);
                 }


             } else {

                 String error = "/WEB-INF/Authorization/Wrong_L_P.jsp";
                 request.getRequestDispatcher(error).forward(request, response);


             }
         }

         else {

             String error = "/WEB-INF/Authorization/SameLogin.jsp";
             request.getRequestDispatcher(error).forward(request, response);

         }

   }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {



    }

}
