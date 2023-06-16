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
    public void SignUpUser(String login, String password, String name, String surname, String fatherName, String birthDate, String group,
                            String secretQuestion, String email, String phoneNumber, int access, String
                           secretAnswer){ //включить остальные параметры пользователя
       String insert = //"INSERT INTO users(name)\n"+"VALUES(?)";
       //INSERT INTO `1`.`users` (`id`, `login`, `password`, `name`, `surname`, `fatherName`, `birthDate`, `group`, `secretQuestion`, `email`, `phoneNumber`, `access`) VALUES ('lol', 'lol', 'lol', 'lol', 'lol', 'lol', 'lol', 'lol', 'lol', 'lol', 'lol', 'lol');
        "INSERT INTO" + " " + Const.USER_TABLE + "("
               +"`"+ Const.USER_NAME + "`, `" + Const.USER_SURNAME + "`, `" + Const.USER_EMAIL + "`, `" + Const.USER_lOGIN +
                "`, `" + Const.USER_PASSWORD + "`, `" +
                Const.USER_FATHERNAME + "`, `" + Const.USER_BIRTHDATE + "`, `" + Const.USER_GROUP + "`, " +
                "`" + Const.USER_SECRET_QUESTION + "`, `" + Const.USER_PHONENUMBER + "`, `"
                + Const.USER_ACCESS + "`, `"+Const.USER_SECRETANSWER+"`)" +  " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"; //какая-то ошибка считывания и подключения
        try {
       PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, login); //проверить считает с нуля или 1
        //изменить метод для вставки фамилии, почты и тд по аналогии...
        prSt.setString(2, password);
        prSt.setString(3, name);
        prSt.setString(4, surname);
        prSt.setString(5, fatherName);
        prSt.setString(6, birthDate);
        prSt.setString(7, group);
        prSt.setString(8, secretQuestion);
        prSt.setString(9, email);
        prSt.setString(10, phoneNumber);
        prSt.setInt(11, access );
        prSt.setString(12, secretAnswer);
        prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
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
    public String getSecretQuestion(String login) throws SQLException, ClassNotFoundException {
        //String insert = "SELECT" + Const.USER_SECRETANSWER +  "FROM " + Const.USER_TABLE + "WHERE" + Const.USER_ID = " + id + "; команда выдает ошибку
        String insert1 = "SELECT "+ "`"+ Const.USER_SECRET_QUESTION + "`"+" FROM "+ "`"+ Const.USER_TABLE + "`"+" WHERE "+ "`"+Const.USER_lOGIN + "`"+" = '"+login+"' ";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert1);
        //ArrayList<String> secretAnswerArray = new ArrayList<>(); // если нужно будет переделать в массив
        String stringAnswer = null;
        while (resultSet.next()){
            stringAnswer = resultSet.getString("secretQuestion");
        }
        return stringAnswer;
    }
    public String getThisPassword(String login) throws SQLException, ClassNotFoundException {
        String insert = "SELECT " + Const.USER_PASSWORD + " FROM " + Const.USER_TABLE + " WHERE " + Const.USER_lOGIN + " = '" + login + "'";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);
        String password = null;
        while (resultSet.next()) {
            password = resultSet.getString("password");
        }
        return password;
    }//ошибка Illegal operation on empty result set.*/ проверить работоспособность
    public void setPassword(String password, String login) throws SQLException, ClassNotFoundException {
        //UPDATE elements SET n2 = 30 WHERE id = 22;
        String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD+ " = '"+password+"' "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(insert);

    }
     public void ban(String login) throws SQLException, ClassNotFoundException {
         String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_ACCESS+ " = 0 "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
         Statement statement = getDbConnection().createStatement();
         statement.executeUpdate(insert);
    }
     public void antiban(String login) throws SQLException, ClassNotFoundException {
         String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_ACCESS+ " = 1 "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
         Statement statement = getDbConnection().createStatement();
         statement.executeUpdate(insert);

     }
      public int checkAccess(String login) throws SQLException, ClassNotFoundException {
        String insert = "SELECT " + "`"+ Const.USER_ACCESS+ "`"+ " FROM " + "`"+ Const.USER_TABLE+ "`"+" WHERE "+ "`"+Const.USER_lOGIN + "`"+" = '"+login+"' ";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);
        int access = 3;
          while (resultSet.next()){
              access = resultSet.getInt("access");
              //System.out.println(access);
              }
       return access;
    }
     public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        //DELETE FROM `1`.`users` WHERE (`id` = '5');
        String insert = "DELETE FROM " + "`"+ Const.USER_TABLE  +"` "+ "WHERE " + "(`"+ Const.USER_ID  +"`" +" = '"+id+"') ";
         Statement statement = getDbConnection().createStatement();
         statement.executeUpdate(insert);
     }
     public int takeIdFromDb(String login) throws SQLException, ClassNotFoundException {
        String insert =  "SELECT " + Const.USER_ID + " FROM " + Const.USER_TABLE+" WHERE "+Const.USER_lOGIN +" = '"+login+"' ";
         Statement statement = getDbConnection().createStatement();
         ResultSet resultSet = statement.executeQuery(insert);
         int id = 0;
         while (resultSet.next()){
             id = resultSet.getInt("id");
             //System.out.println(access);
         }
         return id;
     }

     public void setSecretAnswer(String login, String secretAnswer) throws SQLException, ClassNotFoundException {
         String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_SECRETANSWER+ " = '"+secretAnswer+"' "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
         Statement statement = getDbConnection().createStatement();
         statement.executeUpdate(insert);
     }
    public void setSecretQuestion(String login, String secretQuestion) throws SQLException, ClassNotFoundException {
        String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_SECRET_QUESTION+ " = '"+secretQuestion+"' "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(insert);
    }

    public StringBuilder getPersonalInformation() throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+ Const.USER_TABLE);
            StringBuilder strb = new StringBuilder();
            while(resultSet.next()){

                int id = resultSet.getInt("id");
                int access = resultSet.getInt("access");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String group = resultSet.getString("group");
                String password = resultSet.getString("password");
                //String block_expl = resultSet.getString("block_expl");
                String str = String.format("id: %d.  name: %s  login: %s  group: %s  password: %s  access: %d \n", id, name, login, group, password, access/*, block_expl*/);
                strb.append(str);
                System.out.println(str);

            }
            return strb;
        }
    public void RoleInfUser(int ID) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate("UPDATE " + "`"+ Const.USER_TABLE+ "` SET " +"`"+Const.USER_GROUP+"` = 'user' WHERE " + "`" + Const.USER_ID+ "` = '"+ID+"'");
    }
    public void RoleInfAnalytic(int ID) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate("UPDATE " + "`"+ Const.USER_TABLE+ "` SET " +"`"+Const.USER_GROUP+"` = 'analytic' WHERE " + "`" + Const.USER_ID+ "` = '"+ID+"'");
    }
    public void changeInf(int ID, String EXPL) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate("UPDATE " + "`"+ Const.USER_TABLE+ "` SET " +"`"+Const.USER_BLOCK_EXPL+"`"+ "= '"+EXPL+"'" + " WHERE " + "`" + Const.USER_ID+ "` = '"+ID+"'");
    }


    }

