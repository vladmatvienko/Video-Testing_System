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
        prSt.setString(1, name);

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<String> getLoginArray() throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM " + Const.USER_TABLE;
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);
        ArrayList<String> logins = new ArrayList<>();
        while (resultSet.next()){
            logins.add(resultSet.getString("login"));
        }
        return logins;
    }
    //ме для извлечения информации из БД
}
