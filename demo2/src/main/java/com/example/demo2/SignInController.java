package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
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
    @FXML
    void onRegistrationLinkClick(ActionEvent event) {
       HelloApplication.switchToNewWindow("SignUp");

    }
    @FXML
    void initialize(){
        incorrectPassword.setVisible(false);
        incorrectLogin.setVisible(false);
        banText.setVisible(false);
        resetPasswordLink.setVisible(false);
        loginOfCurrentUser = login_field.getText().trim();
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
        user.setLogin(login_field.getText().trim());
        user.setPassword(password_field.getText().trim());
        if(HelloApplication.passwordInputEfforts == 5 ){
            resetPasswordLink.setVisible(true);
            banText.setVisible(true);
            dataBase.ban(loginOfCurrentUser);
        }
        if(dataBase.getLoginArray().contains(user.getLogin()) && dataBase.getPasswordArray().contains(user.getPassword())&&!user.getLogin().trim().equals("admin")&&!user.getPassword().equals("admin"))
        {   System.out.println(user.getLogin().trim());
            if(dataBase.checkAccess(user.getLogin().trim()) == 0){
                System.out.println("Нет доступа !");
                HelloApplication.switchToNewWindow("MessageToAdmin");
                banText.setVisible(true);
                } else if (dataBase.checkAccess(user.getLogin().trim()) == 1) {
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
            password_field.setText(null);
            incorrectPassword.setVisible(true);
            HelloApplication.passwordInputEfforts ++;
        }
         if (user.getLogin().trim().equals("admin")&&user.getPassword().equals("admin")){
             HelloApplication.switchToNewWindow("AdminPersonalCabinet");
         }
        loginOfCurrentUser = login_field.getText().trim();
    }
    @FXML
    void resetPasswordLinkClick(ActionEvent event) {
        HelloApplication.switchToNewWindow("ResetPass");
    }

}