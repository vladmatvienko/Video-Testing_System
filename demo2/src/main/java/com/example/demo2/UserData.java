package com.example.demo2;
public class UserData {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String fatherName;
    private String birthDate;
    private String group;
    private String secretQuestion;
    private String email;
    private int access;
    private String phoneNumber;
    private String secretAnswer;

    public void setSecretAnswer(String secretAnswer){
        this.secretAnswer = secretAnswer;
    }
    public String getSecretAnswer(){
        return secretAnswer;
    }
    //Нужно сделать регулярки для каждого метода Set

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setAccess(int access){
        this.access = access;
    }
    public int getAccess(){
        return access;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;}
    public void setPassword(String password){//Нужно зациклить ввод пароля, пока он не надежен вводится новый

            this.password = password;
    }
    public String getPassword(){
        return password;
    }public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }public void setFatherName(String fatherName){
        this.fatherName = fatherName;
    }
    public String getFatherName(){
        return fatherName;
    }public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    public String getBirthDate(){
        return birthDate;
    }public void setGroup(String group){
        this.group = group;
    }
    public String getGroup(){
        return group;
    }public void setSecretQuestion(String secretQuestion){
        this.secretQuestion = secretQuestion;
    }
    public String getSecretQuestion(){
        return secretQuestion;
    }public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;}
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
}