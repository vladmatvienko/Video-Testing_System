package com.example.demo2;

import java.util.regex.*;
/**
 * Класс предназначен для сортировки данных пользователя в зависимости от пользователя
 * @author bli34
 * @version 1.0.0
 */
public class UserData {
    /**
     * @param id ID пользователя
     * @author bli34
     * @version 1.0.0
     */
    private int id;
    /**
     * @param login логин пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String login;
    /**
     * @param password пароль пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String password;
    /**
     * @param name имя пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String name;
    /**
     * @param surname фамилия пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String surname;
    /**
     * @param fatherName отчество пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String fatherName;
    /**
     * @param birthDate дата рождения пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String birthDate;
    /**
     * @param group группа пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String group;
    /**
     * @param secretQuestion секретный вопрос пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String secretQuestion;
    /**
     * @param email почта пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String email;
    /**
     * @param access доступ пользователя
     * @author bli34
     * @version 1.0.0
     */
    private int access;
    /**
     * @param phoneNumber номер пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String phoneNumber;
    /**
     * @param secretAnswer ответ пользователя
     * @author bli34
     * @version 1.0.0
     */
    private String secretAnswer;
    /**
     * @param secretAnswer параметр, благодаря которому выполняется метод setSecretAnswer
     * setSecretAnswer() метод, сохраняющий ответ на секретный опрос пользовател
     * @author bli34
     * @version 1.0.0
     */
    public void setSecretAnswer(String secretAnswer){
        this.secretAnswer = secretAnswer;
    }

    public String getSecretAnswer(){
        return secretAnswer;
    }
    //Нужно сделать регулярки для каждого метода Set
    /**
     * @param id параметр, благодаря которому выполняется метод setSecretAnswer
     * setSecretAnswer() метод, сохраняющий ID пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    /**
     * @param access параметр, благодаря которому выполняется метод setAccess
     * setAccess() метод, сохраняющий уровень доступ пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setAccess(int access){
        this.access = access;
    }
    /**
     * getAccess() метод получения уровня доступа из сохраненной БД
     * @return возвращает уровень доступа пользователя access
     * @author bli34
     * @version 1.0.0
     */
    public int getAccess(){
        return access;
    }
    /**
     * @param login параметр, благодаря которому выполняется метод setLogin
     * setLogin() метод, сохраняющий логин пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setLogin(String login){
        this.login = login;
    }
    /**
     * getLogin() метод получения логина из сохраненной БД
     * @return возвращает логин пользователя login
     * @author bli34
     * @version 1.0.0
     */
    public String getLogin(){
        return login;}
    /**
     * @param password параметр, благодаря которому выполняется метод setPassword
     * setPassword() метод, сохраняющий пароль пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setPassword(String password){//Нужно зациклить ввод пароля, пока он не надежен вводится новый
       /*String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*_).{8,20}$";
        Pattern CheckThePassword = Pattern.compile(passwordPattern);
        Matcher m = CheckThePassword.matcher(password);
        if(m.matches() == true) {
*/
            this.password = password;
       /* }
        else{
            System.out.println("Введите пароль надежнее!");
        }*/
    }
    /**
     * getPassword() метод получения пароля из сохраненной БД
     * @return возвращает пароль пользователя password
     * @author bli34
     * @version 1.0.0
     */
    public String getPassword(){
        return password;
    }
    /**
     * @param name параметр, благодаря которому выполняется метод setName
     * setName() метод, сохраняющий имя пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * getName() метод получения имени из сохраненной БД
     * @return возвращает имя пользователя name
     * @author bli34
     * @version 1.0.0
     */
    public String getName(){
        return name;
    }
    /**
     * @param surname параметр, благодаря которому выполняется метод setSurname
     * setSurname() метод, сохраняющий фамилия пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setSurname(String surname){
        this.surname = surname;
    }
    /**
     * getSurname() метод получения фамилии из сохраненной БД
     * @return возвращает фамилия пользователя surname
     * @author bli34
     * @version 1.0.0
     */
    public String getSurname(){
        return surname;
    }
    /**
     * @param fatherName параметр, благодаря которому выполняется метод setFatherName
     * setFatherName() метод, сохраняющий отчество пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setFatherName(String fatherName){
        this.fatherName = fatherName;
    }
    /**
     * getFatherName() метод получения отчества из сохраненной БД
     * @return возвращает отчество пользователя fatherName
     * @author bli34
     * @version 1.0.0
     */
    public String getFatherName(){
        return fatherName;
    }
    /**
     * @param birthDate параметр, благодаря которому выполняется метод setBirthDate
     * setBirthDate() метод, сохраняющий ID пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    /**
     * getBirthDate() метод получения даты рождения из сохраненной БД
     * @return возвращает дату рождения пользователя birthDate
     * @author bli34
     * @version 1.0.0
     */
    public String getBirthDate(){
        return birthDate;
    }
    /**
     * @param group параметр, благодаря которому выполняется метод setGroup
     * setGroup() метод, сохраняющий группу пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setGroup(String group){
        this.group = group;
    }
    /**
     * getGroup() метод получения группы из сохраненной БД
     * @return возвращает группу пользователя group
     * @author bli34
     * @version 1.0.0
     */
    public String getGroup(){
        return group;
    }
    /**
     * @param secretQuestion параметр, благодаря которому выполняется метод setSecretQuestion
     * setSecretQuestion() метод, сохраняющий секретный вопрос пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setSecretQuestion(String secretQuestion){
        this.secretQuestion = secretQuestion;
    }
    /**
     * getSecretQuestion() метод получения секретного вопроса из сохраненной БД
     * @return возвращает секретный вопрос пользователя secretQuestion
     * @author bli34
     * @version 1.0.0
     */
    public String getSecretQuestion(){
        return secretQuestion;
    }
    /**
     * @param email параметр, благодаря которому выполняется метод setEmail
     * setEmail() метод, сохраняющий почту пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setEmail(String email){
        this.email = email;
    }
    /**
     * getEmail() метод получения почты из сохраненной БД
     * @return возвращает почту пользователя email
     * @author bli34
     * @version 1.0.0
     */
    public String getEmail(){
        return email;}
    /**
     * @param phoneNumber параметр, благодаря которому выполняется метод setPhoneNumber
     * setPhoneNumber() метод, сохраняющий номер пользователя
     * @author bli34
     * @version 1.0.0
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    /**
     * getPhoneNumber() метод получения телефона из сохраненной БД
     * @return возвращает телефон пользователя phoneNumber
     * @author bli34
     * @version 1.0.0
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
}