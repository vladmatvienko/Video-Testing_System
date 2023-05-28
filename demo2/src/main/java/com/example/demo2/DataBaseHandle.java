package com.example.demo2;
import java.sql.*;
import java.util.ArrayList;

public class DataBaseHandle extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
     String connectionString = "jdbc:mysql://" + dbHost + ":" +
             dbPort + "/" + dbName;
     Class.forName("com.mysql.cj.jdbc.Driver");
             dbConnection = DriverManager.getConnection(connectionString,
                    dbUser, dbPass);
     return dbConnection;
    }
    public void SignUpUser(String name){ //включить остальные параметры пользователя
       String insert = //"INSERT INTO users(name)\n"+"VALUES(?)";
        "INSERT INTO" + " " + Const.USER_TABLE + "("
               + Const.USER_NAME + ")" + " " + "VALUES(?)"; //какая-то ошибка считывания и подключения
        try {
       PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, name); //проверить считает с нуля или 1
        //изменить метод для вставки фамилии, почты и тд по аналогии...

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //метод для получения массива с логинами(сделать так, чтобы он брал сразу только логины, а не все)
    public ArrayList<String> getLoginArray() throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM " + Const.USER_TABLE;
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);
        ArrayList<String> loginsArray = new ArrayList<>();
        while (resultSet.next()){
            loginsArray.add(resultSet.getString("login"));

        }
        return loginsArray;
    }
    public ArrayList<String> getPasswordArray() throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM " + Const.USER_TABLE;
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);
        ArrayList<String> passwordsArray = new ArrayList<>();
        while (resultSet.next()){
            passwordsArray.add(resultSet.getString("password"));

        }
        return passwordsArray;
    }
    public ArrayList<String> getSecretAnswer() throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM " + Const.USER_TABLE;
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);
        ArrayList<String> secretAnswerArray = new ArrayList<>();
        while (resultSet.next()){
            secretAnswerArray.add(resultSet.getString("secretQuestion"));
        }
        return secretAnswerArray;
    }

}
