package com.social_network.Service;

import com.social_network.Model.User;

import java.sql.*;
import java.util.ArrayList;


//Методы для работы
public class Service {

    //Подключение к БД
    /** Подключение к базе данных */
    static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/talov/Desktop/courseProject_java/identifier.sqlite");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /** Данный метод обеспечивает авторизацию пользователя */
    public static boolean auth(String login, String password) throws SQLException {
        boolean isContains = false;
        int visits = 0;

        if (connection != null) {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery(
                    "select * " +
                            "from users " +
                            "where login='" + login +
                            "' and password='" + password + "'"
            );

            if (resultSet.next()) {
               visits = resultSet.getInt("visits_count");
                PreparedStatement pstmt = connection.prepareStatement(
                        "update users set visits_count = '" + (visits+1) +
                                "' where login='" + login +
                                "' and password='" + password + "'"
                );
                pstmt.executeUpdate();



                isContains = true;


            }
        }


        return isContains;
    }


    /** Данный методд возвращает пользователя, логин и пароль которого переданы в метод в качестве параметров */
    public static User GetUser(String login, String password) {
        User user = new User();

        try {
            if (connection != null) {
                Statement stat = connection.createStatement();
                ResultSet resultSet = stat.executeQuery(
                        "select * " +
                                "from users " +
                                "where login='" + login +
                                "' and password='" + password + "'"
                );

                if (resultSet.next()) {
                    user.setName(resultSet.getString("name"));
                    user.setAge(Integer.parseInt(resultSet.getString("age")));
                    user.setEducation(resultSet.getString("education"));
                    user.setOnlineFrom(resultSet.getString("OnlineFrom"));
                    user.setVisits(resultSet.getInt("visits_count"));
                    user.setInterests(resultSet.getString("interests"));
                    user.setFilePath(resultSet.getString("photo"));


                    System.out.println(user.getLogin());
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Ошибка связанная с БД");
        }
        return user;

    }


    /** Данный метод возвращает лист, в котором содержатся логины друзей авторизованного пользователя */
    public static ArrayList<User> GetFriends(String login, String password) {

        ArrayList<User> users = new ArrayList<>();

        try {
            if (connection != null) {
                Statement stat = connection.createStatement();
                ResultSet resultSet = stat.executeQuery(
                        "select * " +
                                "from users " +
                                "where login!='" + login + "'"
                );

                while(resultSet.next()) {

                        String log = (resultSet.getString("login"));
                        String pass = (resultSet.getString("password"));
                        String name = (resultSet.getString("name"));
                        int age = (Integer.parseInt(resultSet.getString("age")));
                        String education = (resultSet.getString("education"));
                        String OnlineFrom = (resultSet.getString("OnlineFrom"));
                        String interests = (resultSet.getString("interests"));
                        String filePath = (resultSet.getString("photo"));

                        User user = new User(log, pass, name, age,
                                education, OnlineFrom, interests, filePath);

                        users.add(user);

                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Ошибка связанная с БД");
        }
        return users;

    }


    /** Данный метод возвращает пароль для пользователя, чей логин передан в метод */
    public static String GetPassword(String login) {

        String buffer = null;
        try {
            if (connection != null) {
                Statement stat = connection.createStatement();
                ResultSet resultSet = stat.executeQuery(
                        "select password " +
                                "from users " +
                                "where login='" + login + "'"
                );


                buffer = (resultSet.getString("password"));


            }

        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Ошибка связанная с БД");
        }


        return buffer;
    }

    /** Данный метод обеспечивает регистрацию пользователя и занесение данных в базу данных */
    public static void register(User user) throws SQLException {

        //Получаем данные пользоватея, которые передаются в качестве параметра
        try {
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO users(`login`, `password`, `name`, `age`, " +
                                "`education`, `OnlineFrom`,`interests`, `photo` ) " +
                                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                {

                    statement.setObject(1, user.getLogin());
                    statement.setObject(2, user.getPassword());
                    statement.setObject(3, user.getName());
                    statement.setObject(4, user.getAge());
                    statement.setObject(5, user.getEducation());
                    statement.setObject(6, user.getOnlineFrom());
                    statement.setObject(7, user.getInterests());
                    statement.setObject(8, user.getFilePath());


                    // Выполняем запрос
                    statement.execute();
                }


            }


        } catch (Exception ex) {

            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Ошибка связанная с БД");
        }


    }


    /** Данный метод обеспечивает проверку логина и возвращает true либо false */
    public static boolean checking_login(String login) {

        boolean sameLogin = false;

        try {
            if (connection != null) {
                Statement stat = connection.createStatement();
                ResultSet resultSet = stat.executeQuery(
                        "select * " +
                                "from users " +
                                "where login='" + login + "'"
                );

                if (resultSet.next()) {

                    sameLogin = true;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return sameLogin;
    }



}
