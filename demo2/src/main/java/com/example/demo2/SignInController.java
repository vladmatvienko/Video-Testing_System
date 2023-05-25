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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignInController {

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
    void onRegistrationLinkClick(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SignUp.fxml"));
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
        user.setLogin(String.valueOf(loginField));
        if(dataBase.getLoginArray().contains(user.getLogin())){
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


    }

}