package com.social_network.Model;

import java.util.ArrayList;

/** Класс, содержащий основную информацию о пользователе  */
public class User {
   private String login;
    private String password;
    private String name;
    private int age;
    private String education;
    private String interests;
    private String filePath;

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    private String OnlineFrom;
    private int visits;

    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits / 2;
    }

    public User() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public User(String login, String password, String name, int age,
                String education, String OnlineFrom, String interests,
                String  filePath) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
        this.education = education;
        this.OnlineFrom = OnlineFrom;
        this.interests = interests;
        this.filePath = filePath;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOnlineFrom() {
        return OnlineFrom;
    }

    public void setOnlineFrom(String onlineFrom) {
        OnlineFrom = onlineFrom;
    }
}
