package com.example.viseo_test;

import java.sql.*;
import java.util.ArrayList;
//класс контроля действий с БД, писать все методы, связанные с работой с БД здесь
public class DataBaseHandler extends Configs {
    Connection dbConnection;

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
//    public void SignUpUser(String name) { //включить остальные параметры пользователя // зачем нам остальные парамерты если для входа нужен только мейл и пароль?
//        String insert = //"INSERT INTO users(name)\n"+"VALUES(?)";
//                "INSERT INTO" + " " + Const.USER_TABLE + "("
//                        + Const.USERS_NAME + ")" + " " + "VALUES(?)"; //какая-то ошибка считывания и подключения //возможно нужно в скобки занести всё это дело
//        try {
//            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
//            prSt.setString(1, name); //проверить считает с нуля или 1
//            //изменить метод для вставки фамилии, почты и тд по аналогии...
//
//            prSt.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void blockUser(String Id) { //блокировка пользователя и чтобы потом ему показывались только резы
        try {
            Connection connection = getDbConnection();
            Statement statement = connection.createStatement(); //подключаюсь к SQL

            String selectResults = "SELECT * FROM Results WHERE user_id = " + Id; // Получаем результаты тестов пользователя, мне нужно знать как называется бд с результатами (Results??) и колонка с айди(user_id??)
            ResultSet resultSet = statement.executeQuery(selectResults);

            while (resultSet.next()) { // Переносим результаты тестов в таблицу Blocked_Users (В ней столбцы user_id, result_id)
                int resultId = resultSet.getString("result_id");
                String insertBlockedUser = "INSERT INTO Blocked_Users (user_id, result_id,) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertBlockedUser);
                preparedStatement.setString(1, Id);
                preparedStatement.setString(2, resultId);
                preparedStatement.executeUpdate();
            }

            String deleteUser = "DELETE FROM Users WHERE user_id = " + Id; // Удаляем пользователя из таблицы Users, чтобы он не мог войти как обычно
            statement.executeUpdate(deleteUser);

            // Также чтобы корректно работало возможно нужно закрыть соединение с базой данных:
            //resultSet.close();
            //statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при блокировке пользователя: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке драйвера базы данных: " + e.getMessage());
        }
    }
    public void SignUpUser(String[] args) {
        String id = "12345";
        String login = "Shest";
        String password = "Za";
        String name = "Denis";
        String surname = "Hse";
        String fatherName = "Alexebich";
        String birthDate = "13/06/2004";
        String group = "male";
        String secretQuestion = "Why are you";
        String email = "example@com";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");

            // Добавление нового пользователя со всеми данными by Denis
            String insertUser = "INSERT INTO users (id, login, password, name, surname, fatherName, birthDate, group, secretQuestion, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, surname);
            preparedStatement.setString(6, fatherName);
            preparedStatement.setString(7, birthDate);
            preparedStatement.setString(8, group);
            preparedStatement.setString(9, secretQuestion);
            preparedStatement.setString(10, email);
            preparedStatement.executeUpdate(); //выше создание пользователя

            //Редактирование информации (кроме логина, пароля, айди и секретного вопроса)
            String updateUser = "UPDATE users SET name = ?, surname = ?, fatherName = ?, birthDate = ?, group = ?, email = ?";
            preparedStatement = connection.prepareStatement(updateUser);
            String newname = "newn";
            String newsurname = "New s";
            String newfatherName = "New f";
            String newbirthDate = "13/07.2004";
            String newgroup = "New g";
            String newemail = "New e";
            int userId = 1;
            preparedStatement.setString(1, newname);
            preparedStatement.setString(2, newsurname);
            preparedStatement.setString(3, newfatherName);
            preparedStatement.setDate(4, newbirthDate);
            preparedStatement.setString(5, newgroup);
            preparedStatement.setDate(6, newemail);
            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }
}
        }
    }
}
