package com.example.demo2;
import java.sql.*;
import java.util.ArrayList;

/**
 * Класс контроля действий с БД, родоначальником которого является Configs
 * @author bli34
 * @version 1.0.0
 */
public class DataBaseHandle extends Configs {
    /**
     * @param dbConnection подключение к базе данных
     * @author bli34
     * @version 1.0.0
     */
    Connection dbConnection;
    /**
     * getDbConnection метод подключения к БД
     * @throws ClassNotFoundException в случае не выполнения getDbConnection
     * @throws SQLException в случае не выполнения getDbConnection
     * @return возвращает dbConnection
     * @author bli34
     * @version 1.0.0
     */

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
     String connectionString = "jdbc:mysql://" + dbHost + ":" +
             dbPort + "/" + dbName;
     Class.forName("com.mysql.cj.jdbc.Driver"); // драйвер необходимо скачать
             dbConnection = DriverManager.getConnection(connectionString,
                    dbUser, dbPass);
     return dbConnection;
    }
    /**
     * SignUpUser добавление пользователя в БД
     * @author bli34
     * @version 1.0.0
     */
    public void SignUpUser(String login, String password, String name, String surname, String fatherName, String birthDate, String group,
                            String secretQuestion, String email, String phoneNumber, int access, String
                           secretAnswer){
        /**
         * @param insert параметр, который добавляет другие параметры пользователя
         * @throws RuntimeException(e) в случае, если информация о пользователях не добавилась
         * @author bli34
         * @version 1.0.0
         */
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
    /**
     * getLoginArray() метод получения логинов без другой информации
     * @throws ClassNotFoundException в случае не выполнения getLoginArray()
     * @throws SQLException в случае не выполнения getLoginArray()
     * @return возвращает массив всех логинов loginsArray
     * @author bli34
     * @version 1.0.0
     */
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
    /**
     * getLoginArray() метод получения паролей без другой информации
     * @throws ClassNotFoundException в случае не выполнения getPasswordArray()
     * @throws SQLException в случае не выполнения getPasswordArray()
     * @return возвращает массив всех паролей passwordsArray
     * @author bli34
     * @version 1.0.0
     */
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
    /**
     * @param login нужен для получения секретного вопроса, в соотоветствии с самим пользователем
     * getSecretQuestion() метод получения секретного вопроса без другой информации
     * @throws ClassNotFoundException в случае не выполнения getSecretQuestion()
     * @throws SQLException в случае не выполнения getSecretQuestion()
     * @return возвращает массив всех секретных вопросов stringQuestion
     * @author bli34
     * @version 1.0.0
     */
    // метод получения ответа на секретный вопрос
    // добавить в БД секретный вопрос
    public String getSecretQuestion(String login) throws SQLException, ClassNotFoundException {

        String insert1 = "SELECT "+ "`"+ Const.USER_SECRET_QUESTION + "`"+" FROM "+ "`"+ Const.USER_TABLE + "`"+" WHERE "+ "`"+Const.USER_lOGIN + "`"+" = '"+login+"' ";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert1);
        //ArrayList<String> secretAnswerArray = new ArrayList<>(); // если нужно будет переделать в массив
        String stringQuestion = "0";
        while (resultSet.next()){
            stringQuestion = resultSet.getString("secretQuestion");
        }
        return stringQuestion;
    }
    /**
     * @param login нужен для получения ответа на секретный вопрос, в соотоветствии с самим пользователем
     * getSecretAnswer() метод получения ответов на секретный вопрос без другой информации
     * @throws ClassNotFoundException в случае не выполнения getSecretAnswer()
     * @throws SQLException в случае не выполнения getSecretAnswer()
     * @return возвращает массив всех ответов на св stringAnswer
     * @author bli34
     * @version 1.0.0
     */
    public String getSecretAnswer(String login) throws SQLException, ClassNotFoundException {

        String insert1 = "SELECT "+ "`"+ Const.USER_SECRETANSWER + "`"+" FROM "+ "`"+ Const.USER_TABLE + "`"+" WHERE "+ "`"+Const.USER_lOGIN + "`"+" = '"+login+"' ";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert1);
        //ArrayList<String> secretAnswerArray = new ArrayList<>(); // если нужно будет переделать в массив
        String stringAnswer = "0";
        while (resultSet.next()){
            stringAnswer = resultSet.getString("secretAnswer");
        }
        return stringAnswer;
    }
    /**
     * @param login нужен для получения пароля, в соотоветствии с самим пользователем
     * getThisPassword() метод получения пароля без другой информации
     * @throws ClassNotFoundException в случае не выполнения getThisPassword()
     * @throws SQLException в случае не выполнения getThisPassword()
     * @return возвращает массив всех паролей password
     * @author bli34
     * @version 1.0.0
     */
    public String getThisPassword(String login) throws SQLException, ClassNotFoundException {
        String insert = "SELECT * FROM "+ Const.USER_TABLE;
        //String insert = "SELECT " + Const.USER_PASSWORD + " FROM " + Const.USER_TABLE + " WHERE " + Const.USER_lOGIN + " = '" + login + "'";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insert);
        String password = null;
        while (resultSet.next()) {
            password = resultSet.getString("password");
        }
        return password;
    }//ошибка Illegal operation on empty result set.*/ проверить работоспособность
    /**
     * @param login нужен для установки пароля, в соотоветствии с самим пользователем
     * @param password нужен для установки пароля, в соотоветствии с введенным паролем
     * setPassword() метод установки пароля
     * @throws ClassNotFoundException в случае не выполнения setPassword()
     * @throws SQLException в случае не выполнения setPassword()
     * @author bli34
     * @version 1.0.0
     */
    public void setPassword(String password, String login) throws SQLException, ClassNotFoundException {
        //UPDATE elements SET n2 = 30 WHERE id = 22;
        // String insert = "UPDATE `users` SET `password` = '"+password+"' WHERE (`login` = '"+login+"')";
        String insert = "UPDATE " +"`"+ Const.USER_TABLE +"`"+ " SET " +"`"+ Const.USER_PASSWORD+"`"+ " = '"+password+"' "+ "WHERE " +"(`"+ Const.USER_lOGIN+"`"+ " = '"+login+"')";
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(insert);

    }
    /**
     * @param login нужен для исключения пользователя, в соотоветствии с самим пользователем
     * ban() метод исключения пользователя
     * @throws ClassNotFoundException в случае не выполнения ban()
     * @throws SQLException в случае не выполнения ban()
     * @author bli34
     * @version 1.0.0
     */
     public void ban(String login) throws SQLException, ClassNotFoundException {
         String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_ACCESS+ " = 0 "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
         Statement statement = getDbConnection().createStatement();
         statement.executeUpdate(insert);
    }
    /**
     * @param login нужен для восстановления пользователя, в соотоветствии с самим пользователем
     * antiban() метод восстановления пользователя
     * @throws ClassNotFoundException в случае не выполнения antiban()
     * @throws SQLException в случае не выполнения antiban()
     * @author bli34
     * @version 1.0.0
     */
     public void antiban(String login) throws SQLException, ClassNotFoundException {
         String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_ACCESS+ " = 1 "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
         Statement statement = getDbConnection().createStatement();
         statement.executeUpdate(insert);

     }
    /**
     * @param login нужен для проверки доступа пользователя, в соотоветствии с самим пользователем
     * checkAccess() метод проверки доступа пользователя
     * @throws ClassNotFoundException в случае не выполнения checkAccess()
     * @throws SQLException в случае не выполнения checkAccess()
     * @return возвращает доступ пользователю access, в соответствии с состоянием его доступа
     * @author bli34
     * @version 1.0.0
     */
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
    /**
     * @param id нужен для проверки пользователя и дальнейшего удаления
     * deleteUser() метод удаления пользователя
     * @throws ClassNotFoundException в случае не выполнения deleteUser()
     * @throws SQLException в случае не выполнения deleteUser()
     * @author bli34
     * @version 1.0.0
     */
     public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        //DELETE FROM `1`.`users` WHERE (`id` = '5');
        String insert = "DELETE FROM " + "`"+ Const.USER_TABLE  +"` "+ "WHERE " + "(`"+ Const.USER_ID  +"`" +" = '"+id+"') ";
         Statement statement = getDbConnection().createStatement();
         statement.executeUpdate(insert);
     }
    /**
     * @param login нужен для проверки ID пользователя в соответствии с самиим пользователем
     * takeIdFromDb() метод для взятия ID пользователя из БД
     * @throws ClassNotFoundException в случае не выполнения takeIdFromDb()
     * @throws SQLException в случае не выполнения takeIdFromDb()
     * @return возвращает ID пользователя id
     * @author bli34
     * @version 1.0.0
     */
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
    /**
     * @param login нужен для установки СО, в соотоветствии с самим пользователем
     * @param secretAnswer нужен для установки СО, в соотоветствии с введенным ответом на секретный вопрос
     * setSecretAnswer() метод установки СО
     * @throws ClassNotFoundException в случае не выполнения setSecretAnswer()
     * @throws SQLException в случае не выполнения setSecretAnswer()
     * @author bli34
     * @version 1.0.0
     */
     public void setSecretAnswer(String login, String secretAnswer) throws SQLException, ClassNotFoundException {
         String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_SECRETANSWER+ " = '"+secretAnswer+"' "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
         Statement statement = getDbConnection().createStatement();
         statement.executeUpdate(insert);
     }
    /**
     * @param login нужен для установки СВ, в соотоветствии с самим пользователем
     * @param secretQuestion нужен для установки СВ, в соотоветствии с секретным вопросом
     * setSecretQuestion() метод установки СВ
     * @throws ClassNotFoundException в случае не выполнения setSecretQuestion()
     * @throws SQLException в случае не выполнения setSecretQuestion()
     * @author bli34
     * @version 1.0.0
     */
    public void setSecretQuestion(String login, String secretQuestion) throws SQLException, ClassNotFoundException {
        String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_SECRET_QUESTION+ " = '"+secretQuestion+"' "+ "WHERE " + Const.USER_lOGIN + " = '"+login+"'";
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(insert);
    }
    /**
     * getPersonalInformation() метод получения персональной информации, в соответствии со всеми полученными ответами
     * @throws ClassNotFoundException в случае не выполнения getPersonalInformation()
     * @throws SQLException в случае не выполнения getPersonalInformation()
     * @return возвращает значение персональной информации strb
     * @author bli34
     * @version 1.0.0
     */
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
    /**
     * @param ID нужен для получения информации о должности пользователя, в соотоветствии с ID пользователя
     * RoleInfUser() метод получения информации о должности пользователя
     * @throws ClassNotFoundException в случае не выполнения RoleInfUser()
     * @throws SQLException в случае не выполнения RoleInfUser()
     * @author bli34
     * @version 1.0.0
     */
    public void RoleInfUser(int ID) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate("UPDATE " + "`"+ Const.USER_TABLE+ "` SET " +"`"+Const.USER_GROUP+"` = 'user' WHERE " + "`" + Const.USER_ID+ "` = '"+ID+"'");
    }
    /**
     * @param ID нужен для анализа информации о должности пользователя, в соотоветствии с ID пользователя
     * RoleInfUser() метод получения информации о должности пользователя
     * @throws ClassNotFoundException в случае не выполнения RoleInfUser()
     * @throws SQLException в случае не выполнения RoleInfUser()
     * @author bli34
     * @version 1.0.0
     */
    public void RoleInfAnalytic(int ID) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate("UPDATE " + "`"+ Const.USER_TABLE+ "` SET " +"`"+Const.USER_GROUP+"` = 'analytic' WHERE " + "`" + Const.USER_ID+ "` = '"+ID+"'");
    }
    /**
     * @param ID нужен для изменения информации о пользователе, в соотоветствии с ID пользователя
     * @param EXPL нужен для изменения информации о пользователе, в соотоветствии с ответом пользователя
     * changeInf() метод измения информации
     * @throws ClassNotFoundException в случае не выполнения changeInf()
     * @throws SQLException в случае не выполнения changeInf()
     * @author bli34
     * @version 1.0.0
     */
    public void changeInf(int ID, String EXPL) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate("UPDATE " + "`"+ Const.USER_TABLE+ "` SET " +"`"+Const.USER_BLOCK_EXPL+"`"+ "= '"+EXPL+"'" + " WHERE " + "`" + Const.USER_ID+ "` = '"+ID+"'");
    }


    }

