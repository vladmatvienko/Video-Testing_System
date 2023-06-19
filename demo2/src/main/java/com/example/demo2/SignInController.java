package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class SignInController {


    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;


    @FXML
    private Label incorrectLogin;

    @FXML
    private Label incorrectPassword;

    @FXML
    private Label banText;

    public static String loginOfCurrentUser;

    @FXML
    private Hyperlink resetPasswordLink;



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

        user.setLogin(String.valueOf(login_field.getText()));
        //user.setSecretQuestion(String.valueOf(secretQuestionField.getText())); секретный вопрос не здесь
        DataBaseHandle dataBase = new DataBaseHandle();

        /*if(!dataBase.getSecretAnswer(user.getLogin()).toString().equals(user.getSecretQuestion())){
            HelloApplication.switchToNewWindow("MessageToAdmin");
            dataBase.ban(loginOfCurrentUser);
            //переход в окно работы с админом и написания текста
             }
        else {
            //восстановление пароля
           HelloApplication.switchToNewWindow("СhangePassword");
        }*/
    }

    @FXML
    void initialize(){
        incorrectPassword.setVisible(false);
        incorrectLogin.setVisible(false);
        banText.setVisible(false);
        resetPasswordLink.setVisible(false);
        loginOfCurrentUser = login_field.getText();
       // secretQuestionField.setVisible(false); //вставить окно с ответом на секретный вопрос
    }
    @FXML
    void newInputLog(KeyEvent event) {
        incorrectLogin.setVisible(false);

    }

    @FXML
    void newInputPass(KeyEvent event) {
         incorrectPassword.setVisible(false);
    }
    @FXML
    void onSigINButtonClick(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserData user = new UserData();
        DataBaseHandle dataBase = new DataBaseHandle();
        user.setLogin(String.valueOf(login_field.getText()));
        user.setPassword(String.valueOf(password_field.getText()));
        //dataBase.getLoginArray();
        if(HelloApplication.passwordInputEfforts == 5 ){
            resetPasswordLink.setVisible(true);
            banText.setVisible(true);
            // System.out.println(login_field.getText());
            dataBase.ban(loginOfCurrentUser);

            //HelloApplication.switchToNewWindow("Создать файл для проверки секретного слова");
            //нужно подключить ввод секретного слова в этом же месте или в другом окне
             //secretQuestionField.setVisible(true);
           // if(!dataBase.getSecretAnswer(user.getLogin()).toString().equals(user.getSecretQuestion())){
              //  System.exit(0);
                //переход в окно работы с админом и написания текста
           // }
        }
        if(dataBase.getLoginArray().contains(user.getLogin()) && dataBase.getPasswordArray().contains(user.getPassword()))
        {   System.out.println(user.getLogin());
            if(dataBase.checkAccess(user.getLogin()) == 0){
                System.out.println("Нет доступа !");
                banText.setVisible(true);
                } else if (dataBase.checkAccess(user.getLogin()) == 1) {
                //переход в окно приложения
                System.out.println("Я узнаю Вас, велКам!");
            }
            HelloApplication.switchToNewWindow("VideoChange");

        }
                  else if(!dataBase.getLoginArray().contains(user.getLogin())){
                      System.out.println("Неверный  логин!");
                      login_field.setText(null);
                      incorrectLogin.setVisible(true);


                          }

        // метод неправильно введенного несколько раз пароля
        else if(!dataBase.getPasswordArray().contains(user.getPassword())){
            boolean check = false;
            password_field.setText(null);
            incorrectPassword.setVisible(true);
            HelloApplication.passwordInputEfforts ++;
        }
         if (user.getLogin().equals("admin")&&user.getPassword().equals("admin")){
             HelloApplication.switchToNewWindow("AdminPersonalCabinet");
         }
        loginOfCurrentUser = login_field.getText();
    }
    @FXML
    void resetPasswordLinkClick(ActionEvent event) {
        HelloApplication.switchToNewWindow("ResetPass");
    }

}