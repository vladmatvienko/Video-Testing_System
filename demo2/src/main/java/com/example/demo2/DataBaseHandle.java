package com.example.demo2;
import java.sql.*;
import java.util.ArrayList;
//класс контроля действий с БД, писать все методы, связанные с работой с БД здесь
public class DataBaseHandle extends Configs {
    Connection dbConnection;
    // метод подключения к БД, возвращает подключение
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
     String connectionString = "jdbc:mysql://" + dbHost + ":" +
             dbPort + "/" + dbName;
     Class.forName("com.mysql.cj.jdbc.Driver"); // драйвер необходимо скачать
             dbConnection = DriverManager.getConnection(connectionString,
                    dbUser, dbPass);
     return dbConnection;
    }
    // метод добавление пользователя
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
    //возвращает ArrayList всех логинов
    public ArrayList<String> getLoginArray() throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM " + Const.USER_TABLE; // сюда пишем команду MySQL
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);
        ArrayList<String> loginsArray = new ArrayList<>();
        while (resultSet.next()){
            loginsArray.add(resultSet.getString("login")); //название нужной колонки

        }
        return loginsArray;
    }
    // метод получения паролей, все точно также, как и в логинах
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
    // метод получения ответа на секретный вопрос
    // добавить в БД секретный вопрос
    public StringBuilder getSecretAnswer(String login) throws SQLException, ClassNotFoundException {
        //String insert = "SELECT" + Const.USER_SECRETANSWER +  "FROM " + Const.USER_TABLE + "WHERE" + Const.USER_ID = " + id + "; команда выдает ошибку
        String insert1 = "SELECT "+ Const.USER_SECRETANSWER+" FROM "+ Const.USER_TABLE+" WHERE "+Const.USER_lOGIN +" = '"+login+"' ";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert1);
        //ArrayList<String> secretAnswerArray = new ArrayList<>(); // если нужно будет переделать в массив
        StringBuilder stringAnswer = new StringBuilder();
        while (resultSet.next()){
            stringAnswer.append(resultSet.getString("secretQuestion"));
        }
        return stringAnswer;
    }

}
