package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class SignInController {

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;
    @FXML
    private Pane SignInPane;
    @FXML
    private Button SignINButton;

    @FXML
    private Label incorrectLogin;

    @FXML
    private Label incorrectPassword;

    @FXML
    private Label banText;

    public static String loginOfCurrentUser;



    //сделать его скрытым по умолчанию есть метод secretQuestionField.setVisible(false);
    @FXML
    private TextField secretQuestionField;
    @FXML
    void onRegistrationLinkClick(ActionEvent event) {
       HelloApplication.switchToNewWindow("SignUp");
    }

    @FXML
    void click(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserData user = new UserData();
        loginOfCurrentUser = login_field.getText();
        user.setLogin(String.valueOf(login_field.getText()));
        //user.setSecretQuestion(String.valueOf(secretQuestionField.getText())); секретный вопрос не здесь
        DataBaseHandle dataBase = new DataBaseHandle();

        if(!dataBase.getSecretAnswer(user.getLogin()).toString().equals(user.getSecretQuestion())){
            HelloApplication.switchToNewWindow("MessageToAdmin");
            dataBase.ban(loginOfCurrentUser);
            //переход в окно работы с админом и написания текста
             }
        else {
            //восстановление пароля
           HelloApplication.switchToNewWindow("СhangePassword");
        }
    }

    @FXML
    void initialize(){

       // secretQuestionField.setVisible(false); //вставить окно с ответом на секретный вопрос
    }
    @FXML
    void onSigINButtonClick(ActionEvent event) throws SQLException, ClassNotFoundException {
        incorrectLogin.setText("");
        UserData user = new UserData();
        DataBaseHandle dataBase = new DataBaseHandle();
        user.setLogin(String.valueOf(login_field.getText()));
        user.setPassword(String.valueOf(password_field.getText()));
        //dataBase.getLoginArray();
        if(HelloApplication.passwordInputEfforts == 5 ){
            HelloApplication.switchToNewWindow("SecretQuestion");
            //нужно подключить ввод секретного слова в этом же месте или в другом окне
             //secretQuestionField.setVisible(true);
           // if(!dataBase.getSecretAnswer(user.getLogin()).toString().equals(user.getSecretQuestion())){
              //  System.exit(0);
                //переход в окно работы с админом и написания текста
           // }
        }
        if(dataBase.getLoginArray().contains(user.getLogin()) && dataBase.getPasswordArray().contains(user.getPassword()))
        {   System.out.println(user.getLogin());
            //System.out.println("1"+ dataBase.checkAccess(loginOfCurrentUser )+ "2");
            if(dataBase.checkAccess(user.getLogin()) == 0){//выводит значение в независимости от логина и параметра доступа?
                System.out.println("Нет доступа !");
                banText.setText("Ваша учетная запись заблокирована!");
                } else if (dataBase.checkAccess(user.getLogin()) == 1) {
                //переход в окно приложения
                System.out.println("Я узнаю Вас, велКам!");
            }




            //HelloApplication.switchToNewWindow("Proga");

        }
                  else if(!dataBase.getLoginArray().contains(user.getLogin())){
                           incorrectLogin.setText("Неверный логин");

                          }

        // метод неправильно введенного несколько раз пароля
        else if(!dataBase.getPasswordArray().contains(user.getPassword())){
            boolean check = false;
            password_field.setText(null);
            incorrectPassword.setText("Неверный пароль");
            HelloApplication.passwordInputEfforts ++;
        }

    }

}