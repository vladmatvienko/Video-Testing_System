package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class SignInController {

    @FXML
    private Pane SignInPane;

    @FXML
    private Hyperlink RegistationLink;

    @FXML
    private Label SignINLogin;

    @FXML
    private Label SignINPassword;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button SignINButton;

    @FXML
    private Label incorrectLogin;

    @FXML
    private Label incorrectPassword;

    @FXML
    private Label banText;
    //сделать его скрытым по умолчанию есть метод secretQuestionField.setVisible(false);
    @FXML
    private TextField secretQuestionField;



    @FXML
    void onRegistrationLinkClick(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SignUp.fxml"));// Для Влада
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }
    @FXML
    void onSigINButtonClick(ActionEvent event) throws SQLException, ClassNotFoundException {
        UserData user = new UserData();
        DataBaseHandle dataBase = new DataBaseHandle();
        user.setLogin(String.valueOf(loginField.getText()));
        user.setPassword(String.valueOf(passwordField.getText()));
        dataBase.getLoginArray();
        if(HelloApplication.passwordInputEfforts == 5 ){
            //нужно подключить ввод секретного слова в этом же месте или в другом окне

        }
        if(dataBase.getLoginArray().contains(user.getLogin()) && dataBase.getPasswordArray().contains(user.getPassword())){
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(HelloApplication.class.getResource("Proga.fxml"));
           try {
                loader.load();
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
           Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
                  else if(!dataBase.getLoginArray().contains(user.getLogin())){
                           incorrectLogin.setText("Неверный логин");

                          }

        // метод неправильно введенного несколько раз пароля
        else if(!dataBase.getPasswordArray().contains(user.getPassword())){
            boolean check = false;
            passwordField.setText(null);
            incorrectPassword.setText("Неверный пароль");
            HelloApplication.passwordInputEfforts ++;
        }

    }

}