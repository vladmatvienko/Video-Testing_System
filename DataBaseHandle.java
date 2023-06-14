package com.example.adm_it;
import java.util.HashMap;
import java.sql.*;
import java.util.ArrayList;
//класс контроля действий с БД, писать все методы, связанные с работой с БД здесь
public class DataBaseHandle extends Configs {
    public static Statement statement = null;
    static Connection dbConnection;

    // метод подключения к БД, возвращает подключение
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver"); // драйвер необходимо скачать
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    // метод добавление пользователя
    public void SignUpUser(String name) throws RuntimeException { //включить остальные параметры пользователя
        String insert = //"INSERT INTO users(name)\n"+"VALUES(?)";
                "INSERT INTO" + " " + Const.USER_TABLE + "("
                        + Const.USER_NAME + ")" + " " + "VALUES(?)"; //какая-то ошибка считывания и подключения
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            //prSt.setString(2, group);
            //prSt.setString(3, password);
            //prSt.setString(4, login);//проверить считает с нуля или 1
            //изменить метод для вставки фамилии, почты и тд по аналогии...

            prSt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void changeInf(int ID, String EXPL){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/1?serverTimezone=Europe/Moscow&useSSL=false", "root", "root")){

            Statement statement = conn.createStatement();


            int rows = statement.executeUpdate("UPDATE users SET access = 0 WHERE id=" + ID);
            int row = statement.executeUpdate("UPDATE users SET block_expl= " + "'" + EXPL + "'" + " WHERE id=" + ID);
            System.out.printf("Updated %d rows", rows);
            System.out.printf("Updated %d rows", row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void RoleInfUser(int ID){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/1?serverTimezone=Europe/Moscow&useSSL=false", "root", "root")){

            Statement statement = conn.createStatement();
            int row = statement.executeUpdate("UPDATE `users` SET `group` = 'user' WHERE `id`=" + ID);

            System.out.printf("Updated %d rows", row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void RoleInfAnalytic(int ID){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/1?serverTimezone=Europe/Moscow&useSSL=false", "root", "root")){

            Statement statement = conn.createStatement();
            int row = statement.executeUpdate("UPDATE `users` SET `group` = 'analytic' WHERE `id`=" + ID);

            System.out.printf("Updated %d rows", row);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void GetPersonalInformation() throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/1?serverTimezone=Europe/Moscow&useSSL=false", "root", "root")){

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while(resultSet.next()){

                int id = resultSet.getInt("id");
                int access = resultSet.getInt("access");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String group = resultSet.getString("group");
                String password = resultSet.getString("password");
                String block_expl = resultSet.getString("block_expl");
                System.out.printf("id: %d.  name: %s  login: %s  group: %s  password: %s  access: %d  block_explanation: %s \n", id, name, login, group, password, access, block_expl);
            }
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }


